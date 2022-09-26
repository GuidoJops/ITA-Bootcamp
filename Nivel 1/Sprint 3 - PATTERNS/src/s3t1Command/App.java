package s3t1Command;

import java.util.ArrayList;
import java.util.List;

public class App {

	public static void main(String[] args) {
		
		List <Vehiculo> vehiculos = new ArrayList();
		vehiculos.add(new Vehiculo("auto"));
		vehiculos.add(new Vehiculo("avion"));
		vehiculos.add(new Vehiculo("barco"));
		vehiculos.add(new Vehiculo("bicicleta"));
		
		
		for (Vehiculo v : vehiculos) {
			Arrancar arrancar = new Arrancar(v);
			Acelerar acelerar = new Acelerar(v);
			Frenar frenar = new Frenar (v);
			
			Invocador invocador = new Invocador();
			invocador.recibirComando(arrancar);
			invocador.recibirComando(acelerar);
			invocador.recibirComando(frenar);
			
			invocador.realizarComando();
			System.out.println("--");
			
		}		

	}

}

