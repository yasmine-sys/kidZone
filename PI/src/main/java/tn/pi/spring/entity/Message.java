package tn.pi.spring.entity;

import java.io.Serializable;
<<<<<<< Updated upstream

import javax.persistence.Column;
=======
import java.util.Date;
//AUTHOR ABDESSALEM BENCHRIFA
>>>>>>> Stashed changes
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
<<<<<<< Updated upstream
import javax.persistence.Table;
=======
>>>>>>> Stashed changes

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
<<<<<<< Updated upstream
@Table(name = "Message")
=======
>>>>>>> Stashed changes
public class Message implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
<<<<<<< Updated upstream
	private int messageId;
	private String greeting;


	//@NonNull private Date dateEnvoie;
	@Column
	@NonNull private String contenumessage;
	//@NonNull private String typeMessage;
	@Column
	@NonNull private String sender;
	//@ManyToOne
	
	  public String getSender() {
	        return sender;
	    }

	    public void setSender(String sender) {
	        this.sender = sender;
	    }
=======
	private long messageId;

	@NonNull private Date dateEnvoie;
	@NonNull private String contenumessage;
	@NonNull private String typeMessage;

	//@ManyToOne
>>>>>>> Stashed changes
}
