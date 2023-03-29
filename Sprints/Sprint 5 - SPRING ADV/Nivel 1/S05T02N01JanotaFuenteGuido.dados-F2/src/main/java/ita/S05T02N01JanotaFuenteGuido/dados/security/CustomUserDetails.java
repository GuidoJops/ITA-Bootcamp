package ita.S05T02N01JanotaFuenteGuido.dados.security;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ita.S05T02N01JanotaFuenteGuido.dados.model.domain.ERole;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Getter
@Setter
public class CustomUserDetails implements UserDetails {
/*¿PONER DIRECTAMENTE LA CLASE 'PLAYER'??*/

    private String id;
    private String userName;
    @JsonIgnore
    private String password;
    private Collection<? extends GrantedAuthority> authorities;


    public CustomUserDetails(String id, String userName, String password,
                             Collection<? extends GrantedAuthority> authorities){
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public String toString() {
        return "CustomUserDetails{" +
                "id='" + id + '\'' +
                ", userName='" + userName + '\'' +
                ", password=[PROTECTED]'" +
                ", authorities=" + authorities +
                '}';
    }

    public boolean isAdmin() {
        return authorities.stream().anyMatch(a->a.getAuthority().equals("ROLE_ADMIN"));

    }
}
