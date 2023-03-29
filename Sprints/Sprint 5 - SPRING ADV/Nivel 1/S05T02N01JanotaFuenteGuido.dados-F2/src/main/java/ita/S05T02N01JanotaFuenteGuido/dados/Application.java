package ita.S05T02N01JanotaFuenteGuido.dados;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}

/*--TODO LIST--

	-private-public-protected??
* 	-Agregar método que devuelva datos útiles para un ADMIN? ej: PrincipalUser
* 	-Agregar Swagger
	-Array o set para Roles y Games?
*

*   -Hacer que PLAYER sea el CUSTOMuSERDETAILS--OK
* 	-Crear métodos addAdminRoleToUser--OK
	-Agregar Validaciones:--OK
		-En modelos de cara a BD--OK
* 		-UserName acepte formato email?--OK
*   -Que no devuelva el Player Admin en las peticiones--OK
* 	-Agregar Datos al Payload del JWT--OK
* 	-Devolver JWT en el HEADER--OK
*   -Agregar PreAuth a GameController--OK
* 	-Chequear parametros cambiarnombre--OK
*
* 	-Donde colocar clases AuthRequest y AuthResponse??

*
*
* */