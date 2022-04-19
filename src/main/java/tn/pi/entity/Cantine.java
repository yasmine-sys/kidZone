package tn.pi.entity;


import java.io.Serializable;
import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
	@Table( name = "cantine")
	public class Cantine implements Serializable {
		public static final long serialVersionUID =1L;
		@Id
		@GeneratedValue (strategy = GenerationType.IDENTITY)
		@Column(name="idcantine")
		private Long idcantine;
		
		@Column(name="pensioncantine")
		private String pensioncantine;
		
		@Enumerated(EnumType.STRING)
		private Abonnement abonnement;
		@Column(name="prixcantine")
		private float prixcantine;
		@ManyToOne
	    Jardinenfant jardinenfant;
		@JsonIgnore
		@OneToMany(mappedBy="cantine")
		private List<Menu> Menu;
		@JsonIgnore
		@OneToMany(mappedBy="cantine")
		private List<InscriCantine> inscriCantines;

	}
