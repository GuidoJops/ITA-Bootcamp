package s3t2Observer;

import java.util.ArrayList;
import java.util.List;

public class Sujeto {
	private List <Observer> observadores = new ArrayList<Observer>();
	private boolean estado;
	
	public boolean getEstado() {
		return estado;
	}
	
	public void setEstado(boolean estado) {
		this.estado = estado;
		notificaTodosObservadores();
		
	}
	
	public void agregar (Observer obs) {
		observadores.add(obs);
		
	}
	
	public void notificaTodosObservadores() {
		observadores.forEach(ob -> ob.actualizar());
		
	}

}
