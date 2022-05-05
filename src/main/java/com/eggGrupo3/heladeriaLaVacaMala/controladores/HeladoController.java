package com.eggGrupo3.heladeriaLaVacaMala.controladores;

import com.eggGrupo3.heladeriaLaVacaMala.entidades.Helado;
import com.eggGrupo3.heladeriaLaVacaMala.servicios.IHeladoService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/views/helados")
public class HeladoController {
    
    @Autowired
    private IHeladoService heladoService;
    
    @GetMapping("/")
    public String listarHelados(Model model){
        List<Helado> listadoHelados = heladoService.findAll();
        
        model.addAttribute("titulo", "Lista de sabores");
        model.addAttribute("helados", listadoHelados);
        
        return "/views/helados/listar";
    }
    
    @GetMapping("/create")
    public String crear(Model model){
        Helado helado = new Helado();
        
        model.addAttribute("titulo","Nuevo Sabor");
        model.addAttribute("helado", helado);
        return "/views/helados/frmCrear";
    }
    
    @PostMapping("/save")
    public String guardar(@ModelAttribute Helado helado,@RequestParam("file") MultipartFile imagen ,RedirectAttributes attribute){
        
        if(!imagen.isEmpty()){
            Path directorioImagen = Paths.get("src//main//resources//static/img");
            String rutaAbsoluta = directorioImagen.toFile().getAbsolutePath();
            
            try {
                byte[] bytesImg= imagen.getBytes();
                Path rutaCompleta = Paths.get(rutaAbsoluta + "//" + imagen.getOriginalFilename());
                Files.write(rutaCompleta, bytesImg);
                
                helado.setImagen(imagen.getOriginalFilename());
                
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
        heladoService.guardar(helado);
        attribute.addFlashAttribute("success", "Se ha registrado con exito!");
        return "redirect:/views/helados/";
        
    }
    
    @GetMapping("/detalle/{id}")
    public String detalleHelado(@PathVariable("id") String idHelado, Model model, RedirectAttributes attribute){
        Helado helado = heladoService.buscarPorId(idHelado);
        
        model.addAttribute("titulo","Detalle ");
        model.addAttribute("helado", helado);
        
        return "/views/helados/detalleHelado";
    }
    
    @GetMapping("/edit/{id}")
    public String editar(@PathVariable("id") String idHelado, Model model, RedirectAttributes attribute){
        Helado helado = heladoService.buscarPorId(idHelado);
        
        model.addAttribute("titulo","Editar Sabor");
        model.addAttribute("helado", helado);
        attribute.addFlashAttribute("success", "Se ha editado con exito!");
        return "/views/helados/frmCrear";
    }
    
    @GetMapping("/delete/{id}")
    public String eliminar(@PathVariable("id") String idHelado, RedirectAttributes attribute){
     
        heladoService.eliminar(idHelado);
        attribute.addFlashAttribute("success", "Registro eliminado con exito!");
        return "redirect:/views/helados/";
    }
    
    
    
}
