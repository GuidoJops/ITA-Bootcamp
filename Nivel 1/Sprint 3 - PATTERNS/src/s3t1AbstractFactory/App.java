package s3t1AbstractFactory;

public class App {

	public static void main(String[] args) {
	
		FabricaAbstracta fabAr = FabricaProductor.getFabrica("argentina");
		ITelefono telAr = fabAr.createTelefono();	
		IDireccion dirAr = fabAr.createDireccion();
		telAr.getTelefono();
		dirAr.getDireccion();
		
		System.out.println("---");
		
		FabricaAbstracta fabEs = FabricaProductor.getFabrica("españa");
		ITelefono telEs = fabEs.createTelefono();	
		IDireccion dirEs = fabEs.createDireccion();
		telEs.getTelefono();
		dirEs.getDireccion();
		
		

	}

}
