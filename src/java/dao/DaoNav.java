
package dao;

import conexion.Cl_Conexion;
import entidades.Navegacion;
import java.sql.ResultSet;


public class DaoNav {
    
    private Navegacion navegacion;
    
    public boolean Validar(Navegacion navParam){
        try {
            String sql="select * from NAVEGACION where idNavegacion='@id'";
            sql=sql.replaceAll("@id", Integer.toString(navParam.getIdNavegacion()));
            ResultSet rs=new Cl_Conexion().sqlSeleccion(sql);            
            while(rs.next()){
                navegacion=new Navegacion();
                navegacion.setPrecio(rs.getInt("precio"));
                navegacion.setDescripcion(rs.getString("descripcion"));
                return true;
            }
            return false;
        } catch (Exception e) {
            System.out.println("Error Validar:"+e.getMessage());
            return false;
        }
    }

    public Navegacion getNavegacion() {
        return navegacion;
    }
}
