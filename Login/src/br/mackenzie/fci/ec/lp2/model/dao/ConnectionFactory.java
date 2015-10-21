/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.fci.ec.lp2.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Everson
 */
public class ConnectionFactory {
    
    private static Connection con;
    private static String banco = "Usuario";
    private static String usuario = "mack";
    private static String senha = "mack";
    private static String driver = "org.apache.derby.jdbc.ClientDriver";
    private static String protocolo = "jdbc:derby:";
    private static String dominio = "//localhost:1527/";
    
    //getConnection(protocolo+dominio+banco, usuario, senha);
    
    public static Connection getConnection(){
        con=null;
        try {
            Class.forName(driver).newInstance();
            con = DriverManager.getConnection(protocolo+dominio+banco,usuario,senha);
                
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }    
}
