package s3t1Command;

public class Frenar implements Command {
	
	private Vehiculo vehiculo;
	
	public Frenar (Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	@Override
	public void ejecutar() {
		vehiculo.frenar(vehiculo);
	
	}

}

			
		