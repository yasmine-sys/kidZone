package tn.pi.entity;

import java.io.Serializable;
import java.util.Set;

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
@Table( name = "Menu")
public class Menu implements Serializable {
	public static final long serialVersionUID =1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idmenu")
	private Long idmenu;
	@Column(name="contenumenu")
	private String contenumenu;
	
	@ManyToOne
	Cantine cantine;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy="menus")
	private Set<ListMenu> listMenu;
	
	
}
