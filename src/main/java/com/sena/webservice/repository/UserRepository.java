package com.sena.webservice.repository;

import com.sena.webservice.model.Userr;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Userr, Long> {
}
