package com.eggGrupo3.heladeriaLaVacaMala.entidades;

import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Data
public class Pedido {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    private String numero;
    private Date fechaCreacion;
    private Date fechaRecibida;
    private double total;
    
//    @ManyToOne
//    private Usuario usuario;
	
    @OneToMany(mappedBy = "pedido")
    private List<DetallePedido> detalle;
}