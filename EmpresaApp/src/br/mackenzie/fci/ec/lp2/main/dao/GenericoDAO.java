/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.fci.ec.lp2.main.dao;

import br.mackenzie.fci.ec.lp2.mainn.exception.PersistenciaException;
import java.util.List;

/**
 *
 * @author 41487532
 */
public interface GenericoDAO<E> {
     List<E> listar() throws PersistenciaException;
     void inserir(E e)throws PersistenciaException;
     void remover(E e)throws PersistenciaException;
     void alterar(E e)throws PersistenciaException;
}
