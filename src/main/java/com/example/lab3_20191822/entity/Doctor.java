package com.example.lab3_20191822.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "doctor", schema = "hospital_db", catalog = "")
public class Doctor {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "nombre")
    private String nombre;
    @Basic
    @Column(name = "especialidad")
    private String especialidad;
    @Basic
    @Column(name = "hospital_id")
    private int hospitalId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public int getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(int hospitalId) {
        this.hospitalId = hospitalId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Doctor that = (Doctor) o;
        return id == that.id && hospitalId == that.hospitalId && Objects.equals(nombre, that.nombre) && Objects.equals(especialidad, that.especialidad);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, especialidad, hospitalId);
    }




}
