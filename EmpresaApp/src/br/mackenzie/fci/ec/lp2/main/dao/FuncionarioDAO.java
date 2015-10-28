/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.fci.ec.lp2.main.dao;

import br.mackenzie.fci.ec.lp2.main.model.Funcionario;
import br.mackenzie.fci.ec.lp2.mainn.Principal;
import br.mackenzie.fci.ec.lp2.mainn.exception.PersistenciaException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author 41487532
 */
public class FuncionarioDAO implements GenericoDAO<Funcionario>{

     @Override
    public List<Funcionario> listar() throws PersistenciaException {
        List<Funcionario> funcionarios = new ArrayList<>();
        //~~~~~~~~~~~~~~PASSO 2 - CRIA QUERY E STATEMENT~~~~~~~~~~~~~~//
        String sql = "SELECT * FROM EMPRESA.FUNCIONARIO";
        try {
            Connection connection=Conexao.getInstance().getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            //~~~~~~~~~~~~~~PASSO 3 - EXECUTAR O STATEMENT~~~~~~~~~~~~~~//
            ResultSet rs = ps.executeQuery();
            //~~~~~~~~~~~~~~PASSO 4 - MOSTRAT RESULTADO~~~~~~~~~~~~~~//
            while (rs.next()) {
                int id = rs.getInt("id_funcionario");
                String nome = rs.getString("nome");
                int id_cargo = rs.getInt("id_cargo");
                int id_departamento = rs.getInt("id_departamento");
                Funcionario f = new Funcionario(id, nome, id_cargo, id_departamento);
                funcionarios.add(f);
            }
            //~~~~~~~~~~~~~~PASSO 5 - FECHAR TUDO~~~~~~~~~~~~~~//
            rs.close();
            ps.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return funcionarios;
    }

    @Override
    public void inserir(Funcionario funcionario) throws PersistenciaException {
        String sql = "INSERT INTO EMPRESA.FUNCIONARIO(nome,id_cargo,id_departamento) VALUES (?,?,?)";
        try {
            Connection connection=Conexao.getInstance().getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, funcionario.getNome());
            ps.setInt(2, funcionario.getCargo());
            ps.setInt(3, funcionario.getDepartamento());
            Integer resp = ps.executeUpdate();
            ps.close();
            connection.close();
        } catch (PersistenciaException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
             Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
         }
    }

    @Override
    public void alterar(Funcionario funcionario) throws PersistenciaException {
        String sql = "UPDATE EMPRESA.FUNCIONARIO SET nome=?,id_cargo=?,id_departamento=? WHERE id_funcionario=? ";
        try {
            Connection connection=Conexao.getInstance().getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, funcionario.getNome());
            ps.setInt(2, funcionario.getCargo());
            ps.setInt(3, funcionario.getDepartamento());
            ps.setInt(4, funcionario.getCodigo());
            Integer resp = ps.executeUpdate();
            ps.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void remover(Funcionario funcionario) throws PersistenciaException {
        String sql = "DELETE FROM EMPRESA.FUNCIONARIO WHERE id_funcionario=?";
        try {
            Connection connection=Conexao.getInstance().getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, funcionario.getCodigo());
            Integer resp = ps.executeUpdate();
            ps.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public Funcionario listarPorId(Funcionario funcionario) throws PersistenciaException {
        try {
            String sql="SELECT * FROM EMPRESA.FUNCIONARIO WHERE ID_FUNCIONARIO=?";
            Connection connection=Conexao.getInstance().getConnection();
            PreparedStatement ps=connection.prepareStatement(sql);
            ps.setInt(1, funcionario.getCodigo());
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                funcionario.setCodigo(rs.getInt(("ID_FUNCIONARIO")));
                funcionario.setNome(rs.getString(("NOME")));
                funcionario.setCargo(rs.getInt(("ID_CARGO")));
                funcionario.setDepartamento(rs.getInt(("ID_DEPARTAMENTO")));
            }
            rs.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(CargoDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenciaException("Erro ao enviar o comando para o banco de dados");
        }
        return funcionario;
    }
     
     public List listarJoin() {
        List funcionarios= new ArrayList<String>();
        //~~~~~~~~~~~~~~PASSO 2 - CRIA QUERY E STATEMENT~~~~~~~~~~~~~~//
        String sql = "SELECT F.ID_FUNCIONARIO, F.NOME, C.NOME CARGO, D.NOME DEPARTAMENTO\n" +
                    "FROM EMPRESA.FUNCIONARIO  AS F \n" +
                    "INNER JOIN EMPRESA.CARGO AS C\n" +
                    "ON F.ID_CARGO = C.ID_CARGO\n" +
                    "INNER JOIN EMPRESA.DEPARTAMENTO D\n" +
                    "ON F.ID_DEPARTAMENTO = D.ID_DEPARTAMENTO";
        try {
            Connection connection=Conexao.getInstance().getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            //~~~~~~~~~~~~~~PASSO 3 - EXECUTAR O STATEMENT~~~~~~~~~~~~~~//
            ResultSet rs = ps.executeQuery();
            //~~~~~~~~~~~~~~PASSO 4 - MOSTRAT RESULTADO~~~~~~~~~~~~~~//
            while (rs.next()) {
                funcionarios.add(Integer.toString(rs.getInt("ID_FUNCIONARIO")));
                funcionarios.add(rs.getString("NOME"));
                funcionarios.add(rs.getString("CARGO"));
                funcionarios.add(rs.getString("DEPARTAMENTO"));
            }
            //~~~~~~~~~~~~~~PASSO 5 - FECHAR TUDO~~~~~~~~~~~~~~//
            rs.close();
            ps.close();
            connection.close();
        } catch (SQLException | PersistenciaException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return funcionarios;
    }
    
}
