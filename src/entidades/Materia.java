
package Entidades;

import java.time.LocalDate;


public class Materia {
    
    private int IDmateria;
    private String nombreMat;
    private LocalDate anio;
    private boolean estado;

    public Materia() {
    }

    public Materia(int IDmateria, String nombreMat, LocalDate anio, boolean estado) {
        this.IDmateria = IDmateria;
        this.nombreMat = nombreMat;
        this.anio = anio;
        this.estado = estado;
    }

    public Materia(String nombreMat, LocalDate anio, boolean estado) {
        this.nombreMat = nombreMat;
        this.anio = anio;
        this.estado = estado;
    }

    public int getIDmateria() {
        return IDmateria;
    }

    public void setIDmateria(int IDmateria) {
        this.IDmateria = IDmateria;
    }

    public String getNombre() {
        return nombreMat;
    }

    public void setNombre(String nombre) {
        this.nombreMat= nombreMat;
    }

    public LocalDate getAnio() {
        return anio;
    }

    public void setAnio(LocalDate anio) {
        this.anio = anio;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Materia{" + "IDmateria=" + IDmateria + ", nombre=" + nombreMat + ", anio=" + anio + ", estado=" + estado + '}';
    }
    
    
}
