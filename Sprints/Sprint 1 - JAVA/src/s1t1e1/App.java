
/*
En un grup de m�sica hi ha diferents tipus d�instruments musicals. Hi ha instruments de vent, de corda i de percussi�.

Tots els instruments tenen com a atributs el seu nom, i el seu preu. A m�s, tenen un m�tode anomenat tocar(). Aquest, �s abstracte a la classe instrument i, per tant, s�ha d�implementar a les classes filles. Si s�est� tocant un instrument de vent, el m�tode ha de mostrar per consola: "Est� sonant un instrument de vent", si s�est� tocant un instrument de corda: �Est� sonant un instrument de corda� i si s�est� tocant un instrument de percussi�: �Est� sonant un instrument de percussi�.

El proc�s de c�rrega d'una classe nom�s t� lloc una vegada. Demostra que la c�rrega pot ser provocada per la creaci� de la primera inst�ncia d'aquesta classe o per l'acc�s a un membre est�tic d'aquesta. 

Cerca informaci� sobre els blocs d'inicialitzaci� i blocs est�tics en Java. */

package s1t1e1;
public class App {
	
	public static void main(String[] args) {
		Instrumento inst1 = new Viento("Flauta", 20);
		Instrumento inst2 = new Cuerda("Guitarra", 220);
		Instrumento inst3 = new Percusion("Bateria", 520);
		Instrumento inst4 = new Percusion("Timbal", 120);
		Instrumento inst5 = new Viento("Saxo", 210);
		
		System.out.println(inst1.tocar()+"--> "+ inst1.infoInstrumento());
		System.out.println(inst1.tocar()+"--> "+ inst2.infoInstrumento());
		System.out.println(inst1.tocar()+"--> "+ inst3.infoInstrumento());
		System.out.println(inst1.tocar()+"--> "+ inst4.infoInstrumento());
		System.out.println(inst1.tocar()+"--> "+ inst5.infoInstrumento());
		
	}
	
	

}	

