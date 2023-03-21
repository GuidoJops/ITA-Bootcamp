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
*	-Agregar PreAuth a GameController
* 	-Crear métodos registerAdmin y addAdminRoleToUser
* 	-Agregar método que devuelva datos útiles para un ADMIN? ej: PrincipalUser
*
* 	-Agregar Datos al Payload del JWT
* 	-Devolver JWT en el HEADER
*
* 	-Agregar Validaciones:
* 		-UserName acepte formato email?
* 		-JsonIgnore a Password en Entity?
*
* 	-Agregar Swagger
*
* 	-Constructores en DTOs es correcto?? ej: inicializar UserDto name
*
*
* */