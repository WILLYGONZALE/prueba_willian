package com.examen.ShoeStore.models;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Productos {
	@Id
	@GeneratedValue(strategy =GenerationType.UUID)
	
	@Column(name="id_producto", nullable=false, length = 36,columnDefinition="char(36)")
	private String id_producto;
	
	
	@Column(name="nombre_producto", nullable=false, length = 2)
	private String ventas_id_venta;
	
	
	@Column(name="descripcion", nullable=false, length = 11)
	private String descripcion;
	
	
	@Column(name="cantidad", nullable=false, length = 20)
	private int cantidad;
	
	
	
	@Column(name="precio", nullable=false, length = 20)
	private String precio;
	
	
	@Column(name="porcentaje_iva", nullable=false, length = 15)
	private int porcentaje_iva;
	

	@Column(name="porcentaje_descuento", nullable=false, length = 13)
	private int porcentaje_descuento;
	
	@Enumerated(EnumType.STRING)
	@Column(name="estado", nullable=false, length = 13)
	private String estado;
	
	
	public enum estado {
		ACTIVADO,
		DESACTIVADO
	}
}
