package tn.pi.spring.registration;

import java.time.LocalDateTime;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import tn.pi.spring.entity.RoleName;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString

public class RegistrationRequest {
	

    private final String firstName;
    private final String lastName;
    private final String description;
    private final String adress;
    private final String telephone;
    private final LocalDateTime datecreation;
    private final String email;
    private final String password;
    private final RoleName role;

    
	/**
	 * 
	 */
	public RegistrationRequest() {
		this.firstName = "";
		this.lastName = "";
		this.description = "";
		this.adress = "";
		this.telephone = "";
		this.datecreation = null;
		this.email = "";
		this.password = "";
		this.role = null;
	}
	

    
}
