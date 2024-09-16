package nttdata.prueba.controlador;

import jakarta.validation.Valid;
import nttdata.prueba.dto.ApiResponse;
import nttdata.prueba.dto.ClienteRequest;
import nttdata.prueba.modelo.Informacion;
import nttdata.prueba.servicio.InformacionServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//http://localhost:8080/informacion-app
@RequestMapping("informacion-app")
@CrossOrigin(value = "http://localhost:4200")
public class InformacionControlador {
    private static final Logger logger = LoggerFactory.getLogger(InformacionControlador.class);

    @Autowired
    private InformacionServicio informacionServicio;

    //http://locahost:8080/inventario-app/productos
    @GetMapping("/informacion")
    public List<Informacion> obtenerInformacion(){
        List<Informacion> productos = this.informacionServicio.listarInformacionCiente();
        logger.info("Productos obtenidos:");
        productos.forEach((producto -> logger.info(producto.toString())));
        return productos;
    }

    @GetMapping("/informacion/{numeroDocumento}")
    public ResponseEntity<Informacion> obetenerInformacionPorNumeroCedula(
            @PathVariable int numeroDocumento
    ){
        Informacion informacion = this.informacionServicio.listarInformacionClienteNumeroCliente(numeroDocumento);
        return ResponseEntity.ok(informacion);
    }

    @PostMapping("/buscarCliente")
    public ResponseEntity<ApiResponse<Informacion>> buscarCliente(@Valid @RequestBody ClienteRequest request) {
        Informacion informacion = informacionServicio.listarInformacionClienteNumeroCliente(request.getNumeroDocumento());
        if (informacion != null) {
            ApiResponse<Informacion> response = new ApiResponse<>("ok", HttpStatus.OK.value(), "Datos encontrados", informacion);
            return ResponseEntity.ok(response);
        } else {
            ApiResponse<Informacion> response = new ApiResponse<>("error", HttpStatus.NOT_FOUND.value(), "Datos no encontrados", null);
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }
}
