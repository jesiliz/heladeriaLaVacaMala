package com.eggGrupo3.heladeriaLaVacaMala.servicios;

import com.eggGrupo3.heladeriaLaVacaMala.entidades.Helado;
import com.eggGrupo3.heladeriaLaVacaMala.repositorios.HeladoRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HeladoServiceImpl implements IHeladoService {

    @Autowired
    private HeladoRepository heladoRepository;
   
    @Override
    public List<Helado> findAll() {
        return (List<Helado>) heladoRepository.findAll();
    }
    
    @Override
    public void guardar(Helado helado) {
        heladoRepository.save(helado);
    }
    
    @Override
    public Optional<Helado> get(String id) {
	return heladoRepository.findById(id);
    }

    @Override
    public Helado buscarPorId(String id) {
        return heladoRepository.findById(id).orElse(null);
    }
    
    @Override
    public void eliminar(String id) {
        heladoRepository.deleteById(id);
    }
    
}
