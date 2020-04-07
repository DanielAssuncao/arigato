package br.com.assuncao.arigato.business.service;

import java.util.List;

public interface ICrudService<T, I, F> {

    List<T> findAll(F filter);
    
    T save(T t);
    
    void delete(I i);
    
    T findOne(I i);
    
    I getIdFromInstance(T t);
}
