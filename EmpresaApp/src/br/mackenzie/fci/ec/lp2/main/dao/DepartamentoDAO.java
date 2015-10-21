/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.fci.ec.lp2.main.dao;

import br.mackenzie.fci.ec.lp2.main.model.Departamento;
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
public class DepartamentoDAO implements GenericoDAO<Departamento> {

    @Override
    public List<Departamento> listar() {
        List<Departamento> departamentos = new ArrayList<Departamento>();
        try {
            Connection connection=Conexao.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM EMPRESA.DEPARTAMENTO");
            while (result.next()) {
                departamentos.add(new Departamento(Integer.parseInt(result.getString("ID_DEPARTAMENTO")), result.getString("NOME")));
            }
            statement.close();
            result.close();
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (PersistenciaException ex) {
            Logger.getLogger(DepartamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return departamentos;
    }

    @Override
    public void inserir(Departamento departamento) {
        String sql = "INSERT INTO EMPRESA.DEPARTAMENTO(nome) VALUES (?)";
        try {
            Connection connection=Conexao.getInstance().getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, departamento.getNome());
            Integer resp = ps.executeUpdate();
            ps.close();
            connection.close();
        } catch (PersistenciaException | SQLException ex) {
            Logger.getLogger(DepartamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    @Override
    public void alterar(Departamento departamento) {
        String sql = "UPDATE EMPRESA.DEPARTAMENTO SET nome=? WHERE id_departamento=? ";
        try {
            Connection connection=Conexao.getInstance().getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, departamento.getNome());
            ps.setInt(2, departamento.getCodigo());
            Integer resp = ps.executeUpdate();
            ps.close();
            connection.close();
        } catch (SQLException | PersistenciaException ex) {
            Logger.getLogger(DepartamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void remover(Departamento departamento) {
        String sql = "DELETE FROM EMPRESA.DEPARTAMENTO WHERE nome=?";
        try {
            Connection connection=Conexao.getInstance().getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, departamento.getNome());
            Integer resp = ps.executeUpdate();
            ps.close();
            connection.close();
        } catch (SQLException | PersistenciaException ex) {
            Logger.getLogger(DepartamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Departamento listarPorId(Departamento departamento) throws PersistenciaException {
        try {
            String sql="SELECT * FROM EMPRESA.DEPARTAMENTO WHERE ID_DEPARTAMENTO=?";
            Connection connection=Conexao.getInstance().getConnection();
            PreparedStatement ps=connection.prepareStatement(sql);
            ps.setInt(1, departamento.getCodigo());
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                departamento.setCodigo(rs.getInt(("ID_DEPARTAMENTO")));
                departamento.setNome(rs.getString(("NOME")));
            }
            rs.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(CargoDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenciaException("Erro ao enviar o comando para o banco de dados");
        }
        return departamento;
    }

}
