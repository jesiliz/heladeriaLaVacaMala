package com.eggGrupo3.heladeriaLaVacaMala.repositorios;

import com.eggGrupo3.heladeriaLaVacaMala.entidades.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, String>{
    
}
