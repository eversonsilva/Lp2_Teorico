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
public class Departamento implements Serializable {
    private Integer codigo;
    private String nome;
    
    public Departamento(){
    
    }

    public Departamento(Integer codigo){
        this.codigo = codigo;
    }
    
    public Integer getCodigo() {
        return codigo;
    }
    
    public Departamento(Integer codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
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

    @Override
    public String toString() {
        return "Departamento{" + "codigo=" + codigo + ", nome=" + nome + '}';
    }
    
    
    
}
