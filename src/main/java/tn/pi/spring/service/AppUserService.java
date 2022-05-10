package tn.pi.spring.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.BeanDefinitionDsl.Role;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import tn.pi.spring.entity.Blacklist;
import tn.pi.spring.entity.User;
import tn.pi.spring.registration.token.ConfirmationToken;
import tn.pi.spring.registration.token.ConfirmationTokenService;
import tn.pi.spring.repository.AppUserRepository;
import tn.pi.spring.repository.BlacklistRepository;



@AllArgsConstructor
@Service
@Slf4j
public class AppUserService implements UserDetailsService {

	
	private final static String USER_NOT_FOUND_MSG = "user with email %s not found";
    private  AppUserRepository appUserRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final ConfirmationTokenService confirmationTokenService;
    private final BlacklistRepository blacklistRepository;

    @Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

		User user = appUserRepository.findByEmail(email).orElse(null);
		System.out.println(email);


		System.out.println(user);
		if (user==null) {
    		
    		log.error("user not found in the data base");
    		throw new UsernameNotFoundException("user not found in the data base");
    		
    	}else {
    		log.info("user !found in the data base");

    	}
    	List<SimpleGrantedAuthority> authorities = getUserAuthority(user.getRole().name());
		System.out.println(user.getUsername());

    
		return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(), authorities);    }
    
		private List<SimpleGrantedAuthority> getUserAuthority(String userRoles) {
			Set<SimpleGrantedAuthority> roles = new HashSet<SimpleGrantedAuthority>();
			
			roles.add(new SimpleGrantedAuthority(userRoles)); 
			List<SimpleGrantedAuthority> grantedAuthorities = new ArrayList<>(roles);
			return grantedAuthorities;
		}
	 
	/*@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		return appUserRepository.findByEmail(email)
				.orElseThrow(()-> new UsernameNotFoundException(
						String.format(USER_NOT_FOUND_MSG, email)));
	}*/
	public String signUpUser(User appUser) {
		boolean userExists = appUserRepository
                .findByEmail(appUser.getEmail())
                .isPresent();

		List<Blacklist> blacklist = blacklistRepository.findAll();
		Boolean b = false;
		for (Blacklist blacklist2 : blacklist) {
			if(blacklist2.getEmail().equals(appUser.getEmail())){
				b = true;
			}
			
		}
		if(b == true){
			return "You are in the blacklist" ;
		
		}
	
		
		if(userExists){
			//
			//throw new IllegalStateException("email already taken");
			User u = appUserRepository.findByEmail(appUser.getEmail()).orElse(null);
        	if(u.isEnabled()==false){
        		appUserRepository.save(u);
                String token = UUID.randomUUID().toString();

                ConfirmationToken confirmationToken = new ConfirmationToken(
                		token,
                		LocalDateTime.now(),
                		LocalDateTime.now().plusMinutes(15),
                		u
                		
                		);
                confirmationTokenService.saveConfirmationToken(confirmationToken);
                return " Your email is already taken";
        	}else{
        		return "email taken";
        	}
		}
		String encodedPassword =bCryptPasswordEncoder.encode(appUser.getPassword());
		appUser.setPassword(encodedPassword);
		appUserRepository.save(appUser);
		
		String token = UUID.randomUUID().toString();
		ConfirmationToken confirmationToken = new ConfirmationToken(
        		token,
        		LocalDateTime.now(),
        		LocalDateTime.now().plusMinutes(15),
        		appUser
        		
        		);
        confirmationTokenService.saveConfirmationToken(confirmationToken);
        
        return token;
	}
	 
    public int enableAppUser(String email) {
        return appUserRepository.enableAppUser(email);
    }

}
