/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import com.sun.mail.smtp.DigestMD5;
import conexion.Cl_Conexion;
import dao.DaoCliente;
import dao.DaoSolicitud;
import entidades.Cliente;
import entidades.Comuna;
import entidades.Minutos;
import entidades.Navegacion;
import entidades.Solicitud;
import java.sql.*;
import java.util.Date;
import utilidades.ValidaRut;


/**
 *
 * @author scarecrow
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // TODO code application logic here
        //DaoCliente dao = new DaoCliente();

//        Comuna co = new Comuna(1);
//        
   //Cliente c = new Cliente("192778069", "marco", "Marco", "Mella", "Cárcamo","palo de rosa", 2680, new Comuna(1), 43434);
        //dao.Grabar(c);
//         String contra = DigestUtils.md5Hex("marco");
//         System.out.println(""+contra);
//         
//         boolean resp = dao.Validar(new Cliente("192778069",contra));
//         if (resp) {
//             System.out.println("existe");
//             System.out.println("cliente:"+dao.getCliente().getNombre());
//        }
//         else{
//             System.out.println("no existe");
////      
//        String sql = "select s.idSolicitud CODIGO"
//                + "      ,SUBSTRING(n.descripcion,1,2)GIGAS"
//                + "      ,SUBSTRING(m.descripcion,1,4)MINUTOS"
//                + "      ,s.entrega AS 'ENTREGA DE CHIP'"
//                + "      ,c.telefono TELEFONO"
//                + "      ,com.comuna COMUNA"
//                + "      ,s.fecha_hora INGRESO"
//                + "      ,s.total TOTAL"
//                + " from SOLICITUD s join NAVEGACION n"
//                + " on s.Navegacion_cuota = n.idNavegacion"
//                + " join MINUTOS m"
//                + " on s.Minutos_minutos = m.idMinutos"
//                + " join CLIENTE c"
//                + " on s.Cliente_rut = c.rut"
//                + " join COMUNA com"
//                + " on c.Comuna_idComuna = com.idComuna"
//                + " where c.rut = '192778069'";
//      ResultSet rs = new Cl_Conexion().sqlSeleccion(sql);
//        System.out.println("Fname  Lname   ISBN");
//        while (rs.next()) {
//            int codigo = rs.getInt("codigo");
//            String giga = rs.getString("gigas");
//            int minutos = rs.getInt("minutos");
//            String entrega = rs.getString("entrega de chip");
//            int telef = rs.getInt("telefono");
//            String comuna = rs.getString("comuna");
//            Date ingreso = rs.getDate("ingreso");
//            int total = rs.getInt("total");
//            System.out.println(codigo + "  " + giga + "   " + minutos
//            + "  "+entrega+ "  "+telef+ "  "+comuna+ "  "+ingreso+ "  "+total);
//        }
//        System.out.println();
//        System.out.println();
//
////    }
//
  DaoSolicitud dao = new DaoSolicitud();
////    
    //Date a = new Date();
    
    java.sql.Timestamp d = new java.sql.Timestamp(new java.util.Date().getTime());
    
        //°System.out.println(""+c.getDireccion());
        System.out.println(d.toString());
////    
   dao.Grabar(new Solicitud(3, "a",5000, d, new Cliente("192778069"),new Minutos(1), new Navegacion(1)));
////    
//    ValidaRut v = new ValidaRut();
//    
//    boolean resp = v.validar("19.643.566-2");
//    
//        if (resp) {
//            System.out.println("rut valido");
//        }
//        else{
//            System.out.println("rut invalido");
//        }
//    
    }

}
