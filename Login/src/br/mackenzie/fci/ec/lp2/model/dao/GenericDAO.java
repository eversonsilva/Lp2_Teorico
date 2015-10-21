/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.fci.ec.lp2.model.dao;

import java.util.List;

/**
 *
 * @author Everson
 */
public interface GenericDAO<T> {
  
    //CRUD - create, read, update, delete
    
    public boolean insert(T t);
    public List<T> read();
    public boolean update(T t);
    public boolean delete(T t);

}
