package ita.S05T02N01JanotaFuenteGuido.dados.model.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Document(collection = "users")
public class User {

	@Id
	private String id;
	private String email;
	private String password;
	private List<Role> roles;

	public User(String email, String password, List<Role> roles){
		this.email = email;
		this. password = password;
		this.roles = roles;
	}

}
