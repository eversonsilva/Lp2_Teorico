/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.fci.ec.lp2.controller;

/**
 *
 * @author 41487532
 */
public class FrontController {
    if(command.startsWith("usuario")){
                
                if(command.endsWith("login")){
                    
                    String username = request.getParameter("username");
                    String password = request.getParameter("password");
             
                    if(LoginManager.authorize(username, password)){
                        out.println("<h1>BEM VINDO "+username+"</h1>");
                    } else {
                        out.println("YOU SHALL NOT PASS!");
                    }
                }
                
                
            }
}
