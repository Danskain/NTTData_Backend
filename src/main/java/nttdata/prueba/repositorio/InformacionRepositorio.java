package nttdata.prueba.repositorio;

import nttdata.prueba.modelo.Informacion;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface InformacionRepositorio extends JpaRepository<Informacion, Integer> {
    Optional<Informacion> findByNumeroDocumento(Integer numeroDocumento);
}
