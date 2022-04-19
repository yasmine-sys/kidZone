package tn.pi.spring.entity;

import java.io.Serializable;
import java.util.Date;
//AUTHOR ABDESSALEM BENCHRIFA
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

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
public class Commentaire implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long commentaireId;

	@NonNull private Date dateCreation;
	private Date dateDerniereModification;
	@NonNull private String contenuCommentaire;
	@NonNull private Integer ratingCommentaire;
	

	@ManyToOne(cascade=CascadeType.ALL)
	Publication publication;

}
