package s1t6e2;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "Infomación dentro de str";
		int num = 98;
		Persona per1 = new Persona("Juan", "Perez", 23);
		Persona per2 = new Persona("María", "Martinez", 56);
		GenericMethods gen = new GenericMethods();
		
		gen.imprimeEnPantalla(per1, str, num);
		System.out.println("---\n");
		gen.imprimeEnPantalla(str, per1, num);
				System.out.println("---\n");
		gen.imprimeEnPantalla("Prueba", 54, per2);

	}

}
