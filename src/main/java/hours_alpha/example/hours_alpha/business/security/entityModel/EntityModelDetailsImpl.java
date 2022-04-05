package hours_alpha.example.hours_alpha.business.security.entityModel;

import hours_alpha.example.hours_alpha.business.entity.EntityModel;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@AllArgsConstructor
public class EntityModelDetailsImpl<T extends EntityModel> implements UserDetails {

    private T user;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(user.createGrantedAuthority());
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getFirstName() + "_" + user.getLastName() + "_" + user.getId();
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
}
