/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.fci.ec.lp2.model.dao;

import br.mackenzie.fci.ec.lp2.model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Everson
 */
public class UsuarioDAO implements GenericDAO<Usuario> {
    
    private Connection con;
    
    //==================================INSERIR NA TABELA================================================

    @Override
    public boolean insert(Usuario usuario) {
        
        boolean resposta = false;
        
        con = ConnectionFactory.getConnection();
        
        String sql = "INSERT INTO usuario(username, senha) VALUES (?,?)";
        
        try{
            
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, usuario.getUsername());
        ps.setString(2, usuario.getSenha());
        
        int resp = ps.executeUpdate();
        
        if(resp > 0){
            resposta = true;
        }        
        
        ps.close();
        con.close();
        
        }catch(SQLException ex){
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return resposta;
        
    }

    //==================================LER DA TABELA================================================
    
    @Override
    public List<Usuario> read() {
        
        List<Usuario> usuarios = new ArrayList<>();
        
        con = ConnectionFactory.getConnection();
        
        String sql = "SELECT * FROM usuario";
        
        try{
            
            PreparedStatement ps = con.prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                int id = rs.getInt("id_usuario");
                String username = rs.getString("username");
                String senha = rs.getString("senha");
                Usuario u = new Usuario(id, username, senha);
                usuarios.add(u);
            }
            
            ps.close();
            rs.close();
            con.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       return usuarios;
    }

    //==================================ATUALIZAR A TABELA================================================
    
    @Override
    public boolean update(Usuario usuario) {
        
        boolean resposta = false;
        
        con = ConnectionFactory.getConnection();
        
        String sql = "UPDATE usuario SET username = ?, senha = ? WHERE id_usuario = ?";
        
        try{
            
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, usuario.getUsername());
            ps.setString(2, usuario.getSenha());
            ps.setInt(3, usuario.getId_usuario());
            
           int resp = ps.executeUpdate();
           
           if(resp > 0){
               resposta = true;
           }
           
           ps.close();
           con.close();
           
        }catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return resposta;

    }

    //==================================DELETAR DA TABELA================================================
    
    @Override
    public boolean delete(Usuario usuario) {
        
        boolean resposta = false;
        
        con = ConnectionFactory.getConnection();
        
        String sql = "DELETE FROM usuario WHERE id_usuario = ?";
        
        try{
        
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, usuario.getId_usuario());
            
            int resp = ps.executeUpdate();
            
            if(resp > 0){
                resposta = true;
            }
            
            ps.close();
            con.close();
            
        }catch(SQLException ex){
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return resposta;
        
    }
}
