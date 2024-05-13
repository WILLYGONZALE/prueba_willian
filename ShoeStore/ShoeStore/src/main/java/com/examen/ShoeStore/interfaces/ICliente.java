package com.examen.ShoeStore.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.examen.ShoeStore.models.Cliente;



@Repository
public interface ICliente extends CrudRepository<Cliente,String> {
	
	
   
    /*
     * Incluye las funciones básicas del CRUD
    */
}
