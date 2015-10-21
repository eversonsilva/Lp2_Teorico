/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import br.mackenzie.fci.ec.lp2.model.Funcionario;
import br.mackenzie.fci.ec.lp2.model.Cargo;
import br.mackenzie.fci.ec.lp2.model.Departamento;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 41487532
 */
public class Principal {

    public static void main(String[] args) throws Exception {
        FileOutputStream arquivo = new FileOutputStream("e:\\3º semestre\\teorico_lp2\\teste1.txt");
        ObjectOutputStream gravador = new ObjectOutputStream(arquivo);

        List<Funcionario> funcionarios = new ArrayList();
        List<Cargo> cargos = new ArrayList();

        Departamento d0 = new Departamento(1,"Economia");
        Departamento d1 = new Departamento(2,"Administração");
        Departamento d2 = new Departamento(3,"RH");
        
        Cargo c0 = new Cargo(1,"Gerente");
        Cargo c1 = new Cargo(2,"Diretor");
        Cargo c2 = new Cargo(3,"Estagiario");
        
        cargos.add(c0);
        cargos.add(c1);
        cargos.add(c2);
        
        Funcionario f0 = new Funcionario(1,"Everson", LocalDate.of(2014, Month.JULY, 07));
        Funcionario f1 = new Funcionario(2,"Lucas",LocalDate.of(2015,Month.JANUARY, 19));
        Funcionario f2 = new Funcionario(3,"Luiz",LocalDate.of(2013,Month.NOVEMBER, 28));
        
        funcionarios.add(f0);
        funcionarios.add(f1);
        funcionarios.add(f2);

        gravador.writeObject(funcionarios);
        gravador.writeObject(cargos);
        gravador.close();
        arquivo.close();

        //Saida de dados
        
        FileInputStream arquivoSaida = new FileInputStream("e:\\3º semestre\\teorico_lp2\\teste1.txt");
        ObjectInputStream leitor = new ObjectInputStream(arquivoSaida);

        // LENDO LISTA
        List<Funcionario> funcionariosSaida = (List) leitor.readObject();
        List<Cargo> cargosSaida = (List) leitor.readObject();
        // EXIBINDO LISTA
        System.out.println(funcionariosSaida);
        System.out.println(cargosSaida);

        //FECHANDO LEITOR
        leitor.close();
        arquivoSaida.close();

    }
}