package rikkei.academy.model.repository;


import java.util.List;

public interface IGenericRepository<T,ID>{
    List<T > findAll();
    Boolean saveOrUpdate(T t);
    void delete(ID id);
}
