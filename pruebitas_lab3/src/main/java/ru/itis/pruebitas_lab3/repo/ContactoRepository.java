package ru.itis.pruebitas_lab3.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itis.pruebitas_lab3.model.Contacto;

@Repository
public interface ContactoRepository extends JpaRepository<Contacto, Integer> {
}
