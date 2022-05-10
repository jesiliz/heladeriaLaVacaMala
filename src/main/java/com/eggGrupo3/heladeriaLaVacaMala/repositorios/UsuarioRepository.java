package com.eggGrupo3.heladeriaLaVacaMala.repositorios;

import com.eggGrupo3.heladeriaLaVacaMala.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String> {

    Usuario findByEmail(String email);
}
