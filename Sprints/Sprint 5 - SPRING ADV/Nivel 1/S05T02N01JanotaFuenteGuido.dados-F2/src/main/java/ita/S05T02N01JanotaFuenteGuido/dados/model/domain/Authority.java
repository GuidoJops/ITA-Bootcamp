package ita.S05T02N01JanotaFuenteGuido.dados.model.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@Document(collection = "roles")
public class Authority {

    @Id
    private String id;

    private AuthorityName role;

    public Authority(AuthorityName role){
         this.role = role;
    }
}
