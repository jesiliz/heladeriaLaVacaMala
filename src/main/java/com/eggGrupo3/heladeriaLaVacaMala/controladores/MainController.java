package com.eggGrupo3.heladeriaLaVacaMala.controladores;

import com.eggGrupo3.heladeriaLaVacaMala.entidades.DetallePedido;
import com.eggGrupo3.heladeriaLaVacaMala.entidades.Helado;
import com.eggGrupo3.heladeriaLaVacaMala.entidades.Pedido;

import com.eggGrupo3.heladeriaLaVacaMala.servicios.HeladoService;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequestMapping("/")
public class MainController {


    @Autowired
    private HeladoService heladoService;

    List<DetallePedido> detalles = new ArrayList<DetallePedido>();
    Pedido pedido = new Pedido();

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("helados", heladoService.findAll());
        return "usuario/index";
    }

    @GetMapping("heladopedido/{id}")
    public String heladoPedido(@PathVariable String id, Model model) {

        Helado helado = new Helado();
        Optional<Helado> heladoOptional = heladoService.get(id);
        helado = heladoOptional.get();

        model.addAttribute("helado", helado);

        return "usuario/heladopedido";
    }

    @PostMapping("/cart")
    public String addCarrito(@RequestParam String id, @RequestParam Integer cantidad, Model model) {
        DetallePedido detallePedido = new DetallePedido();
        Helado helado = new Helado();
        double sumaTotal = 0;

        Optional<Helado> optionalHelado = heladoService.get(id);

        helado = optionalHelado.get();

        detallePedido.setCantidad(cantidad);
        detallePedido.setPrecio(helado.getPrecio());
        detallePedido.setSabor(helado.getSabor());
        detallePedido.setTotal(helado.getPrecio() * cantidad);
        detallePedido.setHelado(helado);

        //valido que el helado no se agregue 2 veces
        String idHelado = helado.getId();
        boolean ingresado = detalles.stream().anyMatch(p -> (p.getHelado().getId() == null ? idHelado == null :
                p.getHelado().getId().equals(idHelado)));

        if (!ingresado) {
            detalles.add(detallePedido);
        }

        sumaTotal = detalles.stream().mapToDouble(dt -> dt.getTotal()).sum();

        pedido.setTotal(sumaTotal);
        model.addAttribute("cart", detalles);
        model.addAttribute("pedido", pedido);

        return "usuario/carrito";
    }

    
    @GetMapping("/delete/cart/{id}")// quitar un helado del carrito
    public String deleteHeladoCarrito(@PathVariable String id, Model model) {
        // lista nueva de pedidos
        List<DetallePedido> pedidoNuevo = new ArrayList<DetallePedido>();

        for(DetallePedido detallePedido: detalles){
            if(detallePedido.getHelado().getId() == null ? id != null : !detallePedido.getHelado().getId().equals(id)){
                pedidoNuevo.add(detallePedido);
            }
        }
        
        // poner la nueva lista con los helados restantes
        detalles = pedidoNuevo;

        double sumaTotal = 0;//calcular de nuevo el total
        sumaTotal = detalles.stream().mapToDouble(dt -> dt.getTotal()).sum();

        pedido.setTotal(sumaTotal);
        model.addAttribute("cart", detalles);
        model.addAttribute("pedido", pedido);

        return "usuario/carrito";
    }

    @GetMapping("/order")
    public String pedido(Model model) {

        model.addAttribute("cart", detalles);
        model.addAttribute("pedido", pedido);
        return "usuario/resumenpedido";
    }

}
