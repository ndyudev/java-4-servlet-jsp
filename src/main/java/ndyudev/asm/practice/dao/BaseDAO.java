package ndyudev.asm.practice.dao;

import java.util.List;
// Generics 
//T: Kiểu dữ liệu của Entity (Category, Product)
//ID: Kiểu dữ liệu của Khóa chính (String, Integer)
public interface BaseDAO<T, ID> {
    
    void create(T entity); 

    void update(T entity); 
    
    void delete(ID id); 
    
    List<T> findAll();
    
    T findById(ID id); 
}