package com.example.lab3_20191822.controllers;

import com.example.lab3_20191822.entity.Doctor;
import com.example.lab3_20191822.entity.Hospital;
import com.example.lab3_20191822.entity.Paciente;
import com.example.lab3_20191822.repository.DoctorRepository;
import com.example.lab3_20191822.repository.HospitalRepository;
import com.example.lab3_20191822.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/hospital")
public class HospitalController {

    @Autowired
    final HospitalRepository hospitalRepository;
    @Autowired
    DoctorRepository doctorRepository;
    @Autowired
    PacienteRepository pacienteRepository;
    public HospitalController (HospitalRepository hospitalRepository) {this.hospitalRepository = hospitalRepository;}

    @GetMapping("/lista")
    public String listarHospitales(Model model){

        List<Hospital> lista = hospitalRepository.findAll();
        model.addAttribute("hospitalList", lista);

        return "hospitales/lista";
    }

    @GetMapping("/mostrarD")
    public String mostrarDoctores(@RequestParam("id") Integer id,Model model){
        List<Doctor> lista = doctorRepository.buscarPorIdD(id);
        model.addAttribute("doctoresHospital", lista);

        return "hospitales/doctoresH";
    }

    @GetMapping("/mostrarP")
    public String mostrarPacientes(@RequestParam("id") Integer id,Model model){
        List<Paciente> lista = pacienteRepository.buscarPorIdP(id);
        //for (Paciente p : lista){
        //    p.setNombre(DoctorRepository.buscarNombreDoctorPorIdP(p.getDoctorId()).getNombre());
        //}
        model.addAttribute("pacientesHospital", lista);

        return "hospitales/pacientesH";
    }

}
