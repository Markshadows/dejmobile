

package dao;

import conexion.Cl_Conexion;
import entidades.Cliente;
import entidades.Navegacion;
import entidades.Solicitud;
import java.sql.*;
import java.util.ArrayList;
import javax.annotation.Resource;
import javax.sql.DataSource;


public class DaoCliente {
    @Resource (mappedName = "jdbc/DEJ")
    private DataSource ds;
    private Connection cone;
    private Cliente cliente;
    //private Logger log=Logger.getLogger(DaoCliente.class);
    
    public DaoCliente() {
        
        //cone=new Cl_Conexion().getConexion();
//        try {
//            log.addAppender(new FileAppender(new PatternLayout(), "/media/scarecrow/MULTIBOOT/texto.txt"));
//        } catch (Exception e) {
//            
//        }
    }
    //metodos
    public boolean Grabar(Cliente cliente){
        try {
            String sql="INSERT INTO CLIENTE VALUES"+
                    "('@RUT','@CLA','@NOM','@APP','@APM','@DIR', @NRC, @COM, @TEL)";
            sql=sql.replaceAll("@RUT", cliente.getRut());
            sql=sql.replaceAll("@CLA", cliente.getClave());
            sql=sql.replaceAll("@NOM", cliente.getNombre());
            sql=sql.replaceAll("@APP", cliente.getAppaterno());
            sql=sql.replaceAll("@APM", cliente.getApmaterno());
            sql=sql.replaceAll("@DIR", cliente.getDireccion());
            sql=sql.replaceAll("@NRC", Integer.toString(cliente.getNumeracion()));
            sql=sql.replaceAll("@COM", Integer.toString(cliente.getComunaidComuna().getIdComuna()));
            sql=sql.replaceAll("@TEL", Integer.toString(cliente.getTelefono()));

            boolean resp=new Cl_Conexion().sqlOperacion(sql);
            return resp;
        } catch (Exception e) {
            //Log4J
            System.out.println("Error Grabar Cliente:"+e.getMessage());  
            return false;
        }
    }
    
    //metodo validar
    public boolean Validar(Cliente cliParam){
        try {
            String sql="select * from CLIENTE where rut='@rut' and clave='@clave'";
            sql=sql.replaceAll("@rut", cliParam.getRut());
            sql=sql.replaceAll("@clave", cliParam.getClave());
            ResultSet rs=new Cl_Conexion().sqlSeleccion(sql);            
            while(rs.next()){
                cliente=new Cliente();
                cliente.setRut(cliParam.getRut());
                cliente.setClave(cliParam.getClave());
                cliente.setNombre(rs.getString("nombre"));
                cliente.setAppaterno(rs.getString("appaterno"));
                cliente.setApmaterno(rs.getString("apmaterno"));
                cliente.setDireccion(rs.getString("direccion"));
                cliente.setNumeracion(rs.getInt("numeracion"));
                return true;
            }
            return false;
        } catch (Exception e) {
            System.out.println("Error Validar:"+e.getMessage());
            return false;
        }
    }

    public Cliente getCliente() {
        return cliente;
    }
    

}
