/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.fci.ec.lp2.model;

import java.io.Serializable;

/**
 *
 * @author Everson
 */
public class Usuario implements Serializable {
    
    private int id_usuario;
    private String username, senha;
    
    //---------------------CONSTRUTORES----------------------------------

    public Usuario() {
        this.id_usuario = -1;
        this.username = "anonimo";
        this.senha = "123";
    }

    public Usuario(String username, String senha) {
        this.id_usuario = -1;
        this.username = username;
        this.senha = senha;
    }

    public Usuario(int id_usuario, String username, String senha) {
        this.id_usuario = id_usuario;
        this.username = username;
        this.senha = senha;
    }
    
    //-----------------------GETTER E SETTER---------------------

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    //-------------TOSTRING------------------------------

    @Override
    public String toString() {
        return "Usuario { id_usuario = "+this.id_usuario+", username = "+this.username+", senha = "+this.senha+" }";
    }
    
}
