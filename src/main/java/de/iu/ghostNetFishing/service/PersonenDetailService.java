package de.iu.ghostNetFishing.service;

import de.iu.ghostNetFishing.model.Person;
import de.iu.ghostNetFishing.repository.Personenrepository;
import de.iu.ghostNetFishing.security.MyUserDetails;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class PersonenDetailService implements UserDetailsService {

    private final Personenrepository repo;

    public PersonenDetailService(Personenrepository repo) {
        this.repo = repo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        Person user = repo.findByVornameAndNachname(username.split(" ")[0], username.split(" ")[1]).orElseThrow(() -> new UsernameNotFoundException(username));
        return new MyUserDetails(user);
    }
}
