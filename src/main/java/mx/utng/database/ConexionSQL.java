package mx.utng.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionSQL {

    private static final String URL =
            "jdbc:sqlserver://localhost:1433;"
            + "databaseName=Biclio;"
            + "encrypt=true;"
            + "trustServerCertificate=true";

    private static final String USER = "sa";
    private static final String PASSWORD = "1234";

    public static Connection conectar() {

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            return DriverManager.getConnection(URL, USER, PASSWORD);

        } catch (ClassNotFoundException e) {
            System.out.println("No se encontró el Driver de SQL Server");
            e.printStackTrace();

        } catch (SQLException e) {
            System.out.println("Error al conectar con la base de datos");
            e.printStackTrace();
        }

        return null;
    }
}