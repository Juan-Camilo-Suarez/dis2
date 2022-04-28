package ru.itis.s2_lab10.repositories;


import org.springframework.data.repository.CrudRepository;
import ru.itis.s2_lab10.model.Organization;

public interface OrganizationRepository extends CrudRepository<Organization, Long> {

}
