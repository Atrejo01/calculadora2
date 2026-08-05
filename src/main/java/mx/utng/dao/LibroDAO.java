package mx.utng.dao;

import mx.utng.database.Conexion;
import mx.utng.model.Libro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LibroDAO {

    public boolean guardar(Libro libro) {

        String sql = "INSERT INTO tb_libros(isbn, titulo, autor, editorial, anio, existencias) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, libro.getIsbn());
            ps.setString(2, libro.getTitulo());
            ps.setString(3, libro.getAutor());
            ps.setString(4, libro.getEditorial());
            ps.setInt(5, libro.getAnio());
            ps.setInt(6, libro.getExistencias());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }


        // LISTAR TODOS LOS LIBROS
    public List<Libro> listar() {

        List<Libro> lista = new ArrayList<>();

        String sql = "SELECT * FROM tb_libros";

        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {


            while (rs.next()) {

                Libro libro = new Libro();

                libro.setId(rs.getInt("id"));
                libro.setIsbn(rs.getString("isbn"));
                libro.setTitulo(rs.getString("titulo"));
                libro.setAutor(rs.getString("autor"));
                libro.setEditorial(rs.getString("editorial"));
                libro.setAnio(rs.getInt("anio"));
                libro.setExistencias(rs.getInt("existencias"));
                libro.setDisponibles(rs.getInt("disponibles"));

                lista.add(libro);
            }


        } catch (SQLException e) {
            System.out.println("Error al listar libros: " + e.getMessage());
        }

        return lista;
    }



    // INSERTAR LIBRO
    public boolean insertar(Libro libro) {

        String sql = "INSERT INTO tb_libros(isbn,titulo,autor,editorial,anio,existencias,disponibles) VALUES (?,?,?,?,?,?,?)";


        try(Connection con = Conexion.conectar();
            PreparedStatement ps = con.prepareStatement(sql)) {


            ps.setString(1, libro.getIsbn());
            ps.setString(2, libro.getTitulo());
            ps.setString(3, libro.getAutor());
            ps.setString(4, libro.getEditorial());
            ps.setInt(5, libro.getAnio());
            ps.setInt(6, libro.getExistencias());
            ps.setInt(7, libro.getDisponibles());


            ps.executeUpdate();

            return true;


        } catch(SQLException e){

            System.out.println("Error al insertar libro: " + e.getMessage());
            return false;
        }

    }



    // ACTUALIZAR LIBRO
    public boolean actualizar(Libro libro) {


        String sql = "UPDATE tb_libros SET isbn=?,titulo=?,autor=?,editorial=?,anio=?,existencias=?,disponibles=? WHERE id=?";


        try(Connection con = Conexion.conectar();
            PreparedStatement ps = con.prepareStatement(sql)) {


            ps.setString(1, libro.getIsbn());
            ps.setString(2, libro.getTitulo());
            ps.setString(3, libro.getAutor());
            ps.setString(4, libro.getEditorial());
            ps.setInt(5, libro.getAnio());
            ps.setInt(6, libro.getExistencias());
            ps.setInt(7, libro.getDisponibles());
            ps.setInt(8, libro.getId());

            ps.executeUpdate();

            return true;

        } catch(SQLException e){

            System.out.println("Error al actualizar libro: " + e.getMessage());
            return false;
        }

    }

    // ELIMINAR LIBRO
    public boolean eliminar(int id) {


        String sql = "DELETE FROM tb_libros WHERE id=?";


        try(Connection con = Conexion.conectar();
            PreparedStatement ps = con.prepareStatement(sql)) {


            ps.setInt(1,id);

            ps.executeUpdate();

            return true;


        } catch(SQLException e){

            System.out.println("Error al eliminar libro: " + e.getMessage());
            return false;
        }

    }

    // buscar LIBRO
    public Libro buscar(int id) {

        String sql = "SELECT * FROM tb_libros WHERE id=?";

        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql);){
                ps.setInt(1,id);


                ResultSet rs = ps.executeQuery();
                Libro libro = new Libro();

                libro.setId(rs.getInt("id"));
                libro.setIsbn(rs.getString("isbn"));
                libro.setTitulo(rs.getString("titulo"));
                libro.setAutor(rs.getString("autor"));
                libro.setEditorial(rs.getString("editorial"));
                libro.setAnio(rs.getInt("anio"));
                libro.setExistencias(rs.getInt("existencias"));
                libro.setDisponibles(rs.getInt("disponibles"));
            return libro;
                


        } catch (SQLException e) {
            System.out.println("Error al listar libros: " + e.getMessage());
            return null;
        }
    }

}

