/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.fci.ec.lp2.main;

import br.mackenzie.fci.ec.lp2.model.Usuario;
import br.mackenzie.fci.ec.lp2.model.dao.UsuarioDAO;
import java.util.List;

/**
 *
 * @author Everson
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        
        List<Usuario> lista = usuarioDAO.read();
        for (Usuario usuario : lista) {
          System.out.println(usuario);
        }
        
        //USUARIODAO
        
        System.out.println("-----------------");

        Usuario u1 = new Usuario();
        u1.setSenha("987");
        u1.setUsername("Carlos");
        //usuarioDAO.insert(u1);

        //ATUALIZA USUARIO
        //Usuario u2 = lista.get(lista.size() - 1);
        //u2.setUsername("Joel");
        //u2.setSenha("321");
        //usuarioDAO.update(u2);

        //REMOVE USUARIO
        //Usuario u3 = lista.get(lista.size() - 1);
        //usuarioDAO.delete(u3);

        //REMOVE USARIO ESPECIFICO
        Usuario u4 = new Usuario();
        for (Usuario usuario : lista) {
            if (usuario.getUsername().equals("Carlos")) {
                u4 = usuario;
                break;
            }
        }
        //usuarioDAO.delete(u4);
        
        lista = usuarioDAO.read();
        for (Usuario usuario : lista) {
            System.out.println(usuario);
        }
        
    }
}
