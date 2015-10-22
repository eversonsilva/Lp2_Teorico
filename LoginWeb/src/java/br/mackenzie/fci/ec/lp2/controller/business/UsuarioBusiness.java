/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.fci.ec.lp2.controller.business;

import br.mackenzie.fci.ec.lp2.model.Usuario;
import br.mackenzie.fci.ec.lp2.model.dao.ConnectionFactory;
import br.mackenzie.fci.ec.lp2.model.dao.UsuarioDAO;
import com.sun.xml.ws.transport.tcp.io.Connection;
import java.io.IOException;
import static java.lang.System.out;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Everson
 */
@WebServlet(name = "UsuarioBusiness", urlPatterns = {"/usuario"})
public class UsuarioBusiness extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {

        if ("Usuario.cadastrar".equals(request.getParameter("command"))) {

            Usuario usuario = new Usuario();
            usuario.setUsername(request.getParameter("username"));
            usuario.setSenha(request.getParameter("senha"));
            new UsuarioDAO().insert(usuario);
            //request.setAttribute("usuarios", new UsuarioDAO().listar());
            request.getRequestDispatcher("WEB-INF/jsp/bemVindo.jsp").forward(request, response);
        }
        if ("Usuario.formulario".equals(request.getParameter("command"))) {
            request.getRequestDispatcher("WEB-INF/jsp/cadastrar.jsp").forward(request, response);
        }
        if ("Usuario.verifica".equals(request.getParameter("command"))) {
            request.getRequestDispatcher("WEB-INF/jsp/bemVindo.jsp").forward(request, response);
        }
        if ("Usuario.sejaBemVindo".equals(request.getParameter("command"))) {

            Usuario usuario = new Usuario();
            usuario.setUsername(request.getParameter("username"));
            usuario.setSenha(request.getParameter("password"));
            new UsuarioDAO().readByName("username");
            request.setAttribute("username", usuario);
            request.getRequestDispatcher("WEB-INF/jsp/bemVindo.jsp").forward(request, response);
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioBusiness.class.getName()).log(Level.SEVERE, null, ex);
        }
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

        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioBusiness.class.getName()).log(Level.SEVERE, null, ex);
        }

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Cookie ck = new Cookie("NOME", "VALOR"); //Nome do cookie e o valor que ele deve conter 

        response.addCookie(new Cookie("br.mackenzie.fci.lp2.usuario", username));
        response.addCookie(new Cookie("br.mackenzie.fci.lp2.senha", password));

        ck.setMaxAge(-1); //Marca que o cookie tem vida até o fim da sessão  

        response.addCookie(ck);//O servlet já te traz o HttpServletResponse     

        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (int i = 0; i < cookies.length; i++) {
                if (cookies[i].getName().equals("br.mackenzie.fci.lp2.usuario")) {
                    out.print(cookies[i].getValue());
                }
                if (cookies[i].getName().equals("br.mackenzie.fci.lp2.senha")) {
                    out.print(cookies[i].getValue());
                }
            }
        }
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

}
