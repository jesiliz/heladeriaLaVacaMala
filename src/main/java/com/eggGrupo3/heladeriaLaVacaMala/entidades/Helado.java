package com.eggGrupo3.heladeriaLaVacaMala.entidades;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="helados")
public class Helado implements Serializable{
    private static final Long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    private String sabor;
    
    private double precio;
    
    private int stock;
    
    private String imagen;
}
