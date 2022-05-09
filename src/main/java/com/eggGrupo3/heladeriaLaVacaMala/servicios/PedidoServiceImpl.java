package com.eggGrupo3.heladeriaLaVacaMala.servicios;

import com.eggGrupo3.heladeriaLaVacaMala.entidades.Pedido;
import com.eggGrupo3.heladeriaLaVacaMala.repositorios.PedidoRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PedidoServiceImpl implements PedidoService{
	
	@Autowired
	private PedidoRepository pedidoRepository;

	@Override
	public Pedido save(Pedido orden) {
            return pedidoRepository.save(orden);
	}

	@Override
	public List<Pedido> findAll() {
            return pedidoRepository.findAll();
	}
        
	@Override
	public Optional<Pedido> findById(String id) {
		return pedidoRepository.findById(id);
	}

}
