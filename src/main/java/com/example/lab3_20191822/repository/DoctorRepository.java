package com.example.lab3_20191822.repository;

import com.example.lab3_20191822.entity.Doctor;
import com.example.lab3_20191822.entity.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

abstract class DoctorlRepository implements JpaRepository<Doctor, Integer> {
}
