package nttdata.prueba.dto;

import jakarta.validation.constraints.NotNull;

public class ClienteRequest {
    @NotNull(message = "El tipo de documento es obligatorio")
    private String tipoDocumento;

    @NotNull(message = "El número de documento es obligatorio")
    private Integer numeroDocumento;

    // Getters y setters
    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public Integer getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(Integer numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }
}
