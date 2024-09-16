package nttdata.prueba.servicio;

import nttdata.prueba.modelo.Informacion;

import java.util.List;

public interface IInformacionServicio {
    public List<Informacion> listarInformacionCiente();
    public Informacion listarInformacionClienteNumeroCliente(Integer numeroDocumento);
}
