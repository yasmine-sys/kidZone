package tn.pi.spring.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity

public class Cout implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	 private long CoutId;

	 private String niveau;
	 private int tarif;
	
	 @ManyToOne		
	 private Jardin jardin;
	
	public Cout() {
		
	}

	public Cout (String niveau, int tarif, Jardin jardin) {
		super();
		this.niveau = niveau;
		this.tarif = tarif;
		this.jardin = jardin;
	}

	public long getCoutId() {
		return CoutId;
	}

	public void setCoutId(long coutId) {
		CoutId = coutId;
	}

	public String getNiveau() {
		return niveau;
	}

	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}

	public int getTarif() {
		return tarif;
	}

	public void setTarif(int tarif) {
		this.tarif = tarif;
	}

	public Jardin getJardin() {
		return jardin;
	}

	public void setJardin(Jardin jardin) {
		this.jardin = jardin;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
	
	
}

