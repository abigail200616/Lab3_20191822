package com.example.lab3_20191822.controllers;

import com.example.lab3_20191822.entity.Doctor;
import com.example.lab3_20191822.entity.Paciente;
import com.example.lab3_20191822.entity.Hospital;
import com.example.lab3_20191822.repository.DoctorRepository;
import com.example.lab3_20191822.repository.HospitalRepository;
import com.example.lab3_20191822.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    final DoctorRepository doctorRepository;

    @Autowired
    HospitalRepository hospitalRepository;

    @Autowired
    PacienteRepository pacienteRepository;

    public DoctorController(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @GetMapping("/lista")
    public String listarDoctores(Model model){

        List<Doctor> lista = doctorRepository.findAll();
        List<Hospital> listaH = hospitalRepository.findAll();
        // for (Doctor d : lista){
        //   d.setNombreH((hospitalRepository.buscarNombreHospital(d.getHospitalId()).getNombre()));
        //}
        model.addAttribute("doctorList", lista);
        model.addAttribute("doctorHospital", listaH);
        return "doctores/lista";
    }

    @GetMapping("/mostrarP")
    public String mostrarPacientes(@RequestParam("id") Integer id,Model model){
        List<Paciente> lista = pacienteRepository.buscarPacientePorIdD(id);
        model.addAttribute("pacientesDoctor", lista);

        return "doctores/pacientesD";
    }

    @GetMapping("/citasP")
    public String mostrarProximasCitas(@RequestParam("id") Integer id,Model model){
        List<Paciente> lista = pacienteRepository.buscarProximaCita(id);
        model.addAttribute("proxCitasDoctor", lista);

        return "doctores/citasD";
    }


}