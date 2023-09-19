package accesoADatos;

import Entidades.Alumno;
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

public class MateriaData {

    private Connection con = null;

    public MateriaData() {

        con = Conexion.getConexion();
    }

    public void guardarMateria(Materia materia) {

        String sql = "INSERT INTO materia('nombre',anio,estado)+ VALUES (?,?,?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, materia.getNombre());
            ps.setInt(2, materia.getAnio());
            ps.setBoolean(3, materia.isEstado());
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Materia guardada exitosamente" + exito);

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " La materia no se pudo guardar" + ex.getMessage());
        }

    }

    public Materia buscarMateria(int id) {

        String sql = "SELECT nombre',anio,estado FROM materia WHERE idMateria = ? AND estado=1";
        Materia materia = null;
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                materia = new Materia();
                materia.setIDmateria(rs.getInt("idMateria"));
                materia.setNombre(rs.getString("nombre"));
                materia.setAnio(rs.getInt("año"));
                materia.setEstado(true);
            } else {

                JOptionPane.showMessageDialog(null, "no se encontró la materia" + rs);
                ps.close();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " error" + ex.getMessage());
        }
        return materia;

    }

    public void modificarMateria(Materia materia) {
        String sql = "UPDATE materia SET nombre=?,anio=?,estado=? WHERE idMateria=?";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, materia.getNombre());
            ps.setInt(2, materia.getAnio());
            ps.setBoolean(3, materia.isEstado());
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Materia modificada exitosamente" + exito);

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " La materia no se pudo modificar" + ex.getMessage());
        }

    }

    public void eliminarMateria(int id) {
        String sql = "UPDATE materia SET estado=0 WHERE idMateria=?";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setInt(1, id);
            int fila = ps.executeUpdate();
            if (fila == 1) {
                JOptionPane.showMessageDialog(null, "Materia eliminada exitosamente");

            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error,la materia no se pudo eliminar" + e.getMessage());
        }
    }

    public List<Materia> ListarMateria() {
        List<Materia> materias = new ArrayList<>();
        try {
            String sql = "SELECT * FROM materia WHERE estado = 1";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Materia materia = new Materia();
                materia.setIDmateria(rs.getInt("idMateria"));
                materia.setNombre(rs.getString("nombre"));
                materia.setAnio(rs.getInt("año"));
                materia.setEstado(rs.getBoolean("estado"));
                materias.add(materia);
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Materia" + ex.getMessage());
        }
        return materias;

    }
}
