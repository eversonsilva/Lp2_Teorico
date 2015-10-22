/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.fci.ec.lp2.controller;

import br.mackenzie.fci.ec.lp2.model.Usuario;
import br.mackenzie.fci.ec.lp2.model.dao.UsuarioDAO;

/**
 *
 * @author 1147106
 */
public class LoginManager {
    
    public static boolean authorize(String username, String password){
        UsuarioDAO dao = new UsuarioDAO();
        Usuario usuario = dao.readByName(username);

        return !(usuario.getId_usuario() == -1 || !usuario.getSenha().equals(password));
    }
    
}
