/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.fci.ec.lp2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author 41487532
 */
public class Teclado {
    
    static public void main(String[] args) {
        try {
            InputStreamReader dados = new InputStreamReader(System.in);
            BufferedReader teclado = new BufferedReader(dados);
            System.out.print("digite uma frase: ");
            String frase = teclado.readLine();
            System.out.println("Frase digitada:\t" + frase);
        } catch (Exception erro) {
            System.out.println("Erro na leitura do arquivo");
        }
    }
}
