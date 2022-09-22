package s3t2Observer;

public class Agencia extends Observer {
	
	public Agencia(Sujeto bolsa, String nombre) {
		this.bolsa = bolsa;
		this.bolsa.agregar(this);
		this.nombre = nombre;
	}
	
	@Override
	public void actualizar() {
		if (bolsa.getEstado()) {
			System.out.println(nombre + " notificada-> La bolsa SUBE");
		} else {
			System.out.println(nombre + " notificada-> La bolsa BAJA");
		}

		
	}

}
