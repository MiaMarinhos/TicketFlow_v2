package pe.edu.pucp.ticketflow.impl;

import pe.edu.pucp.ticketflow.IAnfitrionBL;
import pe.edu.pucp.ticketflow.evento.model.Evento;
import pe.edu.pucp.ticketflow.compra.model.Compra;
import pe.edu.pucp.ticketflow.pago.model.Pago;
import pe.edu.pucp.ticketflow.exception.BusinessLogicException;
import pe.edu.pucp.ticketflow.usuario.model.Anfitrion;

import java.util.List;

public class AnfitrionBLImpl extends UsuarioBLImpl implements IAnfitrionBL {

    private final AnfitrionDAOImpl anfitrionDAO;
    private final EventoDAOImpl eventoDAO;

    private final CompraDAOImpl compraDAO;
    private final PagosDAOImpl pagoDAO;

    public AnfitrionBLImpl() {
        this.anfitrionDAO = new AnfitrionDAOImpl();
        this.eventoDAO = new EventoDAOImpl();
        this.compraDAO = new CompraDAOImpl();
        this.pagoDAO = new PagosDAOImpl();
    }

    @Override
    public Anfitrion registrarAnfitrion(Anfitrion anfitrion) throws BusinessLogicException {
        try {
            if (anfitrion == null) {
                throw new BusinessLogicException("El anfitrión no puede ser nulo.");
            }

            if (anfitrion.getIdUsuario() <= 0) {
                throw new BusinessLogicException("Primero debe crearse el usuario antes de registrar el anfitrión.");
            }

            if (anfitrion.getBanco() == null || anfitrion.getBanco().getId() <= 0) {
                throw new BusinessLogicException("El anfitrión debe tener un banco válido.");
            }

            if (anfitrion.getRazonSocial() == null || anfitrion.getRazonSocial().isBlank()) {
                throw new BusinessLogicException("La razón social del anfitrión es obligatoria.");
            }

            if (anfitrion.getRuc() == null || anfitrion.getRuc().isBlank()) {
                throw new BusinessLogicException("El RUC del anfitrión es obligatorio.");
            }

            if (anfitrion.getCuentaBancaria() == null || anfitrion.getCuentaBancaria().isBlank()) {
                throw new BusinessLogicException("La cuenta bancaria del anfitrión es obligatoria.");
            }

            return anfitrionDAO.create(anfitrion);

        } catch (BusinessLogicException e) {
            throw e;
        } catch (Exception e) {
            throw new BusinessLogicException("Error al registrar anfitrión: " + e.getMessage());
        }
    }

    @Override
    public Anfitrion buscarAnfitrionPorId(Integer idAnfitrion) throws BusinessLogicException {
        try {
            if (idAnfitrion == null || idAnfitrion <= 0) {
                throw new BusinessLogicException("El ID del anfitrión debe ser válido.");
            }

            Anfitrion anfitrion = anfitrionDAO.read(idAnfitrion);

            if (anfitrion == null) {
                throw new BusinessLogicException("No se encontró un anfitrión con ID: " + idAnfitrion);
            }

            return anfitrion;

        } catch (BusinessLogicException e) {
            throw e;
        } catch (Exception e) {
            throw new BusinessLogicException("Error al buscar anfitrión: " + e.getMessage());
        }
    }

    @Override
    public Anfitrion actualizarAnfitrion(Anfitrion anfitrion, Integer idAnfitrion) throws BusinessLogicException {
        try {
            if (anfitrion == null) {
                throw new BusinessLogicException("El anfitrión no puede ser nulo.");
            }

            if (idAnfitrion == null || idAnfitrion <= 0) {
                throw new BusinessLogicException("El ID del anfitrión debe ser válido.");
            }

            if (anfitrion.getBanco() == null || anfitrion.getBanco().getId() <= 0) {
                throw new BusinessLogicException("El anfitrión debe tener un banco válido.");
            }

            return anfitrionDAO.update(anfitrion, idAnfitrion);

        } catch (BusinessLogicException e) {
            throw e;
        } catch (Exception e) {
            throw new BusinessLogicException("Error al actualizar anfitrión: " + e.getMessage());
        }
    }

    @Override
    public void eliminarAnfitrion(Integer idAnfitrion) throws BusinessLogicException {
        try {
            if (idAnfitrion == null || idAnfitrion <= 0) {
                throw new BusinessLogicException("El ID del anfitrión debe ser válido.");
            }

            anfitrionDAO.delete(idAnfitrion);

        } catch (BusinessLogicException e) {
            throw e;
        } catch (Exception e) {
            throw new BusinessLogicException("Error al eliminar anfitrión: " + e.getMessage());
        }
    }

