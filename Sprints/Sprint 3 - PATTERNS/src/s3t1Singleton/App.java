package s3t1Singleton;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Undo u = Undo.getInstance();

		u.delete();
		u.insert("Amigo");
		u.insert("Juan");
		u.insert("Hernan");
		u.delete();
		u.list();
		System.out.println("---------");
		u.insert("Coca");
		u.list();
		
		//Chequeo que devuelva siempre la misma instancia
		Undo u2 =Undo.getInstance();
		System.out.println("-----U2----");
		u2.list();

	}

}
