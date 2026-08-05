package mx.utng.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import mx.utng.database.Conexion;

public class UsuarioDAO {
    public boolean validar(String usuario,String password){

        String sql =
        "SELECT * FROM tb_usuarios WHERE nombre=? AND password=?";

        try(Connection con = Conexion.conectar();
            PreparedStatement ps = con.prepareStatement(sql)){

            ps.setString(1, usuario);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            return rs.next();

        }catch(SQLException e){

            e.printStackTrace();

        }

        return false;

    } 
}
