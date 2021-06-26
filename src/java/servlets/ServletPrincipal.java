package servlets;

import dao.DaoCliente;
import dao.DaoMin;
import dao.DaoNav;
import dao.DaoSolicitud;
import entidades.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.codec.digest.*;
import utilidades.ValidaRut;
import java.util.*;

public class ServletPrincipal extends HttpServlet {

    Solicitud sol;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String boton = request.getParameter("btnAccion");

        if (boton.equals("Logear")) {
            logear(request, response);
        }
        if (boton.equals("GuardarCliente")) {
            guardarCliente(request, response);
        }
        if (boton.equals("Paso1")) {
            crearSolicitud(request, response);
        }
        if (boton.equals("Paso2")) {
            guardarSolicitud(request, response);
        }

    }

    private void logear(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession se = request.getSession();

        String rut = request.getParameter("rut");
        String clave = request.getParameter("clave");
        String claveEncriptada = DigestUtils.md5Hex(clave);

        Cliente cliente = new Cliente(rut, claveEncriptada);
        DaoCliente dao = new DaoCliente();

        boolean resp = false;
        try {
            resp = dao.Validar(cliente);
            String mensaje = (resp ? "Existe Usuario" : "Error");
            request.setAttribute("mensaje", mensaje);

        } catch (Exception e) {
            request.setAttribute("mensaje", e.getMessage());
        } finally {
            if (resp) {
                se.setAttribute("usuario", dao.getCliente().nombreCompleto());
                se.setAttribute("rut", dao.getCliente().getRut());
                se.setAttribute("direccion", dao.getCliente().direccionCompleta());
                request.getRequestDispatcher("menu.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        }

    }

    private void guardarCliente(HttpServletRequest request, HttpServletResponse response) throws IOException {

        ValidaRut v = new ValidaRut();
        boolean resp = v.validar(request.getParameter("rut"));
        if (resp) {

            String rut = request.getParameter("rut");
            String clave = request.getParameter("clave");
            String confirmaClave = request.getParameter("confirmarClave");
            String claveEncriptada = DigestUtils.md5Hex(clave);
            String nombre = request.getParameter("nombre");
            String appaterno = request.getParameter("appaterno");
            String apmaterno = request.getParameter("apmaterno");
            String direccion = request.getParameter("direccion");
            int numeracion = Integer.parseInt(request.getParameter("numeracion"));
            Comuna comuna = new Comuna(Integer.parseInt(request.getParameter("Cbocomuna")));
            int telefono = Integer.parseInt(request.getParameter("telefono"));

            if (clave.equals(confirmaClave)) {
                DaoCliente dao = new DaoCliente();

                if (dao.Grabar(new Cliente(rut, claveEncriptada, nombre, appaterno, apmaterno, direccion, numeracion, comuna, telefono))) {
                    request.getSession().setAttribute("mensaje", "Exito");
                    response.sendRedirect("registrate.jsp");
                } else {
                    request.getSession().setAttribute("mensaje", "Grabar");
                    response.sendRedirect("registrate.jsp");
                }
            } else {
                request.getSession().setAttribute("mensaje", "Clave");
                response.sendRedirect("registrate.jsp");
            }
        } else {
            request.getSession().setAttribute("mensaje", "Rut");
            response.sendRedirect("registrate.jsp");
        }

    }

    private void crearSolicitud(HttpServletRequest request, HttpServletResponse response) throws IOException {

        HttpSession se = request.getSession();

        try {
            DaoNav daoNav = new DaoNav();
            DaoMin daoMin = new DaoMin();

            // Variables para llenar la Solicitud
            Random random = new Random();
            int id = random.nextInt(100 - 1 + 1) + 1;
            String rut = se.getAttribute("rut").toString();
            java.sql.Timestamp d = new java.sql.Timestamp(new java.util.Date().getTime());
            String chx = request.getParameter("despacho");
            String entrega = "";
            if (chx != null) {
                entrega = se.getAttribute("direccion").toString();

            } else {
                entrega = "Retiro en sucursal";

            }
            int idNav = Integer.parseInt(request.getParameter("cboNavegacion"));
            Navegacion nav = new Navegacion(idNav);
            int idMin = Integer.parseInt(request.getParameter("cboMinutos"));
            Minutos min = new Minutos(idMin);
            int total = 0;

            if (nav!=null) {

                if (daoNav.Validar(nav)) {
                    if (daoMin.Validar(min)) {
                        total = daoNav.getNavegacion().getPrecio() + daoMin.getMinutos().getPrecio();
                        //Guardo los datos en variables de sesion para rescatarlos en paso 2
                        se.setAttribute("entrega", entrega);
                        se.setAttribute("total", total);
                        se.setAttribute("descripcionNav", daoNav.getNavegacion().getDescripcion());
                        se.setAttribute("descripcionMin", daoMin.getMinutos().getDescripcion());

                        sol = new Solicitud(id, entrega, total, d, new Cliente(rut), min, nav);
                        //se.setAttribute("mensaje", "grabo");
                        response.sendRedirect("solicitarPlan2.jsp");
                    } else {
                        se.setAttribute("mensaje", "MinInvalid");
                        response.sendRedirect("solicitarPlan1.jsp");
                    }
                } else {
                    se.setAttribute("mensaje", "NavInvalid");
                    response.sendRedirect("solicitarPlan1.jsp");
                }
            } else if(nav==null){
                se.setAttribute("mensaje", "Cuota");
                response.sendRedirect("solicitarPlan1.jsp");
            }

        } catch (Exception e) {
            se.setAttribute("mensaje", e.getMessage());
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void guardarSolicitud(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            DaoSolicitud dao = new DaoSolicitud();

            if (dao.Grabar(sol)) {
                request.getSession().setAttribute("mensaje", "Exito");
                response.sendRedirect("misPlanes.jsp");
            } else {
                request.getSession().setAttribute("mensaje", "Error");
                response.sendRedirect("solicitarPlan2.jsp");
            }

        } catch (Exception e) {
            request.getSession().setAttribute("mensaje", e.getMessage());
            response.sendRedirect("solicitarPlan2.jsp");
        }
    }

}
