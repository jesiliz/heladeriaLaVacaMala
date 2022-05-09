package com.eggGrupo3.heladeriaLaVacaMala.entidades;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Data
@Table(name="helados")
public class Helado implements Serializable{
    private static final Long serialVersionUID=1L;
    
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;;
    
    private String sabor;
    private String descripcion;
    private double precio;
    private int stock;
    private String imagen;
}
