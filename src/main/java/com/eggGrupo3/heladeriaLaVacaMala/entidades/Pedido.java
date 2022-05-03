package com.eggGrupo3.heladeriaLaVacaMala.entidades;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

//@Entity
//@Data
//public class Pedido {
//    @Id
//    @GeneratedValue(generator = "uuid")
//    @GenericGenerator(name = "uuid", strategy = "uuid2")
//    private String id;
//    @OneToMany
//    private List<Helado> helados;
//    private Long precioFinal;
//}