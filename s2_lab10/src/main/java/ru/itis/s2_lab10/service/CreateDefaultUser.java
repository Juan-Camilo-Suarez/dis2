package ru.itis.s2_lab10.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.itis.s2_lab10.model.Organization;
import ru.itis.s2_lab10.model.User;
import ru.itis.s2_lab10.model.Counterparty;
import ru.itis.s2_lab10.repositories.CountryRepository;
import ru.itis.s2_lab10.repositories.OrganizationRepository;
import ru.itis.s2_lab10.repositories.UserRepository;

import java.util.Collections;

@Service
public class CreateDefaultUser {

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrganizationRepository organizationRepository;

    @Transactional
    public void createUser() {

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        Organization organization = new Counterparty();
        organization.setCountry(countryRepository.findByCode("RU"));
        organization.setName("Первая металлургическая");
        User user = new User();
        user.setUserName("admin");
        user.setPassword(passwordEncoder.encode("admin"));
        user.setRoles(Collections.singletonList(userRepository.findRoleById(1l)));
        user.setOrganization(organization);

        organizationRepository.save(organization);
        userRepository.save(user);

    }

}
