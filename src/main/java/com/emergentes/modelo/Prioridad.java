
package com.emergentes.modelo;

public class Prioridad {
    private int id;
    private String tarea;
    private String prioridad;
    private String completado;

    public Prioridad() {
        id=0;
        tarea="";
        prioridad="";
        completado="";
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTarea() {
        return tarea;
    }

    public void setTarea(String tarea) {
        this.tarea = tarea;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    public String getCompletado() {
        return completado;
    }

    public void setCompletado(String completado) {
        this.completado = completado;
    }
    
    
}
