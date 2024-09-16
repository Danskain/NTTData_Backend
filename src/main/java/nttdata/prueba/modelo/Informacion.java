package nttdata.prueba.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Informacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idInformacion;
    String tipoDocumento;
    Integer numeroDocumento;
    String primerNombre;
    String segundoNombre;
    String primerApellido;
    String segundoApellido;
    Integer telefono;
    String direccion;
    String ciudad;
}
