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
*   -Que no devuelva el Player Admin en las peticiones
* 	-Crear métodos registerAdmin y addAdminRoleToUser
* 	-Agregar método que devuelva datos útiles para un ADMIN? ej: PrincipalUser
* 	-Agregar Validaciones:
* 		-UserName acepte formato email?
* 		-JsonIgnore a Password en Entity?
* 	-Agregar Swagger
*   -Hacer que PLAYER sea el CUSTOMUSERDETAILS???
*
*
* 	-Agregar Datos al Payload del JWT--OK
* 	-Devolver JWT en el HEADER--OK
*   -Agregar PreAuth a GameController--OK
* 	-Chequear parametros cambiarnombre--OK
*
*
* */