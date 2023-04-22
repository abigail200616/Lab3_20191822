package com.example.lab3_20191822.repository;

import com.example.lab3_20191822.entity.Doctor;
import com.example.lab3_20191822.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
//extends JpaRepository<Hospital, Integer>
public interface PacienteRepository extends JpaRepository<Paciente, Integer> {

        //List<Hospital> findByNombre(String nombre);

    @Query(nativeQuery = true,value = "select * from paciente where hospital_id = ?1")
    List<Paciente> buscarPorIdP(Integer id);

    @Query(nativeQuery = true,value = "select * from paciente where doctor_id = ?1")
    List<Paciente> buscarPacientePorIdD(Integer id);

    @Query(nativeQuery = true,value = "select * from paciente where doctor_id =?1 and fecha_cita > CURRENT_DATE")
    List<Paciente> buscarProximaCita(Integer id);

    @Transactional
    @Modifying
    @Query(value = "UPDATE paciente set numero_habitacion =?1 WHERE id =?2", nativeQuery = true)
    void  guardarHabitacion(int numeroHabitacion, int id);

    @Transactional
    @Modifying
    @Query(value = "UPDATE paciente set doctor_id =?1 WHERE doctor_id =?2", nativeQuery = true)
    void  guardarDerivacion(int doctor1_id, int doctor2_id);


}
