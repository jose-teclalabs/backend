package pe.com.yambal.base;

public interface GenericService<E> {          
    void persist(E e);
    void merge(E e);
    void remove(Object id);
    E findById(Object id);
}
