package tn.pi.spring.registration;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString

public class RegistrationRequest {
	

    private final String firstName;
    private final String lastName;
    private final String email;
    private final String password;
	/**
	 * 
	 */
	public RegistrationRequest() {
		this.firstName = "";
		this.lastName = "";
		this.email = "";
		this.password = "";
	}
	

    
}
