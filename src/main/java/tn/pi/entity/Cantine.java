package tn.pi.entity;


import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
		
		@Column(name="prixcantine")
		private float prixcantine;
		
		@JsonIgnore
		@ManyToOne
	    Jardinenfant jardinenfant;
		
		@JsonIgnore
		@OneToMany(cascade = CascadeType.ALL, mappedBy="cantine")
		private List<Menu> menu;
		
		@JsonIgnore
		@OneToMany(cascade = CascadeType.ALL, mappedBy="cantines")
		private List<InscriCantine> inscriCantines;

	}
