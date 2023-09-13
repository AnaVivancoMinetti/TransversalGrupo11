
package accesoADatos;

import Entidades.Inscripcion;
import Entidades.Materia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class InscripcionData {
    
    private Connection con = null; 
    private MateriaData matData;
    private AlumnoData AluData;

    public InscripcionData(MateriaData matData, AlumnoData AluData) {
        this.matData = matData;
        this.AluData = AluData;
    }
    
    public InscripcionData(){
    con = Conexion.getConexion();
    }
//
//    public Connection getCon() {
//        return con;
//    }

//    public void setCon(Connection con) {
//        this.con = con;
//    }

    public MateriaData getMatData() {
        return matData;
    }

    public void setMatData(MateriaData matData) {
        this.matData = matData;
    }

    public AlumnoData getAluData() {
        return AluData;
    }

    public void setAluData(AlumnoData AluData) {
        this.AluData = AluData;
    }
    
    public void GuardarInscripcion (Inscripcion insc){
    String sql= "INSERT INTO inscripcion(nota, idAlumno, idMateria)"
            + "VALUES(?, ?, ?)";
            
        try {
            PreparedStatement ps= con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setDouble(1, insc.getNota());
            ps.setInt(2, insc.getAlumno().getIDalumno());
            ps.setInt(3, insc.getMateria().getIDmateria());
            ps.executeUpdate();
            
            ResultSet rs= ps.getGeneratedKeys();
            if (rs.next()){
                insc.setIDinscripcion(rs.getInt(1));
               JOptionPane.showMessageDialog(null, "Se Guardo la Inscripcion");
            }
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR AL GUARDAR LA INSCRIPCION");
        }
    
    }
    public List<Inscripcion> obtenerInscripciones(){
      List<Inscripcion> inscripcion= new ArrayList<Inscripcion>();  
      
        try {
            String sql= "SELECT * FROM inscripcion JOIN materia ON "
                    + " (inscripcion.idMateria=materia.idMateria) "
              + "JOIN alumno ON (inscripcion.idAlumno = alumno.idAlumno)";
            PreparedStatement ps= con.prepareStatement(sql);
            
             ResultSet rs= ps.executeQuery();
            
             while(rs.next()){
            Inscripcion insc = new Inscripcion();
            insc.setNota(rs.getInt("nota"));
          insc.getAlumno().setIDalumno(rs.getInt("idAlumno"));
           insc.getMateria().setIDmateria(rs.getInt("idMateria")); 
           inscripcion.add(insc);
        }
             ps.close();
             
             
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "ERROR AL ACCEDER LA INSCRIPCION"); 
        }
        return inscripcion;
    }
    public List<Inscripcion> obtenerInscripcionesPorAlumno(int id){
      List<Inscripcion> inscripcion= new ArrayList<Inscripcion>();  
      
        try {
            String sql= "SELECT * FROM inscripcion JOIN materia ON "
                    + " (inscripcion.idMateria=materia.idMateria) "
              + "JOIN alumno ON (inscripcion.idAlumno = alumno.idAlumno)"
                    + "WHERE  inscripcion.idMateria = materia.idMateria"
                    + "AND inscripcion.idAlumno = ?"
                    ;
            PreparedStatement ps= con.prepareStatement(sql);
            ps.setInt(1, id);
             ResultSet rs= ps.executeQuery();
            
             while(rs.next()){
            Inscripcion insc = new Inscripcion();
            insc.setNota(rs.getInt("nota"));
          insc.getAlumno().setIDalumno(rs.getInt("idAlumno"));
           insc.getMateria().setIDmateria(rs.getInt("idMateria")); 
           inscripcion.add(insc);
        }
             ps.close();
             
             
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "ERROR AL OBTENER LA INSCRIPCION"); 
        }
        return inscripcion;
    } 
    public List<Materia> obtenerMateriaCursada(int id){
      List<Materia> materia= new ArrayList<Materia>();  
      
        try {
            String sql= "SELECT inscripcion.idMateria, nombre, anio FROM inscripcion, materia "
                    + "WHERE inscripcion.idMateria=materia.idMateria "
                    + "AND inscripcion.idAlumno=?; ";
            PreparedStatement ps= con.prepareStatement(sql);
            ps.setInt(1, id);
             ResultSet rs= ps.executeQuery();
            Materia mate;
             while(rs.next()){
            mate = new Materia();
            mate.setIDmateria(rs.getInt("IdMateria"));
          mate.setNombre(rs.getString("nombre"));
           mate.setAnio(rs.getInt("anio")); 
           materia.add(mate);
        }
             ps.close();
             
             
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "ERROR AL OBTENER LA MATERIA"); 
        }
        return materia;
    } 
    
}
