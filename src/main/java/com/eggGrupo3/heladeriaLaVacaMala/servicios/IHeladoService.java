package com.eggGrupo3.heladeriaLaVacaMala.servicios;

import com.eggGrupo3.heladeriaLaVacaMala.entidades.Helado;
import java.util.List;
import java.util.Optional;


public interface IHeladoService {
    
    public List<Helado>findAll();
    public void guardar(Helado helado);
    public Optional<Helado> get(String id); 
    public Helado buscarPorId(String id);
    public void eliminar(String id);
}
