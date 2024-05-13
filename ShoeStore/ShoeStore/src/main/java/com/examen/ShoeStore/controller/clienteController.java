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

import com.examen.ShoeStore.interfaceService.IClienteService;
import com.examen.ShoeStore.models.Cliente;



@RequestMapping("/api/v1/Cliente")
@RestController
@CrossOrigin
public class clienteController {
@Autowired
    
    private IClienteService clienteService;
    
    @PostMapping("/")
    public ResponseEntity<Object> save(
            
            @ModelAttribute("Cliente") Cliente Cliente
            ){
        
        clienteService.save(Cliente);
        return new ResponseEntity<>(Cliente, HttpStatus.OK);
        
    }
    
    @GetMapping("/")
    public ResponseEntity<Object> findAll(){
        var ListaCliente = clienteService.findAll();
        return new ResponseEntity<>(ListaCliente, HttpStatus.OK);
    }
    
  //filtro
  	@GetMapping("/busquedafiltro/{filtro}")
  	public ResponseEntity<Object>findFiltro(@PathVariable String filtro){
  		var ListaCliente = clienteService.filtroMedico(filtro);
  		return new ResponseEntity<>(ListaCliente, HttpStatus.OK);
  	}
    
    
    @GetMapping("/{id}")
    public ResponseEntity<Object> findOne(@PathVariable("id") String id){
        var Cliente = clienteService.findOne(id);
        return new ResponseEntity<>(Cliente, HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") String id){
        clienteService.delete(id);
        return new ResponseEntity<>("Registro Eliminado", HttpStatus.OK);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable("id") String id, @ModelAttribute("Cliente") Cliente clienteUpdate)
    {
        var Cliente = clienteService.findOne(id).orElse(null);
        if (Cliente != null) {
            Cliente.setTipo_de_identificacion(clienteUpdate.getTipo_de_identificacion());
            Cliente.setNumero_documento(clienteUpdate.getNumero_documento());
            Cliente.setNombre(clienteUpdate.getNombre());
            Cliente.setApellido(clienteUpdate.getApellido());
            Cliente.setTelefono(clienteUpdate.getTelefono());
            Cliente.setDireccion(clienteUpdate.getDireccion());
            Cliente.setCiudad(clienteUpdate.getCiudad());
            Cliente.setEstado(clienteUpdate.getEstado());
            
            clienteService.save(Cliente);
            return new ResponseEntity<>("Guardado", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Error: médico no encontrado", HttpStatus.BAD_REQUEST);
        }
    }
}
