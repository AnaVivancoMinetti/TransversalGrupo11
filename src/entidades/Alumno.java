
package Entidades;

import java.time.LocalDate;


public class Alumno {
    
    private int IDalumno;
    private String nombre;
    private String apellido;
    private int DNI;
    private LocalDate FechaN;
    private boolean estado;

    public Alumno() {
    }

    public Alumno(int IDalumno, String nombre, String apellido, int DNI, LocalDate FechaN, boolean estado) {
        this.IDalumno = IDalumno;
        this.nombre = nombre;
        this.apellido = apellido;
        this.DNI = DNI;
        this.FechaN = FechaN;
        this.estado = estado;
    }

    public Alumno(String nombre, String apellido, int DNI, LocalDate FechaN, boolean estado) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.DNI = DNI;
        this.FechaN = FechaN;
        this.estado = estado;
    }

    public int getIDalumno() {
        return IDalumno;
    }

    public void setIDalumno(int IDalumno) {
        this.IDalumno = IDalumno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getDNI() {
        return DNI;
    }

    public void setDNI(int DNI) {
        this.DNI = DNI;
    }

    public LocalDate getFechaN() {
        return FechaN;
    }

    public void setFechaN(LocalDate FechaN) {
        this.FechaN = FechaN;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Alumno{" + "IDalumno=" + IDalumno + ", nombre=" + nombre + ", apellido=" + apellido + ", DNI=" + DNI + ", FechaN=" + FechaN + ", estado=" + estado + '}';
    }

    
    
    
}
