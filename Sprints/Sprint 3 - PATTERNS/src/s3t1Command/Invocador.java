package s3t1Command;

import java.util.ArrayList;
import java.util.List;

public class Invocador {

	private List<Command> comandos = new ArrayList();
	
	
	public void recibirComando(Command comando) {
		comandos.add(comando);
	}
	
	public void realizarComando() {
		comandos.forEach(c->c.ejecutar());
		comandos.clear();
	}
}
