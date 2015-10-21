/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import br.mackenzie.fci.ec.lp2.model.Departamento;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

/**
 *
 * @author 41487532
 */
public class PrincipalLeitura {

    public static void main(String args []) throws Exception{
    FileInputStream arquivo = new FileInputStream("e:\\3º semestre\\teorico_lp2\\teste1.txt");
    ObjectInputStream leitor = new ObjectInputStream(arquivo);
    
    Departamento departamento = (Departamento) leitor.readObject();
    System.out.println(departamento.getCodigo());
    System.out.println(departamento.getNome());
    
    leitor.close ();

    arquivo.close ();
}
}