package s1t7e2;

public class App {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TrabajadorPresencial tp1 = new TrabajadorPresencial("Juan", "Mendez", 10);
		TrabajadorPresencial tp2 = new TrabajadorPresencial("María", "Garcia", 15.3);
		TrabajadorPresencial tp3 = new TrabajadorPresencial("Alejo", "Figueroa", 15);
		
		TrabajadorOnline to1 = new TrabajadorOnline("Jaime", "Lopez", 12.6);
		TrabajadorOnline to2 = new TrabajadorOnline("Alejandra", "Gimenez", 20);
		TrabajadorOnline to3 = new TrabajadorOnline("Martin", "Cassettai", 8);

		System.out.println(tp1.infoSueldoTrabajador(130));
		System.out.println(tp2.infoSueldoTrabajador(130));
		System.out.println(tp3.infoSueldoTrabajador(130));
		
		System.out.println(to1.infoSueldoTrabajador(130));
		System.out.println(to2.infoSueldoTrabajador(130));
		System.out.println(to3.infoSueldoTrabajador(130));
		
		
		tp1.gastogasolina();
		to1.precioInternet();
	

	}
	
}
