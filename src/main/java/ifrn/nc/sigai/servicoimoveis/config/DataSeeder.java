package ifrn.nc.sigai.servicoimoveis.config;

import ifrn.nc.sigai.servicoimoveis.model.Role;
import ifrn.nc.sigai.servicoimoveis.model.Usuario;
import ifrn.nc.sigai.servicoimoveis.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataSeeder implements CommandLineRunner {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) {
        if (usuarioRepository.count() > 0) {
            return; // se já tem usuário, não duplica
        }

        Usuario admin = new Usuario();
        admin.setUsername("admin");
        admin.setPassword(passwordEncoder.encode("admin123"));
        admin.setRole(Role.ADMIN);
        usuarioRepository.save(admin);

        Usuario corretor = new Usuario();
        corretor.setUsername("corretor");
        corretor.setPassword(passwordEncoder.encode("corretor123"));
        corretor.setRole(Role.CORRETOR);
        usuarioRepository.save(corretor);

        Usuario cliente = new Usuario();
        cliente.setUsername("cliente");
        cliente.setPassword(passwordEncoder.encode("cliente123"));
        cliente.setRole(Role.CLIENTE);
        usuarioRepository.save(cliente);

        System.out.println(">>> Usuários de teste criados: admin/admin123, corretor/corretor123, cliente/cliente123");
    }
}
