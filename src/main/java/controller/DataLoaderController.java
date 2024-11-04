package controller;

import service.DataLoaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // Indica que esta clase es un controlador REST.
@RequestMapping("/api/datos") // Define la ruta base para este controlador.
public class DataLoaderController {

    @Autowired // Inyección del servicio DataLoaderService.
    private DataLoaderService dataLoaderService;

    @PostMapping("/cargar") // Define el endpoint para cargar datos.
    public ResponseEntity<String> cargarDatos() {
        dataLoaderService.cargarDatos(); // Llama al método para cargar datos.
        return ResponseEntity.ok("Datos cargados exitosamente"); // Respuesta exitosa.
    }
}