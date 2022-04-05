package hours_alpha.example.hours_alpha.business.security.entityModel;

import hours_alpha.example.hours_alpha.business.entity.EntityModel;
import hours_alpha.example.hours_alpha.business.entity.EntityModelService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EntityModelDetailsServiceImpl<T extends EntityModelService<? extends EntityModel>> implements UserDetailsService {

    private final List<T> entityModelService;

    @Override
    public EntityModelDetailsImpl<? extends EntityModel> loadUserByUsername(String email) throws UsernameNotFoundException {
        for(var service : entityModelService){
            try{
                var user = service.getUserByEmail(email);
                if(user == null)
                    continue;
                return new EntityModelDetailsImpl<>(user);
            }catch (UsernameNotFoundException ignored){

            }
        }
        throw new UsernameNotFoundException(email);
    }
}
