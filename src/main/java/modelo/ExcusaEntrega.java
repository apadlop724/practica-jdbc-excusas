/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.time.LocalDate;

public class ExcusaEntrega {
    private int id;
    private String alumno;
    private String curso;
    private String excusa;
    private int diasRetraso;
    private int credibilidad;
    private LocalDate fechaEntrega; // Puede ser null
    private boolean aprobadaPorProfesor;
    private int nivelDrama;

    public ExcusaEntrega() {}

    public ExcusaEntrega(int id, String alumno, String curso, String excusa, int diasRetraso, 
                         int credibilidad, LocalDate fechaEntrega, boolean aprobadaPorProfesor, int nivelDrama) {
        this.id = id;
        this.alumno = alumno;
        this.curso = curso;
        this.excusa = excusa;
        this.diasRetraso = diasRetraso;
        this.credibilidad = credibilidad;
        this.fechaEntrega = fechaEntrega;
        this.aprobadaPorProfesor = aprobadaPorProfesor;
        this.nivelDrama = nivelDrama;
    }

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getAlumno() { return alumno; }
    public void setAlumno(String alumno) { this.alumno = alumno; }

    public String getCurso() { return curso; }
    public void setCurso(String curso) { this.curso = curso; }

    public String getExcusa() { return excusa; }
    public void setExcusa(String excusa) { this.excusa = excusa; }

    public int getDiasRetraso() { return diasRetraso; }
    public void setDiasRetraso(int diasRetraso) { this.diasRetraso = diasRetraso; }

    public int getCredibilidad() { return credibilidad; }
    public void setCredibilidad(int credibilidad) { this.credibilidad = credibilidad; }

    public LocalDate getFechaEntrega() { return fechaEntrega; }
    public void setFechaEntrega(LocalDate fechaEntrega) { this.fechaEntrega = fechaEntrega; }

    public boolean isAprobadaPorProfesor() { return aprobadaPorProfesor; }
    public void setAprobadaPorProfesor(boolean aprobadaPorProfesor) { this.aprobadaPorProfesor = aprobadaPorProfesor; }

    public int getNivelDrama() { return nivelDrama; }
    public void setNivelDrama(int nivelDrama) { this.nivelDrama = nivelDrama; }

    @Override
    public String toString() {
        return String.format("ID: %-2d | Alumno: %-15s | Curso: %-5s | Drama: %-2d | Retraso: %-2dd | Fecha: %-10s | Excusa: %s",
                id, alumno, curso, nivelDrama, diasRetraso, 
                (fechaEntrega != null ? fechaEntrega.toString() : "PENDIENTE"), excusa);
    }
}
