package tn.pi.spring.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@EqualsAndHashCode
@Table(name="User")
public class User implements UserDetails, Serializable{
	

	private static final long serialVersionUID =1L;
	@SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )
	
	private Long id;
	
	@Column(name="firstName", nullable=true,length = 64)
	private String firstName;

	@Column(name="lastName", nullable=true,length = 64)
	private String lastName;
	
	@Column(name="description", nullable=true )
	private String description;
	
	@Column(name="adress", nullable=true,length = 64 )
	private String adress;

	@Column(name="telephone", nullable=true,length = 64 )
	private String telephone;
	
	@Column(name="datecreation", nullable=true,length = 64 )
	private LocalDateTime datecreation;
	
	@Column(name="email")
	private String email;
	
	@Column(name="password")
	private String password;

	@Enumerated (EnumType.STRING) 
	private RoleName role;
	@JsonIgnore
	private boolean locked = false;
	@JsonIgnore
	private boolean enabled = false;
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		 SimpleGrantedAuthority authority =
	                new SimpleGrantedAuthority(role.name());
	        return Collections.singletonList(authority);
	    }

	@JsonIgnore
	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@JsonIgnore
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return email;
	}

	@JsonIgnore
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@JsonIgnore
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return !locked;
	}

	@JsonIgnore
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@JsonIgnore
    @Override
    public boolean isEnabled() {
        return enabled;
    }

	public User(String fisrtName, String lastName, String description, String adress, String telephone,
			LocalDateTime datecreation, String email, String password, RoleName role) {
		super();
		this.firstName = fisrtName;
		this.lastName = lastName;
		this.description = description;
		this.adress = adress;
		this.telephone = telephone;
		this.datecreation = datecreation;
		this.email = email;
		this.password = password;
		this.role = role;
		
	}

	public User(String fisrtName, String description, String adress, String telephone, LocalDateTime datecreation,
			String email, String password, RoleName role, boolean locked, boolean enabled) {
		super();
		this.password = fisrtName;
		this.description = description;
		this.adress = adress;
		this.telephone = telephone;
		this.datecreation = datecreation;
		this.email = email;
		this.password = password;
		this.role = role;
		this.locked = locked;
		this.enabled = enabled;
	}

	public User(String fisrtName, String lastName, String adress, String telephone, String email, String password,
			RoleName role, boolean locked, boolean enabled) {
		super();
		this.lastName = fisrtName;
		this.lastName = lastName;
		this.adress = adress;
		this.telephone = telephone;
		this.email = email;
		this.password = password;
		this.role = role;
		this.locked = locked;
		this.enabled = enabled;
	}

	public User(String fisrtName, String lastName, String email, String password) {
		super();
		this.lastName = fisrtName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
	}
	

	public User(String fisrtName, String lastName, String adress, String telephone, String email, String password, RoleName role) {
		super();
		this.lastName = fisrtName;
		this.lastName = lastName;
		this.adress = adress;
		this.telephone = telephone;
		this.email = email;
		this.password = password;
		this.role = role;
	}

	public User(String fisrtName, String description, String adress, String telephone, LocalDateTime datecreation, String email,
			String password, RoleName role) {
		super();
		this.lastName = fisrtName;
		this.description = description;
		this.adress = adress;
		this.telephone = telephone;
		this.datecreation = datecreation;
		this.email = email;
		this.password = password;
		this.role = role;
	}
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @param password
	 * @param role
	 */
	public User(String firstName, String lastName, String email, String password, RoleName role) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.role = role;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public LocalDateTime getDatecreation() {
		return datecreation;
	}

	public void setDatecreation(LocalDateTime datecreation) {
		this.datecreation = datecreation;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public RoleName getRole() {
		return role;
	}

	public void setRole(RoleName role) {
		this.role = role;
	}

	public boolean isLocked() {
		return locked;
	}

	public void setLocked(boolean locked) {
		this.locked = locked;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", description=" + description + ", adress=" + adress + ", telephone=" + telephone + ", datecreation="
				+ datecreation + ", email=" + email + ", password=" + password + ", role=" + role + ", locked=" + locked
				+ ", enabled=" + enabled + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	///////////////////////////////Constucteur////////////////////////////////////////

}