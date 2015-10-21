/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.fci.ec.lp2.controller.business;

import br.mackenzie.fci.ec.lp2.main.dao.DepartamentoDAO;
import br.mackenzie.fci.ec.lp2.main.model.Departamento;
import br.mackenzie.fci.ec.lp2.mainn.exception.PersistenciaException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author GabrielOutor
 */
@WebServlet(name = "DepartamentoBusiness", urlPatterns = {"/departamento"})
public class DepartamentoBusiness extends HttpServlet {

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
            throws ServletException, IOException {
        
        try (PrintWriter out = response.getWriter()) {
            if(request != null && request.getParameter("command") != null){
                
                if("Departamento.confirmar-alteracao".equals(request.getParameter("command"))){
                    Departamento departamento=new Departamento();
                    departamento.setNome(request.getParameter("nome"));
                    departamento.setCodigo(Integer.parseInt(request.getParameter("codigo")));
                    new DepartamentoDAO().alterar(departamento);
                    request.setAttribute("departamentos", new DepartamentoDAO().listar());
                    request.getRequestDispatcher("WEB-INF/jsp/departamento/listar.jsp").forward(request, response);
                }
                if("Departamento.confirmar-remocao".equals(request.getParameter("command"))){
                    Departamento departamento=new Departamento();
                    departamento.setNome(request.getParameter("nome"));
                    departamento.setCodigo(Integer.parseInt(request.getParameter("codigo")));
                    new DepartamentoDAO().remover(departamento);
                    request.setAttribute("departamentos", new DepartamentoDAO().listar());
                    request.getRequestDispatcher("WEB-INF/jsp/departamento/listar.jsp").forward(request, response);
                }
                if("Departamento.alterarPorId".equals(request.getParameter("command"))){
                    Departamento departamento = new Departamento(Integer.parseInt(request.getParameter("departamentos")));
                    request.setAttribute("departamento", new DepartamentoDAO().listarPorId(departamento));
                    request.getRequestDispatcher("WEB-INF/jsp/departamento/confirmarAlteracao.jsp").forward(request, response);
                }
                if("Departamento.removerPorId".equals(request.getParameter("command"))){
                    try {
                        Departamento departamento = new Departamento(Integer.parseInt(request.getParameter("departamentos")));
                        request.setAttribute("departamento", new DepartamentoDAO().listarPorId(departamento));
                        request.getRequestDispatcher("WEB-INF/jsp/departamento/confirmarRemocao.jsp").forward(request, response);
                    } catch (PersistenciaException ex) {
                        Logger.getLogger(CargoBusiness.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if("Departamento.alterar".equals(request.getParameter("command"))){
                    request.setAttribute("departamentos", new DepartamentoDAO().listar());
                    request.getRequestDispatcher("WEB-INF/jsp/departamento/alterar.jsp").forward(request, response);
                }
                if("Departamento.remover".equals(request.getParameter("command"))){
                    request.setAttribute("departamentos", new DepartamentoDAO().listar());
                    request.getRequestDispatcher("WEB-INF/jsp/departamento/remover.jsp").forward(request, response);
                
                }
                if("Departamento.formulario".equals(request.getParameter("command"))){
                    request.getRequestDispatcher("WEB-INF/jsp/departamento/inserir.jsp").forward(request, response);
                }
                if("Departamento.inserir".equals(request.getParameter("command"))){
                    Departamento departamento=new Departamento();
                    departamento.setNome(request.getParameter("name"));
                    new DepartamentoDAO().inserir(departamento);
                    request.setAttribute("departamentos", new DepartamentoDAO().listar());
                    request.getRequestDispatcher("WEB-INF/jsp/departamento/listar.jsp").forward(request, response);
                }
                if("Departamento.listar".equals(request.getParameter("command"))){
                    request.setAttribute("departamentos", new DepartamentoDAO().listar());
                    request.getRequestDispatcher("WEB-INF/jsp/departamento/listar.jsp").forward(request, response);
                }
            }
            } catch (PersistenciaException ex) {
                Logger.getLogger(DepartamentoBusiness.class.getName()).log(Level.SEVERE, null, ex);
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

}