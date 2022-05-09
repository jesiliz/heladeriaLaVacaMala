package com.eggGrupo3.heladeriaLaVacaMala.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Data
@Table(name = "detalles")
public class DetallePedido {
	@Id
        @GeneratedValue(generator = "uuid")
        @GenericGenerator(name = "uuid", strategy = "uuid2")
	private String id;
	private String sabor;
	private double cantidad;
	private double precio;
	private double total;
	
	@ManyToOne
	private Pedido pedido;
	
	@ManyToOne
	private Helado helado;
	
}
