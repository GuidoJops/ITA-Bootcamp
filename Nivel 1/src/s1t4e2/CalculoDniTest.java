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
	/**
	 * Test method for {@link s1t4e2.CalculoDni#CalculoDni(int)}.
	 */
	
	@ParameterizedTest
	@ValueSource(strings = { "26592043H", "43591798J","35972723X", "88471730E","72738072C",
							"24180208D","96289764B","37525710Z","77566083D","71200625P"})
	void correctDniLetter(String dni) {
		String dniNumber = dni.substring(0, dni.length()-1);
	    assertEquals(dni, CalculoDni.calculaLetraDni(Integer.parseInt(dniNumber)));
	
	}
	
	@ParameterizedTest
	@ValueSource(strings = { "26592043H", "43591798J","35972723X", "88471730E","72738072C",
							"24180208D","96289764B","37525710Z","77566083D","71200625P"})
	void correctDniLetter2(String dni) {
		String dniNumberStr = dni.substring(0, dni.length()-1);
		int dniNumberInt = Integer.parseInt(dniNumberStr);
		
		
		char letter = dni.charAt(8);
	    assertEquals(letter, CalculoDni.calculaLetraDni2(dniNumberInt));
	
	}
	
	
	
}