    @Override
    public List<Anfitrion> listarAnfitriones() throws BusinessLogicException {
        try {
            return anfitrionDAO.listAll();
        } catch (Exception e) {
            throw new BusinessLogicException("Error al listar anfitriones: " + e.getMessage());
        }
    }

    @Override
    public Evento crearEvento(Evento evento) throws BusinessLogicException {
        try {
            if (evento == null) {
                throw new BusinessLogicException("El evento no puede ser nulo.");
            }

            if (evento.getIdAnfitrion() <= 0) {
                throw new BusinessLogicException("El evento debe estar asociado a un anfitrión válido.");
            }

            return eventoDAO.create(evento);

        } catch (BusinessLogicException e) {
            throw e;
        } catch (Exception e) {
            throw new BusinessLogicException("Error al crear evento del anfitrión: " + e.getMessage());
        }
    }

    @Override
    public Evento mostrarEvento(Integer idEvento) throws BusinessLogicException {
        try {
            if (idEvento == null || idEvento <= 0) {
                throw new BusinessLogicException("El ID del evento debe ser válido.");
            }

            Evento evento = eventoDAO.read(idEvento);

            if (evento == null) {
                throw new BusinessLogicException("No se encontró un evento con ID: " + idEvento);
            }

            return evento;

        } catch (BusinessLogicException e) {
            throw e;
        } catch (Exception e) {
            throw new BusinessLogicException("Error al mostrar evento: " + e.getMessage());
        }
    }

    @Override
    public Evento actualizarEvento(Evento evento, Integer idEvento) throws BusinessLogicException {
        try {
            if (evento == null) {
                throw new BusinessLogicException("El evento no puede ser nulo.");
            }

            if (idEvento == null || idEvento <= 0) {
                throw new BusinessLogicException("El ID del evento debe ser válido.");
            }

            return eventoDAO.update(evento, idEvento);

        } catch (BusinessLogicException e) {
            throw e;
        } catch (Exception e) {
            throw new BusinessLogicException("Error al actualizar evento: " + e.getMessage());
        }
    }

    @Override
    public void eliminarEvento(Integer idEvento) throws BusinessLogicException {
        try {
            if (idEvento == null || idEvento <= 0) {
                throw new BusinessLogicException("El ID del evento debe ser válido.");
            }

            eventoDAO.delete(idEvento);

        } catch (BusinessLogicException e) {
            throw e;
        } catch (Exception e) {
            throw new BusinessLogicException("Error al eliminar evento: " + e.getMessage());
        }
    }

    @Override
    public List<Evento> verTodosLosEventos() throws BusinessLogicException {
        try {
            return eventoDAO.listAll();
        } catch (Exception e) {
            throw new BusinessLogicException("Error al listar eventos: " + e.getMessage());
        }
    }

    @Override
    public void editarPerfilAnfitrion() throws BusinessLogicException {
        System.out.println("Anfitrión está editando su perfil.");
    }

    @Override
    public List<Compra> verComprasDeSusEventos(Integer idAnfitrion) throws BusinessLogicException {
        try {
            if (idAnfitrion == null || idAnfitrion <= 0) {
                throw new BusinessLogicException("El ID del anfitrión debe ser válido.");
            }
            // Aquí llamas al DAO que a su vez ejecutará el CallableStatement (Procedure con el JOIN)
            return compraDAO.listarComprasPorAnfitrion(idAnfitrion);
        } catch (Exception e) {
            throw new BusinessLogicException("Error al visualizar las compras: " + e.getMessage());
        }
    }

    @Override
    public List<Pago> verPagosDeSusEventos(Integer idAnfitrion) throws BusinessLogicException {
        try {
            if (idAnfitrion == null || idAnfitrion <= 0) {
                throw new BusinessLogicException("El ID del anfitrión debe ser válido.");
            }
            // Llamas al DAO correspondiente
            return pagoDAO.listarPagosPorAnfitrion(idAnfitrion);
        } catch (Exception e) {
            throw new BusinessLogicException("Error al visualizar los pagos: " + e.getMessage());
        }
    }

    @Override
    public void salirModoAnfitrion() throws BusinessLogicException {
        System.out.println("Anfitrión salió del modo anfitrión.");
    }

    // ESTOS 4 SON DE USUARIO
    @Override
    public void editarPerfil() throws BusinessLogicException {
        System.out.println("Usuario está editando su perfil.");
    }

    @Override
    public void buscarEventos() throws BusinessLogicException {
        System.out.println("Usuario está buscando eventos.");
    }

    @Override
    public void enviarSolicitud() throws BusinessLogicException {
        System.out.println("Usuario está enviando una solicitud.");
    }

}