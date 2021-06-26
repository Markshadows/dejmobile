package conexion;

import java.sql.*;
import javax.sql.DataSource;
import javax.annotation.Resource;


public class Cl_Conexion {

    private static Connection conexion;
    private String server = "jdbc:mysql://localhost:3306/Dej Mobile";
    private String user = "root";
    private String pass = "root";
    private DataSource ds;

    //private Logger log=Logger.getLogger(Cl_Conexion.class);
    public Cl_Conexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion=DriverManager.getConnection(server, user, pass);

              //conexion = ds.getConnection();

            //log.addAppender(new FileAppender(new PatternLayout(), "/media/scarecrow/MULTIBOOT/texto.txt"));
        } catch (Exception e) {
            //log.warn(e.getMessage());
            System.out.println("Error Conexion:" + e.getMessage());
        }
    }

    public Connection getConexion() {
        return conexion;
    }

    /////////////////////////////////////////
    public boolean sqlOperacion(String sql) {
        try {
            //insertar, eliminar y actualizar
            PreparedStatement pstm = conexion.prepareCall(sql);
            //log.warn("Ejecuto Instruccion sqlOperacion");
            return pstm.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("Error Ejecutar:" + e.getMessage());
            return false;
        }
    }

    public ResultSet sqlSeleccion(String sql) {
        try {
            //metodos select
            PreparedStatement pstm = conexion.prepareCall(sql);
            ResultSet rs = pstm.executeQuery();
            //log.warn("Ejecuto Instruccion sqlSeleccion");
            return rs;
        } catch (Exception e) {
            System.out.println("Error Seleccion:" + e.getMessage());
            return null;
        }
    }
    ///////////////////////////////////////////

}
