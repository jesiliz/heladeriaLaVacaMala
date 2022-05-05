package com.eggGrupo3.heladeriaLaVacaMala.repositorios;

import com.eggGrupo3.heladeriaLaVacaMala.entidades.Helado;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeladoRepository extends CrudRepository<Helado, String>{
    
}
