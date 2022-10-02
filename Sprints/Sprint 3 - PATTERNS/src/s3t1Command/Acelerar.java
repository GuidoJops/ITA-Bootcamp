package s3t1Command;

public class Acelerar implements Command {
	
	private Vehiculo vehiculo;
	
	public Acelerar (Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	@Override
	public void ejecutar() {
		vehiculo.acelerar(vehiculo);
	
	}

}

			
		