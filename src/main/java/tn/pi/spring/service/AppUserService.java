package tn.pi.spring.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import tn.pi.spring.entity.Blacklist;
import tn.pi.spring.entity.User;
import tn.pi.spring.registration.token.ConfirmationToken;
import tn.pi.spring.registration.token.ConfirmationTokenService;
import tn.pi.spring.repository.AppUserRepository;
import tn.pi.spring.repository.BlacklistRepository;



@AllArgsConstructor
@Service
public class AppUserService implements UserDetailsService {

	
	private final static String USER_NOT_FOUND_MSG = "user with email %email not found";
    private final AppUserRepository appUserRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final ConfirmationTokenService confirmationTokenService;
    private final BlacklistRepository blacklistRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return appUserRepository.findByEmail(email)
				.orElseThrow(()-> new UsernameNotFoundException(
						String.format(USER_NOT_FOUND_MSG, email)));
	}
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
