/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.fci.ec.lp2.main.dao;

import br.mackenzie.fci.ec.lp2.mainn.exception.PersistenciaException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 41487532
 */
public class Conexao {

    private static ResourceBundle bundle;
    private static Conexao conexao;

    private Conexao() {
        bundle = ResourceBundle.getBundle("br.mackenzie.fci.ec.lp2.main.util.configuracao");
    }

    public static Conexao getInstance() {
        if (conexao == null) {
            conexao = new Conexao();
        }
        return conexao;
    }

    public Connection getConnection() throws PersistenciaException {
        Connection connection = null;

        try {

            Class.forName(bundle.getString("drive"));
            connection = DriverManager.getConnection(bundle.getString("url"), bundle.getString("usuario"), bundle.getString("senha"));
//            connection = DriverManager.getConnection("jdbc:derby://localhost:1527/Empresa","mack", "mack");

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenciaException("Não foi possivel carregar o drive de comunicação com a base de dados!");
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenciaException("Erro na escrita/leitura da base de dados!");
        }
        return connection;
    }
}
