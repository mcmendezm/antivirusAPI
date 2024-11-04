package service;

import model.Antivirus;
import model.Usuario;
import repository.AntivirusRepository;
import repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service // Indica que esta clase es un servicio de Spring.
public class DataLoaderService {

    @Autowired // Inyección de dependencias para UsuarioRepository.
    private UsuarioRepository usuarioRepository;

    @Autowired // Inyección de dependencias para AntivirusRepository.
    private AntivirusRepository antivirusRepository;

    // Método para cargar datos iniciales en la base de datos.
    public void cargarDatos() {
        Usuario usuario = new Usuario();
        usuario.setNombre("Juan Pérez");
        usuario.setCorreo("juan.perez@example.com");
        usuario = usuarioRepository.save(usuario);

        Antivirus antivirus = new Antivirus();
        antivirus.setNombre("Antivirus Pro");
        antivirus.setUsuario(usuario);
        antivirusRepository.save(antivirus);

        // Puedes agregar más datos según sea necesario.
    }
}