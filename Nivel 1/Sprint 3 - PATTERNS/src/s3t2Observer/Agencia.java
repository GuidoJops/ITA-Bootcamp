package s3t2Observer;

public class Agencia extends Observer {
	
	public Agencia(Sujeto agenteBolsa, String nombre) {
		this.agenteBolsa = agenteBolsa;
		this.agenteBolsa.agregar(this);
		this.nombre = nombre;
	}
	
	@Override
	public void actualizar() {
		if(agenteBolsa.getEstado()) {
			System.out.println(nombre + " notificada-> La bolsa SUBE");
		} else {
			System.out.println(nombre + " notificada-> La bolsa BAJA");
		}

		
	}

}
