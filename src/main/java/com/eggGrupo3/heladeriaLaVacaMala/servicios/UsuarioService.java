package com.eggGrupo3.heladeriaLaVacaMala.servicios;

import com.eggGrupo3.heladeriaLaVacaMala.entidades.Usuario;
import com.eggGrupo3.heladeriaLaVacaMala.repositorios.UsuarioRepository;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Service
public class UsuarioService implements UserDetailsService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public Usuario registro(Usuario usuario) throws ErrorService {
        validar(usuario);

        String encriptada = new BCryptPasswordEncoder().encode(usuario.getContrasenia());
        usuario.setContrasenia(encriptada);

        return usuarioRepository.save(usuario);
    }

    public void validar(Usuario usuario) throws ErrorService {

        if (usuario.getNombre() == null || usuario.getNombre().isEmpty())
        {
            throw new ErrorService("El nombre del Usuario no puede estar vacio");
        }

        if (usuario.getTelefono() == null)
        {
            throw new ErrorService("El telefono del Usuario no puede estar vacio");

        }
        if (usuario.getDomicilio() == null || usuario.getDomicilio().isEmpty())
        {
            throw new ErrorService("El domicilio del Usuario no puede estar vacio");
        }

        if (emailExist(usuario.getEmail()))
        {
            throw new ErrorService("El mail ya se encuentra en uso");
        }

        if (usuario.getEmail() == null || usuario.getEmail().isEmpty())
        {
            throw new ErrorService("El mail del Usuario no puede estar vacio");
        }

        if (usuario.getContrasenia() == null || usuario.getContrasenia().isEmpty() || usuario.getContrasenia().length() < 6)
        {
            throw new ErrorService("La clave no puede estar vacia o tener menos de 6 digitos");
        }

    }

    public boolean emailExist(String email) {
        return usuarioRepository.findByEmail(email) != null;
    }

    @Override
    public UserDetails loadUserByUsername(String mail) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByEmail(mail);
        if (usuario != null)
        {
            List<GrantedAuthority> permisos = new ArrayList<>();
            
            //MEJORAR FORMA PARA OTORGAR ROL DE ADMIN
            if (usuario.getEmail().equalsIgnoreCase("admin@hotmail.com"))
            {
                GrantedAuthority p1 = new SimpleGrantedAuthority("ROLE_ADMIN");
                permisos.add(p1);
            } else
            {

                GrantedAuthority p1 = new SimpleGrantedAuthority("ROLE_USUARIO_REGISTRADO");
                permisos.add(p1);
            }
            ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
            HttpSession session = attr.getRequest().getSession(true);
            session.setAttribute("usuariosession", usuario);
          
            User user = new User(usuario.getEmail(), usuario.getContrasenia(), permisos);
            
            return user;

        } else
        {
            return null;
        }
    }
}
