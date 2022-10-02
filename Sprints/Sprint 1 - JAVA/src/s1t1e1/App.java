
/*
En un grup de música hi ha diferents tipus d’instruments musicals. Hi ha instruments de vent, de corda i de percussió.

Tots els instruments tenen com a atributs el seu nom, i el seu preu. A més, tenen un mètode anomenat tocar(). Aquest, és abstracte a la classe instrument i, per tant, s’ha d’implementar a les classes filles. Si s’està tocant un instrument de vent, el mètode ha de mostrar per consola: "Està sonant un instrument de vent", si s’està tocant un instrument de corda: “Està sonant un instrument de corda” i si s’està tocant un instrument de percussió: “Està sonant un instrument de percussió”.

El procés de càrrega d'una classe només té lloc una vegada. Demostra que la càrrega pot ser provocada per la creació de la primera instància d'aquesta classe o per l'accés a un membre estàtic d'aquesta. 

Cerca informació sobre els blocs d'inicialització i blocs estàtics en Java. */

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

