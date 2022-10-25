package com.escuelita.demo.repositories;
import com.escuelita.demo.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IRoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByName(String name);
}
