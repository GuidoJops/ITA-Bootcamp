/**
 * 
 */
package s1t4e1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author Guido
 *
 */
class MesesTest {

	@Test
	void sizeShouldBetwelve() {
		Meses m = new Meses();
		assertEquals(12,m.getMeses().size());
	}

	@Test
	void arrayShouldNotBeNull() {
		Meses m = new Meses();
		assertNotNull(m);
		}
	
	@Test
	void arrayIndexSevenShouldBeAgosto() {
		Meses m = new Meses();
		assertEquals("Agosto",m.getMeses().get(7));
		}
	
}
