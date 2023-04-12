package com.example.lab3_20191822.controllers;

import com.example.lab3_20191822.entity.Hospital;
import com.example.lab3_20191822.repository.DoctorRepository;
import com.example.lab3_20191822.repository.HospitalRepository;
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
@RequestMapping("/hospitales")
public class DoctorController {

    @Autowired
    final DoctorRepository doctorRepository;

    //public HospitalController (HospitalRepository hospitalRepository) {this.hospitalRepository = hospitalRepository;}

    @GetMapping(value = {"/lista", " "})
    public String listarDoctores(Model model){

        List<Hospital> lista = doctorRepository.findAll();
        model.addAttribute("doctorList", lista);

        return "doctores/lista";
    }

}