package com.examen.ShoeStore.models;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Ventas {
	@Id
	@GeneratedValue(strategy =GenerationType.UUID)
	
	@Column(name="id_venta", nullable=false, length = 36,columnDefinition="char(36)")
	private String id_venta;
	
	
	@Column(name="cliente_id_cliente", nullable=false, length = 2,columnDefinition="char(36)")
	private String ventas_id_venta;
	
	
	@Column(name="total", nullable=false, length = 11)
	private String total;
	
	@Enumerated(EnumType.STRING)
	@Column(name="estado", nullable=false, length = 20)
	private String estado;
	
	
	
	@Column(name="fecha_venta", nullable=false, length = 20)
	private String fecha_venta;
	
	
	public enum estado {
		ACTIVADO,
		DESACTIVADO
	}
}
