package com.examen.ShoeStore.models;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Descripcion_Ventas {

	@Id
	@GeneratedValue(strategy =GenerationType.UUID)
	
	@Column(name="id_descripcion_venta", nullable=false, length = 36,columnDefinition="char(36)")
	private String id_descripcion_venta;
	
	
	@Column(name="ventas_id_venta", nullable=false, length = 2,columnDefinition="char(36)")
	private String ventas_id_venta;
	
	
	@Column(name="productos_id_producto", nullable=false, length = 11,columnDefinition="char(10)")
	private String productos_id_producto;
	
	
	@Column(name="cantidad", nullable=false, length = 20)
	private int cantidad;
	
	
	@Column(name="precio", nullable=false, length = 20)
	private String precio;
	
	
	@Column(name="descuento ", nullable=false, length = 15)
	private String descuento;
	

	@Column(name="sub_total", nullable=false, length = 13)
	private String sub_total;


	
}
