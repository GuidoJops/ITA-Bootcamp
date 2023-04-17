package ita.S05T02N02JanotaFuenteGuido.dados.model.dto;


import java.util.Date;

import lombok.*;

@Getter 
@Setter 
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PlayerDto {
	
	private String id;
	private String name;
	private String userName; //E-mail
	private Date registDate;
	private double winSuccess;

}
