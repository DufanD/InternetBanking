/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

/**
 *
 * @author Diend
 * @param <ID>
 * @param <T>
 */
public interface Service<ID, T> {
    public T login(T t);
    
    public void delete(ID id);
            
    public ID register(T t);
}
