
package dao;

import conexion.Cl_Conexion;
import entidades.Minutos;
import java.sql.ResultSet;


public class DaoMin {
    
    private Minutos minutos;
    
    public boolean Validar(Minutos navParam){
        try {
            String sql="select * from MINUTOS where idMinutos='@id'";
            sql=sql.replaceAll("@id", Integer.toString(navParam.getIdMinutos()));
            ResultSet rs=new Cl_Conexion().sqlSeleccion(sql);            
            while(rs.next()){
                minutos=new Minutos();
                minutos.setPrecio(rs.getInt("precio"));
                minutos.setDescripcion(rs.getString("descripcion"));
                return true;
            }
            return false;
        } catch (Exception e) {
            System.out.println("Error Validar:"+e.getMessage());
            return false;
        }
    }

    public Minutos getMinutos() {
        return minutos;
    }
}
