/**
 * 
 */
package s1t4e3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author Guido
 *
 */
class ArrojaExcepcionTest {
	int indexLista;

//	@Test(expected = Exception.class)
//	public void testMethod() {
//		ArrojaExcepcion ob = new ArrojaExcepcion();
//	    ob.lugarEnLaLista(indexLista);
//	}

//    @Test
//    void testException() {
//    	ArrojaExcepcion ob = new ArrojaExcepcion();
//    	indexLista=32;
//    	assertThrows(ArrayIndexOutOfBoundsException.class, () ->
//        ob.lugarEnLaLista(indexLista), "Index invalido lanza Excepcion");
//        
//    }

	@Test
	void testException() {
		ArrojaExcepcion ob = new ArrojaExcepcion();
		indexLista = 32;
		
		assertThrows(ArrayIndexOutOfBoundsException.class, () -> 
			ob.lugarEnLaLista(indexLista),"Index invalido");

	}

}
