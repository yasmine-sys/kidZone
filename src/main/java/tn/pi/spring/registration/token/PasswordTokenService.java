package tn.pi.spring.registration.token;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PasswordTokenService {
	
    private final PasswordTokenRepository passwordTokenRepository;
    

    public void saveConfirmationToken(ResetPasswordToken token) {
    	passwordTokenRepository.save(token);
    }

    public Optional<ResetPasswordToken> getToken(String token) {
        return passwordTokenRepository.findByToken(token);
    }

    public int setConfirmedAt(String token) {
        return passwordTokenRepository.updateConfirmedAt(token, LocalDateTime.now());
    }
   
    public void deleteAllTokens(){
    	passwordTokenRepository.deleteAll();
    }

}
