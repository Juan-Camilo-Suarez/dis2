package ru.itis.s2_lab10.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.itis.s2_lab10.model.User;
import ru.itis.s2_lab10.repositories.UserRepository;

import javax.transaction.Transactional;

//ayuda a cargar los usuarios atravez del nombre
@Service(value = "myUserDetailsServise")
public class UserDetailsServiseImpl implements UserDetailsService {

    @Autowired
    private UserRepository repository;


    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repository.findByUserName(username);
        if (user != null) {
            return new UserDetailImpl(user);
        } throw new UsernameNotFoundException("User not found!");

    }
}
