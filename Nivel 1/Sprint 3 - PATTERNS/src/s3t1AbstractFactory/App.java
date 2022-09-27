package s3t1AbstractFactory;

public class App {

	public static void main(String[] args) {
		//Fabrica Telefono
		FabricaAbstracta fabTel = ProductorFabrica.getFabrica("Telefono");
		ITelefono tel1 = fabTel.getpaisTelefono("Argentina");
		ITelefono tel2 = fabTel.getpaisTelefono("España");
		tel1.agregar();
		tel2.agregar();
		
		FabricaAbstracta fabDir = ProductorFabrica.getFabrica("Direccion");
		IDireccion dir1 = fabDir.getpaisDireccion("Argentina");
		dir1.agregar();
		

	}

}
