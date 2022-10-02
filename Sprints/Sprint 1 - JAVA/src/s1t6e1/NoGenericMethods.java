
/*
 - Exercici 1
Crea una classe anomenada NoGenericMethods que emmagatzemi tres objectes del mateix tipus,
juntament amb els mètodes per a emmagatzemar i extreure aquests objectes i un constructor per 
a inicialitzar els tres. Comprova que els arguments es poden posar en qualsevol posició en la crida al constructor.

 */
package s1t6e1;

public class NoGenericMethods {
	private Object one;
	private Object two;
	private Object three;
	

	
	public  NoGenericMethods(Object ob1, Object ob2, Object ob3) {
		one = ob1;
		two = ob2;
		three = ob3;
	}
	

	public Object getOne() {
		return one;
	}

	public void setOne(Object one) {
		this.one = one;
	}

	public Object getTwo() {
		return two;
	}


	public void setTwo(Object two) {
		this.two = two;
	}


	public Object getThree() {
		return three;
	}


	public void setThree(Object three) {
		this.three = three;
	}

		
}

