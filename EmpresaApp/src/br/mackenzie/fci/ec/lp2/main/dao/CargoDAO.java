/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.fci.ec.lp2.main.dao;

import br.mackenzie.fci.ec.lp2.main.model.Cargo;
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
public class CargoDAO implements GenericoDAO<Cargo> {

    @Override
    public List<Cargo> listar() throws PersistenciaException {
        List<Cargo> cargos = new ArrayList<Cargo>();
        try {
            Connection connection=Conexao.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM EMPRESA.CARGO");
            while (result.next()) {
                cargos.add(new Cargo(Integer.parseInt(result.getString("ID_CARGO")), result.getString("NOME")));
            }
            statement.close();
            result.close();
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (PersistenciaException ex) {
            Logger.getLogger(CargoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cargos;
    }

    @Override
    public void inserir(Cargo cargo) throws PersistenciaException {
        try {
            String sql="INSERT INTO EMPRESA.CARGO(NOME) VALUES(?)";
            Connection connection = Conexao.getInstance().getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, cargo.getNome());
            ps.executeUpdate();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(CargoDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenciaException("Erro na escrita/leitura do banco de dados");
        }
    }

    @Override
    public void alterar(Cargo cargo) throws PersistenciaException {
        String sql = "UPDATE EMPRESA.CARGO SET nome=? WHERE id_cargo=? ";
        try {
            Connection connection=Conexao.getInstance().getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, cargo.getNome());
            ps.setInt(2, cargo.getCodigo());
            
            Integer resp = ps.executeUpdate();
            
            ps.close();
            connection.close();
            
        } catch (SQLException | PersistenciaException ex) {
            Logger.getLogger(DepartamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void remover(Cargo cargo) throws PersistenciaException {
        String sql = "DELETE FROM EMPRESA.CARGO WHERE nome=?";
        try {
            Connection connection=Conexao.getInstance().getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, cargo.getNome());
            
            Integer resp = ps.executeUpdate();
            
            ps.close();
            connection.close();
            
        } catch (SQLException | PersistenciaException ex) {
            Logger.getLogger(DepartamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Cargo listarPorId(Cargo cargo) throws PersistenciaException {
        try {
            String sql="SELECT * FROM EMPRESA.CARGO WHERE ID_CARGO=?";
            Connection connection=Conexao.getInstance().getConnection();
            PreparedStatement ps=connection.prepareStatement(sql);
            ps.setInt(1, cargo.getCodigo());
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                cargo.setCodigo(rs.getInt(("ID_CARGO")));
                cargo.setNome(rs.getString(("NOME")));
            }
            rs.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(CargoDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenciaException("Erro ao enviar o comando para o banco de dados");
        }
        return cargo;
    }
    }
