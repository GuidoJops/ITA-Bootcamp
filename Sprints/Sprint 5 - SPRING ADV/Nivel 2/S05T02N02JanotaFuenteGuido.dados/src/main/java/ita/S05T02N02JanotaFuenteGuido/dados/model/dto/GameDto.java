package ita.S05T02N02JanotaFuenteGuido.dados.model.dto;


import lombok.*;

@Getter 
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class GameDto {
	
	private int diceA;
	private int diceB;
	private boolean win;

}
