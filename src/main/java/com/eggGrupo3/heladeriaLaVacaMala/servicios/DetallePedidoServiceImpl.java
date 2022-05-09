package com.eggGrupo3.heladeriaLaVacaMala.servicios;

import com.eggGrupo3.heladeriaLaVacaMala.entidades.DetallePedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.eggGrupo3.heladeriaLaVacaMala.repositorios.DetallePedidoRepository;



@Service
public class DetallePedidoServiceImpl implements DetallePedidoService{
	
	@Autowired
	private DetallePedidoRepository detallePedidoRepository;

	@Override
	public DetallePedido save(DetallePedido detallePedido) {
		return detallePedidoRepository.save(detallePedido);
	}


}
