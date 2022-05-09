package com.eggGrupo3.heladeriaLaVacaMala.servicios;

import com.eggGrupo3.heladeriaLaVacaMala.entidades.Pedido;
import java.util.List;
import java.util.Optional;

public interface PedidoService {

    List<Pedido> findAll();

    Optional<Pedido> findById(String id);

    Pedido save(Pedido pedido);

//    String generarNumeroPedido();

}
