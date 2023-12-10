package rikkei.academy.model.service;

import java.util.List;

public interface IGenericService<T,ID> {
    List<T > findAll();
    Boolean saveOrUpdate(T t);
    void delete(ID id);
}
