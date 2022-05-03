package com.eggGrupo3.heladeriaLaVacaMala.repositorios;

import com.eggGrupo3.heladeriaLaVacaMala.entidades.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente,Long>{
    
}
