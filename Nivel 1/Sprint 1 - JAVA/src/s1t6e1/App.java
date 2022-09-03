package s1t6e1;

public class App {

	public static void main(String[] args) {
		//Utilizo objetos del tipo String
		
		NoGenericMethods ng1 = new NoGenericMethods ("Juan", "María", "Pepe");
		NoGenericMethods ng2 = new NoGenericMethods ("María", "Juan", "Pepe");
		NoGenericMethods ng3 = new NoGenericMethods ("Pepe", "María", "Juan");
		
		System.out.println(ng1.getOne());
		ng1.setOne("Cadena");
		System.out.println(ng1.getOne());
		System.out.println(ng2.getOne());
		System.out.println(ng3.getOne());
		
		System.out.println(ng1.getThree());
		System.out.println(ng2.getThree());
		System.out.println(ng3.getThree());
		
		
	}

}

