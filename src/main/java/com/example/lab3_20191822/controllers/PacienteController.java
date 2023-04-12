package com.example.lab3_20191822.controllers;

import com.example.lab3_20191822.entity.Hospital;
import com.example.lab3_20191822.repository.PacienteRepository;
import com.example.lab3_20191822.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/hospitales")
public class PacienteController {
    @Autowired
    final PacienteRepository pacienteRepository;

    public PacienteController(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    //public HospitalController (HospitalRepository hospitalRepository) {this.hospitalRepository = hospitalRepository;}

    @GetMapping(value = {"/lista", " "})
    public String listarPacientes(Model model){

        List<Hospital> lista = pacienteRepository.findAll();
        model.addAttribute("pacienteList", lista);

        return "paciente/lista";
    }

}