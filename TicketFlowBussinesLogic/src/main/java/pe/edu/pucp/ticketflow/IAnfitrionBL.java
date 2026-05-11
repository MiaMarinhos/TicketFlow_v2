package pe.edu.pucp.ticketflow;

import pe.edu.pucp.ticketflow.evento.model.Evento;
import pe.edu.pucp.ticketflow.exception.BusinessLogicException;

import java.util.List;

public interface IAnfitrionBL extends IUsuarioBL{
    Evento crearEvento(Evento evento) throws BusinessLogicException;
    Evento mostrarEvento(Integer id) throws BusinessLogicException;
    Evento actualizarEvento(Evento evento, Integer id) throws BusinessLogicException;
    void eliminarEvento() throws BusinessLogicException;
    List<Evento> verTodosLosEventos() throws BusinessLogicException;
}
