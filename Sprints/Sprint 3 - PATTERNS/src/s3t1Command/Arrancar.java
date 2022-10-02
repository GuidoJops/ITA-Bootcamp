package s3t1Command;

public class Arrancar implements Command {
	
	private Vehiculo vehiculo;
	
	public Arrancar (Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	@Override
	public void ejecutar() {
		vehiculo.arrancar(vehiculo);
	
	}

}

			
		