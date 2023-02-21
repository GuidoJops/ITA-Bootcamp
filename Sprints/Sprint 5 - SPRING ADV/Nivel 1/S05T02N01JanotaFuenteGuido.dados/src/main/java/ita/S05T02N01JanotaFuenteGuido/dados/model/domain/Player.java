package ita.S05T02N01JanotaFuenteGuido.dados.model.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name = "Player")
public class Player {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "pk_PlayerId")
	private int idPlayer;
	
	@Column(name = "Name")
	private String name;
	
	@Column(name = "Registation_Date")
	private Date registDate;
	
	@Column(name = "Win_Porcentage")
	private double winSucces;
	
	@OneToMany(mappedBy = "player")
	private List<Game> games;

}
