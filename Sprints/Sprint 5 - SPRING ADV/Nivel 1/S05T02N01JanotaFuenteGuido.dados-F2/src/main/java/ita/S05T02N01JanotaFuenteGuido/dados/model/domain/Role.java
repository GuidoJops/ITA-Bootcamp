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

    private ERole type;

    public Role(Long id,ERole type){
        this.id = id;
         this.type = type;
    }
}
