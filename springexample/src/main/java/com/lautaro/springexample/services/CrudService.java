package com.lautaro.springexample.services;

import java.util.List;

public interface CrudService <T,ID> {

    List<T> findAll();

    List<T> findActives();

    T findById(ID id);

    T getById(ID id);

    T create(T object);

    T update(ID id,T object);

    void deleteById(ID id);

}
