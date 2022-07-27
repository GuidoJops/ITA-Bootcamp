package s1t4e2;
/*
 - Exercici 2
Crea una classe anomenada CalculoDni que calculi la lletra del DNI en rebre el número com a paràmetre.

Crea una classe jUnit que verifiqui el seu correcte funcionament, parametritzant-la perquè el test rebi 

un espectre de dades ampli i validi si el càlcul és correcte per a 10 números de DNI predefinits.
 */

public class CalculoDni {
	private int dniNumber;
	private String dni;
	
	public CalculoDni(int dniNumber) {
		this.dniNumber=dniNumber;

	}


	
	public static String calculaLetraDni(int dniNumber){
		String dniLetter="";

		switch(dniNumber % 23) {
			case 0:
				dniLetter="T";
				break;
			case 1:
				dniLetter="R";
				break;
			case 2:
				dniLetter="W";
				break;
			case 3:
				dniLetter="A";
				break;
			case 4:
				dniLetter="G";
				break;
			case 5:
				dniLetter="M";
				break;
			case 6:
				dniLetter="Y";
				break;
			case 7:
				dniLetter="F";
				break;
			case 8:
				dniLetter="P";
				break;
			case 9:
				dniLetter="D";
				break;
			case 10:
				dniLetter="X";
				break;
			case 11:
				dniLetter="B";
				break;
			case 12:
				dniLetter="N";
				break;
			case 13:
				dniLetter="J";
				break;
			case 14:
				dniLetter="Z";
				break;
			case 15:
				dniLetter="S";
				break;
			case 16:
				dniLetter="Q";
				break;
			case 17:
				dniLetter="V";
				break;
			case 18:
				dniLetter="H";
				break;
			case 19:
				dniLetter="L";
				break;
			case 20:
				dniLetter="C";
				break;
			case 21:
				dniLetter="K";
				break;
			case 22:
				dniLetter="E";
				break;
			default:
				System.out.println("Algo ha ido mal :(");
	
			}
		return dniNumber+dniLetter; //Retorna DNI
	}
	
	public static char calculaLetraDni2(int dniNumber){
		char dniLetter='@';

		switch(dniNumber % 23) {
			case 0:
				dniLetter='T';
				break;
			case 1:
				dniLetter='R';
				break;
			case 2:
				dniLetter='W';
				break;
			case 3:
				dniLetter='A';
				break;
			case 4:
				dniLetter='G';
				break;
			case 5:
				dniLetter='M';
				break;
			case 6:
				dniLetter='Y';
				break;
			case 7:
				dniLetter='F';
				break;
			case 8:
				dniLetter='P';
				break;
			case 9:
				dniLetter='D';
				break;
			case 10:
				dniLetter='X';
				break;
			case 11:
				dniLetter='B';
				break;
			case 12:
				dniLetter='N';
				break;
			case 13:
				dniLetter='J';
				break;
			case 14:
				dniLetter='Z';
				break;
			case 15:
				dniLetter='S';
				break;
			case 16:
				dniLetter='Q';
				break;
			case 17:
				dniLetter='V';
				break;
			case 18:
				dniLetter='H';
				break;
			case 19:
				dniLetter='L';
				break;
			case 20:
				dniLetter='C';
				break;
			case 21:
				dniLetter='K';
				break;
			case 22:
				dniLetter='E';
				break;
			default:
				System.out.println("Algo ha ido mal :(");
	
			}
		return dniLetter;
	}




}