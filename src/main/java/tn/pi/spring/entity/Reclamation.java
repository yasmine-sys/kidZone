package tn.pi.spring.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Reclamation implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long ReclamationId;
	private String categories;
	private String objet;
	private String description;
	private String mailFrom;
	 
	    private String mailTo;
	
	
	public Reclamation() {
		super();
	}



	



	public Reclamation(String categories, String objet, String description, String mailFrom, String mailTo) {
		super();
		this.categories = categories;
		this.objet = objet;
		this.description = description;
		this.mailFrom = mailFrom;
		this.mailTo = mailTo;
	}







	public long getReclamationId() {
		return ReclamationId;
	}



	public void setReclamationId(long reclamationId) {
		ReclamationId = reclamationId;
	}



	public String getCategories() {
		return categories;
	}



	public void setCategories(String categories) {
		this.categories = categories;
	}



	public String getObjet() {
		return objet;
	}



	public void setObjet(String objet) {
		this.objet = objet;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}







	public String getMailFrom() {
		return mailFrom;
	}







	public void setMailFrom(String mailFrom) {
		this.mailFrom = mailFrom;
	}







	public String getMailTo() {
		return mailTo;
	}







	public void setMailTo(String mailTo) {
		this.mailTo = mailTo;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
