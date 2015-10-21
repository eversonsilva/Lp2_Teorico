/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.fci.ec.lp2.main.model;

import java.io.Serializable;

/**
 *
 * @author 41487532
 */
public class Funcionario implements Serializable {
    private Integer codigo;
    private String nome;
    private Integer cargo;
    private Integer departamento;        

    public Funcionario(){
    
    }
    
    public Funcionario(Integer codigo){
        this.codigo = codigo;
    }
    
    public Funcionario(Integer codigo, String nome, Integer cargo, Integer departamento) {
        this.codigo = codigo;
        this.nome = nome;
        this.cargo = cargo;
        this.departamento = departamento;
    }
    
    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public Integer getCargo() {
        return cargo;
    }

    public void setCargo(Integer cargo) {
        this.cargo = cargo;
    }

    public Integer getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Integer departamento) {
        this.departamento = departamento;
    }

    @Override
    public String toString() {
        return "Funcionario{" + "codigo=" + codigo + ", nome=" + nome + ", cargo=" + cargo + ", departamento=" + departamento + '}';
    }
}
