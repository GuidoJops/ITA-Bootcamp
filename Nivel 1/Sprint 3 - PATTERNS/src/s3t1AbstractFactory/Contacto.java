package s3t1AbstractFactory;

public class Contacto {
	private String nombre;
	private ITelefono tel;
	private IDireccion dir;
	
	
	public Contacto (String nombre, ITelefono tel, IDireccion dir) {
		this.nombre=nombre;
		this.tel=tel;
		this.dir=dir;
	}
	
	@Override
	public String toString() {
		return "\n--"+nombre +"--\n"+
				"TELEFONO: "+ tel.getTelefono() +
				"\nDIRECCIÓN: "+ dir.getDireccion()+"\n--\n";
		
	}
	
}
