package tn.pi.spring.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

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
public class Publication implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long publicationId;

	@NonNull private String titrePublication;
	@NonNull private String contenuPublication;
	@NonNull private Date dateCreation;
	private Date dateDerniereModification;
	@NonNull private Integer ratingPublication;
	 private String imageUrl;
	
	@Enumerated
	@NonNull
	TypePublication typePublication;

	@OneToMany(mappedBy = "publication", cascade=CascadeType.ALL)
	Set<Commentaire> commentaires;
	
	// @ManyToOne
	  //private User UserPublication	;


}
