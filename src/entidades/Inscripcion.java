
package Entidades;


public class Inscripcion {
    
   private int  IDinscripcion;
   private Alumno alumno;
   private Materia materia;
   private double nota;

    public Inscripcion(int IDinscripcion, Alumno alumno, Materia materia, double nota) {
        this.IDinscripcion = IDinscripcion;
        this.alumno = alumno;
        this.materia = materia;
        this.nota = nota;
    }

    public Inscripcion() {
    }
    

    public Inscripcion(Alumno alumno, Materia materia, double nota) {
        this.alumno = alumno;
        this.materia = materia;
        this.nota = nota;
    }

    public int getIDinscripcion() {
        return IDinscripcion;
    }

    public void setIDinscripcion(int IDinscripcion) {
        this.IDinscripcion = IDinscripcion;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "Inscripcion{" + "IDinscripcion=" + IDinscripcion + ", alumno=" + alumno + ", materia=" + materia + ", nota=" + nota + '}';
    }
   
    
}
