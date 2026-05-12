//package pe.edu.pucp.ticketflow.impl;
//
//import pe.edu.pucp.ticketflow.*;
//import pe.edu.pucp.ticketflow.evento.model.Evento;
//import pe.edu.pucp.ticketflow.exception.BusinessLogicException;
//import pe.edu.pucp.ticketflow.usuario.model.Anfitrion;
//
//import java.util.List;
//
//public class AnfitrionBLImpl implements IAnfitrionBL {
//    private Anfitrion anfitrion;
//    private IEventoDAO eventoDAO = new EventoDAOImpl();
//    private IDistritoDAO distritoDAO = new DistritoDAOImpl();
//    private ICategoriaEventoDAO categoriaEventoDAO = new CategoriaEventoDAOImpl();
//    private IEstadoPublicacionDAO estadoPublicacionDAO = new EstadoUsuarioDAOImpl();
//    private IEstadoEventoDAO estadoEventoDAO = new EstadoEventoDAOImpl();
//
//    public AnfitrionBLImpl(Anfitrion anfitrion){
//        this.anfitrion = anfitrion;
//    }
//
//    @Override
//    public Evento crearEvento(Evento evento) throws BusinessLogicException{
//
//    }
//    @Override
//    public Evento mostrarEvento(Integer id) throws BusinessLogicException{
//
//    }
//    @Override
//    public Evento actualizarEvento(Evento evento, Integer id) throws BusinessLogicException{
//
//    }
//    @Override
//    public void eliminarEvento() throws BusinessLogicException{
//
//    }
//    @Override
//    public List<Evento> verTodosLosEventos() throws BusinessLogicException{
//
//    }
//}

package pe.edu.pucp.ticketflow.impl;

import pe.edu.pucp.ticketflow.IAnfitrionBL;
import pe.edu.pucp.ticketflow.evento.model.Evento;
import pe.edu.pucp.ticketflow.exception.BusinessLogicException;
import pe.edu.pucp.ticketflow.usuario.model.Anfitrion;
import pe.edu.pucp.ticketflow.usuario.model.Cliente;
import pe.edu.pucp.ticketflow.usuario.model.Usuario;

import java.util.ArrayList;
import java.util.List;

public class AnfitrionBLImpl implements IAnfitrionBL {

    private Anfitrion anfitrion;

    public AnfitrionBLImpl() {
    }

    public AnfitrionBLImpl(Anfitrion anfitrion) {
        this.anfitrion = anfitrion;
    }

    // Implementación temporal para permitir la compilación.
    // La lógica real de usuario/anfitrión será completada después.

    @Override
    public Usuario registrarUsuario(Usuario usuario) throws BusinessLogicException {
        return usuario;
    }

    @Override
    public Cliente registrarCliente(Cliente cliente) throws BusinessLogicException {
        return cliente;
    }

    @Override
    public Anfitrion registrarAnfitrion(Anfitrion anfitrion) throws BusinessLogicException {
        return anfitrion;
    }


}
