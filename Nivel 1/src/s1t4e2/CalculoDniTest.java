/**
 * 
 */
package s1t4e2;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * @author Guido
 *
 */
class CalculoDniTest {

	
	@ParameterizedTest
	@ValueSource(strings = { "26592043H", "43591798J","35972723X", "88471730E","72738072C",
							"24180208D","96289764B","37525710Z","77566083D","71200625P"})
	void correctDniLetter(String dni) {
		String dniNumberStr = dni.substring(0, dni.length()-1);
		int dniNumberInt = Integer.parseInt(dniNumberStr);
		
		
		char letter = dni.charAt(8);
	    assertEquals(letter, CalculoDni.calculaLetraDni(dniNumberInt));
	
	}
	
	
	
}
