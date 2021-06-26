
package dao;

import conexion.Cl_Conexion;
import entidades.Solicitud;
import java.sql.*;

public class DaoSolicitud {
    
   public boolean Grabar(Solicitud soliParam){
       try {
           
            String sql="INSERT INTO SOLICITUD VALUES"+
                    "(@id,'@rut',@nav,@min,'@ent',@tot, '@fec')";
            sql=sql.replaceAll("@id", Integer.toString(soliParam.getIdSolicitud()));
            sql=sql.replaceAll("@rut", soliParam.getClienterut().getRut());
            sql=sql.replaceAll("@nav", Integer.toString(soliParam.getNavegacioncuota().getIdNavegacion()));
            sql=sql.replaceAll("@min", Integer.toString(soliParam.getMinutosminutos().getIdMinutos()));
            sql=sql.replaceAll("@ent", soliParam.getEntrega());
            sql=sql.replaceAll("@tot", Integer.toString(soliParam.getTotal()));
            sql=sql.replaceAll("@fec", soliParam.getFechaHora().toString());

            boolean resp=new Cl_Conexion().sqlOperacion(sql);
            return resp;
        } catch (Exception e) {
            //Log4J
            System.out.println("Error Grabar Solicitud:"+e.getMessage());  
            return false;
        }
   }
   
   
    
}
