package ifrn.nc.sigai.servicoimoveis.service;

import ifrn.nc.sigai.servicoimoveis.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {

        return usuarioRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));
    }
}
