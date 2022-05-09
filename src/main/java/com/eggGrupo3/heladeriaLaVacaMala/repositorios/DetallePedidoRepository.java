package com.eggGrupo3.heladeriaLaVacaMala.repositorios;

import com.eggGrupo3.heladeriaLaVacaMala.entidades.DetallePedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DetallePedidoRepository extends JpaRepository<DetallePedido, String> {

}
