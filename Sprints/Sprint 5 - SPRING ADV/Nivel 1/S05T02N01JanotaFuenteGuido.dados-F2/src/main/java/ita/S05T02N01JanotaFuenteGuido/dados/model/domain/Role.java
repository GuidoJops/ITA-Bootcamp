package ita.S05T02N01JanotaFuenteGuido.dados.model.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "roles")
public class Role {

    @Id
    private Long id;

    private ERole roleType;

    public Role(Long id,ERole roleType){
        this.id = id;
         this.roleType = roleType;
    }
}
