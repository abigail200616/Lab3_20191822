package com.example.lab3_20191822.repository;

import com.example.lab3_20191822.entity.Doctor;
import com.example.lab3_20191822.entity.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import javax.print.Doc;
import java.util.List;

@Repository
//extends JpaRepository<Hospital, Integer>
public interface HospitalRepository extends JpaRepository<Hospital, Integer> {

   //@Query(nativeQuery = true,value = "select * from hospital where id =?1")
   //Hospital buscarNombreHospital(int id);



}
