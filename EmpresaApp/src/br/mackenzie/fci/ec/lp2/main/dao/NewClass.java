/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.fci.ec.lp2.main.dao;

import br.mackenzie.fci.ec.lp2.main.model.Cargo;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 41487532
 */
public class NewClass {
    public static void main(String args[]){
        List<String> objetos = new ArrayList();
        
        objetos.add("um");
        Cargo cargo = new Cargo();
        cargo.setCodigo(1);
        cargo.setNome("AT");
        
        for (Object objeto : objetos) {
            System.out.println(objeto);
        }
    }
}
