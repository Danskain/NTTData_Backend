package nttdata.prueba.servicio;

import nttdata.prueba.modelo.Informacion;
import nttdata.prueba.repositorio.InformacionRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InformacionServicio implements IInformacionServicio{

    @Autowired
    private InformacionRepositorio informacionRepositorio;

    @Override
    public List<Informacion> listarInformacionCiente() {
        return this.informacionRepositorio.findAll();
    }

    @Override
    public Informacion     listarInformacionClienteNumeroCliente(Integer numeroDocumento) {
        Informacion informacion = this.informacionRepositorio.findByNumeroDocumento(numeroDocumento).orElse(null);
        return informacion;
    }
}
