package com.lautaro.springexample.services;

import java.util.List;

public interface CrudService <T,ID> {

    List<T> findAll();

    T findByID(ID id);

    T save(T object);

    T update(T object);

    void deleteById();

    List<T> getAll();

}
