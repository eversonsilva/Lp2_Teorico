/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.fci.ec.lp2.controller.business;

import br.mackenzie.fci.ec.lp2.main.dao.CargoDAO;
import br.mackenzie.fci.ec.lp2.main.dao.DepartamentoDAO;
import br.mackenzie.fci.ec.lp2.main.dao.FuncionarioDAO;
import br.mackenzie.fci.ec.lp2.main.model.Cargo;
import br.mackenzie.fci.ec.lp2.main.model.Departamento;
import br.mackenzie.fci.ec.lp2.main.model.Funcionario;
import br.mackenzie.fci.ec.lp2.mainn.exception.PersistenciaException;
import java.io.IOException;
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
@WebServlet(name = "FuncionarioBusiness", urlPatterns = {"/funcionario"})
public class FuncionarioBusiness extends HttpServlet {

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
        
        if(request != null && request.getParameter("command") != null){
                
            if("Funcionario.confirmar-alteracao".equals(request.getParameter("command"))){
                try {
                    Funcionario funcionario=new Funcionario();
                    funcionario.setNome(request.getParameter("nome"));
                    funcionario.setCodigo(Integer.parseInt(request.getParameter("codigo")));
                    new FuncionarioDAO().alterar(funcionario);
                    request.setAttribute("funcioanrios", new FuncionarioDAO().listar());
                    request.getRequestDispatcher("WEB-INF/jsp/funcionario/listar.jsp").forward(request, response);
                } catch (PersistenciaException ex) {
                    Logger.getLogger(CargoBusiness.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if("Funcionario.confirmar-remocao".equals(request.getParameter("command"))){
                try {
                    Funcionario funcionario=new Funcionario();
                    funcionario.setNome(request.getParameter("nome"));
                    funcionario.setCodigo(Integer.parseInt(request.getParameter("codigo")));
                    //funcionario.setCargo(Integer.SIZE);
                    //funcionario.setDepartamento(Integer.MIN_VALUE);
                    new FuncionarioDAO().remover(funcionario);
                    request.setAttribute("funcionarios", new FuncionarioDAO().listar());
                    request.getRequestDispatcher("WEB-INF/jsp/funcionario/listar.jsp").forward(request, response);
                } catch (PersistenciaException ex) {
                    Logger.getLogger(CargoBusiness.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if("Funcionario.alterarPorId".equals(request.getParameter("command"))){
                try {
                    Funcionario funcionario = new Funcionario(Integer.parseInt(request.getParameter("funcionarios")));
                    request.setAttribute("cargos", new CargoDAO().listar());
                    request.setAttribute("departamentos", new DepartamentoDAO().listar());
                    request.setAttribute("funcionario", new FuncionarioDAO().listarPorId(funcionario));
                    request.getRequestDispatcher("WEB-INF/jsp/funcionario/confirmarAlteracao.jsp").forward(request, response);
                } catch (PersistenciaException ex) {
                    Logger.getLogger(CargoBusiness.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if("Funcionario.removerPorId".equals(request.getParameter("command"))){
                try {
                    Funcionario funcionario = new Funcionario(Integer.parseInt(request.getParameter("funcionarios")));
                    Cargo cargo = new Cargo(Integer.parseInt(request.getParameter("cargos")));
                    Departamento departamento = new Departamento(Integer.parseInt(request.getParameter("departamentos")));
                    request.setAttribute("cargo", new CargoDAO().listarPorId(cargo));
                    request.setAttribute("departamento", new DepartamentoDAO().listarPorId(departamento));
                    request.setAttribute("funcionario", new FuncionarioDAO().listarPorId(funcionario));
                    request.getRequestDispatcher("WEB-INF/jsp/funcionario/confirmarRemocao.jsp").forward(request, response);
                } catch (PersistenciaException ex) {
                    Logger.getLogger(CargoBusiness.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if("Funcionario.alterar".equals(request.getParameter("command"))){
                try {
                    request.setAttribute("funcionarios", new FuncionarioDAO().listar());
                    request.setAttribute("cargos", new CargoDAO().listar());
                    request.setAttribute("departamentos", new DepartamentoDAO().listar());
                    request.getRequestDispatcher("WEB-INF/jsp/funcionario/alterar.jsp").forward(request, response);
                } catch (PersistenciaException ex) {
                    Logger.getLogger(CargoBusiness.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if("Funcionario.remover".equals(request.getParameter("command"))){
                try {
                    request.setAttribute("funcionarios", new FuncionarioDAO().listar());
                    request.setAttribute("cargos", new CargoDAO().listar());
                    request.setAttribute("departamentos", new DepartamentoDAO().listar());
                    request.getRequestDispatcher("WEB-INF/jsp/funcionario/remover.jsp").forward(request, response);
                } catch (PersistenciaException ex) {
                    Logger.getLogger(CargoBusiness.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }           
            if("Funcionario.formulario".equals(request.getParameter("command"))){
                try {
                    request.setAttribute("cargos", new CargoDAO().listar());
                    request.setAttribute("departamentos", new DepartamentoDAO().listar());
                    request.getRequestDispatcher("WEB-INF/jsp/funcionario/inserir.jsp").forward(request, response);
                } catch (PersistenciaException ex) {
                    Logger.getLogger(FuncionarioBusiness.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if("Funcionario.inserir".equals(request.getParameter("command"))){
                try {
                    Funcionario funcionario=new Funcionario();
                    funcionario.setNome(request.getParameter("name"));//Integer.parseInt(request.getParameter("funcionarios"))
                    funcionario.setCargo(Integer.parseInt(request.getParameter("cargos")));
                    funcionario.setDepartamento(Integer.parseInt(request.getParameter("departamentos")));
                    new FuncionarioDAO().inserir(funcionario);
                    request.setAttribute("funcionarios", new FuncionarioDAO().listar());
                    
                    request.getRequestDispatcher("WEB-INF/jsp/funcionario/listar.jsp").forward(request, response);
                } catch (PersistenciaException ex) {
                    Logger.getLogger(FuncionarioBusiness.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if("Funcionario.listar".equals(request.getParameter("command"))){
                try {
                    request.setAttribute("funcionarios", new FuncionarioDAO().listar());
                    request.getRequestDispatcher("WEB-INF/jsp/funcionario/listar.jsp").forward(request, response);
                } catch (PersistenciaException ex) {
                    Logger.getLogger(FuncionarioBusiness.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
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