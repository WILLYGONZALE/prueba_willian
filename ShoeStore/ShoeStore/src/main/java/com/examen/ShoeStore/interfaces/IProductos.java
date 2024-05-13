package com.examen.ShoeStore.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.examen.ShoeStore.models.Productos;


@Repository
public interface IProductos extends CrudRepository<Productos,String> {
	
   
    /*
     * Incluye las funciones básicas del CRUD
    */
}
