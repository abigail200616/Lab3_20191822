package com.example.lab3_20191822.controllers;
import com.example.lab3_20191822.entity.Doctor;
import com.example.lab3_20191822.entity.Hospital;
import com.example.lab3_20191822.entity.Paciente;
import com.example.lab3_20191822.repository.HospitalRepository;
import com.example.lab3_20191822.repository.DoctorRepository;
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
@RequestMapping("/paciente")
public class PacienteController {
    @Autowired
    final PacienteRepository pacienteRepository;

    @Autowired
    HospitalRepository hospitalRepository;

    @Autowired
    DoctorRepository doctorRepository;
    public PacienteController(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }
    @GetMapping("/lista")
    public String listarPacientes(Model model){

        List<Paciente> lista = pacienteRepository.findAll();
        List<Hospital> listaH = hospitalRepository.findAll();
        List<Doctor> listaP = doctorRepository.findAll();
        model.addAttribute("pacienteList", lista);
        model.addAttribute("hospitalPaciente", listaH);
        model.addAttribute("doctorPaciente", listaP);
        return "pacientes/lista";
    }

    @GetMapping("/editar")
    public String editarPaciente(@RequestParam("id") Integer id, Model model){

        Optional<Paciente> optPaciente = pacienteRepository.findById(id);

        if(optPaciente.isPresent()){
            Paciente p = optPaciente.get();
            model.addAttribute("paciente",p);
            return "pacientes/editar";
            //Aqui se pone la vista
        } else {
            return "redirect:/paciente/lista";
            //redireciona al Listar Pacientes no se pone la vista
        }
    }

    @PostMapping("/guardarp")
    public String guardarPacientes(Paciente paciente, Model model) {

        Optional<Paciente> optPaciente = pacienteRepository.findById(paciente.getId());
        if(optPaciente.isPresent()) {
            pacienteRepository.guardarHabitacion(paciente.getNumeroHabitacion(), paciente.getId());
            return "redirect:/paciente/lista";
        } else {
            return "redirect:/paciente/lista";
        }
    }

    @GetMapping("/derivar")
    public String derivarPacientes(Model model){
        List<Doctor> lista = doctorRepository.findAll();
        model.addAttribute("doctoresDerivar", lista);
        return "pacientes/derivar";
    }

    @PostMapping("/guardar2")
    public String guardarPacientesDerivacion(@RequestParam("doctor1_id") Integer id1,@RequestParam("doctor2_id") Integer id2, Model model ){
        pacienteRepository.guardarDerivacion(id2, id1);
        return "redirect:/paciente/lista";
    }









}