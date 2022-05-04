package tn.pi.entity;
import java.sql.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
@Table( name = "Reclamation")
public class Reclamation {
	private static final long serialVersionUID =1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	
	@Column(name="idRec")
	private Long idRec;
	
	@Column(name="categorieRec")
	private String categorieRec;
	
	@Column(name="objetRec")
	private int objetRec;
	
	@Column(name="desceRec")
	private String desceRec;
	
	
}
