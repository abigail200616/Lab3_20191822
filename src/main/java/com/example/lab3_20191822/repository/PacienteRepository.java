package com.example.lab3_20191822.repository;

import com.example.lab3_20191822.entity.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
//extends JpaRepository<Hospital, Integer>
public abstract class PacienteRepository implements JpaRepository<Hospital, Integer> {

        //List<Hospital> findByNombre(String nombre);

}
