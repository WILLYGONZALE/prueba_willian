package com.examen.ShoeStore.models;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity

public class Cliente {

	/*
	@Entity, es una anotacion bean que indica el nombre de la entidad en la base de datos*/
	 
		/*
		 id
		 tipo_documento
		 numero_documento
		 primer_nombre
		 segundo_nombre
		 primer_apellido
		 segundo_apellido
		 telefono
		 correo
		 dirreccion*/
		//UUID 
		
		
		@Id
		@GeneratedValue(strategy =GenerationType.UUID)
		
		@Column(name="id_Cliente", nullable=false, length = 36,columnDefinition="char(36)")
		private String id_Cliente;
		
		@Enumerated(EnumType.STRING)
		@Column(name="tipo_de_identificacion", nullable=false, length = 2)
		private String tipo_de_identificacion;
		
		
		@Column(name="numero_documento", nullable=false, length = 11)
		private String numero_documento;
		
		
		@Column(name="nombre", nullable=false, length = 20)
		private String nombre;
		
		
		
		@Column(name="apellido", nullable=false, length = 20)
		private String apellido;
		
		
		@Column(name="telefono", nullable=false, length = 15)
		private String telefono;
		
		@Enumerated(EnumType.STRING)
		@Column(name="estado", nullable=false, length = 13)
		private String estado;
 
		@Column(name="direccion", nullable=false, length = 13)
		private String direccion;

		@Column(name="ciudad", nullable=false, length = 13)
		private String ciudad;

		
		//falta crear el metodo constructor sin parametros,con parametros y
		//GET AND SET

public enum tipo_de_identificacion {
	CC,
	CE
}
		
public enum estado {
	ACTIVADO,
	DESACTIVADO
}
		


}
