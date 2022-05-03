package com.eggGrupo3.heladeriaLaVacaMala.servicios;

import com.eggGrupo3.heladeriaLaVacaMala.entidades.Helado;
import java.util.List;


public interface IHeladoService {
    
    public List<Helado>findAll();
    public void guardar(Helado helado);
    public Helado buscarPorId(Long id);
    public void eliminar(Long id);
}
