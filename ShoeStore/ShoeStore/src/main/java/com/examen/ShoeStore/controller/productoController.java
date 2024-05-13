package com.examen.ShoeStore.controller;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examen.ShoeStore.interfaceService.IProductoService;
import com.examen.ShoeStore.models.Productos;



@RequestMapping("/api/v1/Producto")
@RestController
@CrossOrigin
public class productoController {
@Autowired
    
    private IProductoService productoService;
    
    @PostMapping("/")
    public ResponseEntity<Object> save(
            
            @ModelAttribute("Productos") Productos Productos
            ){
        
        productoService.save(Productos);
        return new ResponseEntity<>(Productos, HttpStatus.OK);
        
    }
    
    @GetMapping("/")
    public ResponseEntity<Object> findAll(){
        var ListaMedico = productoService.findAll();
        return new ResponseEntity<>(ListaMedico, HttpStatus.OK);
    }
    
  //filtro
  	@GetMapping("/busquedafiltro/{filtro}")
  	public ResponseEntity<Object>findFiltro(@PathVariable String filtro){
  		var ListaProducto = productoService.filtroMedico(filtro);
  		return new ResponseEntity<>(ListaProducto, HttpStatus.OK);
  	}
    
    
    @GetMapping("/{id}")
    public ResponseEntity<Object> findOne(@PathVariable("id") String id){
        var Producto = productoService.findOne(id);
        return new ResponseEntity<>(Producto, HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") String id){
        productoService.delete(id);
        return new ResponseEntity<>("Registro Eliminado", HttpStatus.OK);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable("id") String id, @ModelAttribute("Producto") Productos ProductoUpdate){
        var Producto = productoService.findOne(id).orElse(null);
        if (Producto != null) {
            Producto.setNombre_producto(ProductoUpdate.getNombre_producto());
            Producto.setDescripcion(ProductoUpdate.getDescripcion());
            Producto.setCantidad(ProductoUpdate.getCantidad());
            Producto.setPrecio(ProductoUpdate.getPrecio());
            Producto.setPorcentaje_iva(ProductoUpdate.getPorcentaje_iva());
            Producto.setPorcentaje_descuento(ProductoUpdate.getPorcentaje_descuento());
            
            productoService.save(Producto);
            return new ResponseEntity<>("Guardado", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Error: médico no encontrado", HttpStatus.BAD_REQUEST);
        }
    }
}
