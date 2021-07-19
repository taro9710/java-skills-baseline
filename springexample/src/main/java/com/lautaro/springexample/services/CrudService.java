package com.lautaro.springexample.services;

import java.util.List;

public interface CrudService <T,ID> {

    List<T> findAll();

    List<T> findActives();

    T findByID(ID id);

    T create(T object);

    T update(T object);

    void deleteById(ID id);

}
