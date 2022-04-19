package tn.pi.spring.entity;

import java.io.Serializable;
import java.util.Date;
//AUTHOR ABDESSALEM BENCHRIFA
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Message implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long messageId;

	@NonNull private Date dateEnvoie;
	@NonNull private String contenumessage;
	@NonNull private String typeMessage;
	@NonNull private String sender;
	//@ManyToOne
	
	  public String getSender() {
	        return sender;
	    }

	    public void setSender(String sender) {
	        this.sender = sender;
	    }
}
