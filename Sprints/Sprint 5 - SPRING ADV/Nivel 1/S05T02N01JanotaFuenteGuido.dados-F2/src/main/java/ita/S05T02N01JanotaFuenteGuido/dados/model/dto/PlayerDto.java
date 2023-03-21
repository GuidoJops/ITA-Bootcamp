package ita.S05T02N01JanotaFuenteGuido.dados.model.dto;


import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter 
@Setter 
@ToString
public class PlayerDto {
	
	private String id;

	private String name;
	
	private String userName; //E-mail
	
	private Date registDate;
	
	private double winSuccess;
	
		

}
