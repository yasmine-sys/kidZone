package tn.pi.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
@Table(name = "ListMenu")
public class ListMenu implements Serializable {

		public static final long serialVersionUID =1L;
		@Id
		@GeneratedValue (strategy = GenerationType.IDENTITY)
		@Column(name="idListMenu")
		private Long idListMenu;
		@Column(name="Platprincipale")
		private String Platprincipale;
		@Column(name="Entree")
		private String Entree;
		@Column(name="Desert")
		private String Desert;
		@Enumerated(EnumType.STRING)
		private jour jour;
		@ManyToOne
		Menu Menu;
		
		
}
