/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.fci.ec.lp2.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Funcionario implements Serializable{
      
    private Integer codigo;
    private String nome;
    private LocalDate contratacao;
    private List<Cargo> cargos;

    public Funcionario(Integer codigo, String nome, LocalDate contratacao) {
        this.codigo = codigo;
        this.nome = nome;
        this.contratacao = contratacao;
        cargos = new ArrayList();
    }

    public List<Cargo> getCargos() {
        return cargos;
    }

    public void setCargos(List<Cargo> cargos) {
        this.cargos = cargos;
    }
    
    public LocalDate getContratacao() {
        return contratacao;
    }

    public void setContratacao(LocalDate contratacao) {
        this.contratacao = contratacao;
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

    @Override
    public String toString() {
        return "codigo = " + codigo + ", nome = " + nome + ", contratacao = " + contratacao;
    }
    
}
