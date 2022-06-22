package peaksoft.restapi.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import peaksoft.restapi.entities.CustomUserDetails;
import peaksoft.restapi.entities.User;
import peaksoft.restapi.services.UserService;

@Component

public class CustomUserDetService implements UserDetailsService {

    private UserService service;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = service.findByEmail(email);
        return CustomUserDetails.fromEntityToCustom(user);
    }
}
