package pe.edu.pucp.ticketflow.impl;

import pe.edu.pucp.ticketflow.IAdministradorBL;
import pe.edu.pucp.ticketflow.IAdministradorDAO;
import pe.edu.pucp.ticketflow.administrador.model.Administrador;
import pe.edu.pucp.ticketflow.exception.BusinessLogicException;

import java.util.List;

public class AdministradorBLImpl implements IAdministradorBL {

    private final IAdministradorDAO administradorDAO;

    public AdministradorBLImpl() {
        this.administradorDAO = new AdministradorDAOImpl();
    }

    @Override
    public Administrador registrarAdministrador(Administrador administrador) throws BusinessLogicException {
        try {
            validarAdministrador(administrador);
            return administradorDAO.create(administrador);
        } catch (Exception ex) {
            if (ex instanceof BusinessLogicException) {
                throw (BusinessLogicException) ex;
            }
            throw new BusinessLogicException(ex);
        }
    }

    @Override
    public Administrador buscarAdministradorPorId(Integer id) throws BusinessLogicException {
        try {
            validarId(id);

            Administrador administrador = administradorDAO.read(id);

            if (administrador == null) {
                throw new BusinessLogicException("No existe un administrador con el ID indicado.");
            }

            return administrador;

        } catch (Exception ex) {
            if (ex instanceof BusinessLogicException) {
                throw (BusinessLogicException) ex;
            }
            throw new BusinessLogicException(ex);
        }
    }

    @Override
    public Administrador actualizarAdministrador(Administrador administrador, Integer id) throws BusinessLogicException {
        try {
            validarId(id);
            validarAdministrador(administrador);

            Administrador administradorExistente = administradorDAO.read(id);

            if (administradorExistente == null) {
                throw new BusinessLogicException("No se puede actualizar. El administrador no existe.");
            }

            return administradorDAO.update(administrador, id);

        } catch (Exception ex) {
            if (ex instanceof BusinessLogicException) {
                throw (BusinessLogicException) ex;
            }
            throw new BusinessLogicException(ex);
        }
    }

    @Override
    public void eliminarAdministrador(Integer id) throws BusinessLogicException {
        try {
            validarId(id);

            Administrador administradorExistente = administradorDAO.read(id);

            if (administradorExistente == null) {
                throw new BusinessLogicException("No se puede eliminar. El administrador no existe.");
            }

            administradorDAO.delete(id);

        } catch (Exception ex) {
            if (ex instanceof BusinessLogicException) {
                throw (BusinessLogicException) ex;
            }
            throw new BusinessLogicException(ex);
        }
    }

    @Override
    public List<Administrador> listarAdministradores() throws BusinessLogicException {
        try {
            return administradorDAO.listAll();
        } catch (Exception ex) {
            throw new BusinessLogicException(ex);
        }
    }

    @Override
    public void verSolicitudes() throws BusinessLogicException {
        // Pendiente: aquí se usará SolicitudDAO cuando esa capa esté completa.
        System.out.println("Mostrando solicitudes pendientes...");
    }

    @Override
    public void responderSolicitudes() throws BusinessLogicException {
        // Pendiente: aquí se usará SolicitudDAO para aprobar/rechazar solicitudes.
        System.out.println("Respondiendo solicitudes...");
    }

    @Override
    public void editarCuentasDeUsuarios() throws BusinessLogicException {
        // Pendiente: aquí se usará UsuarioDAO/ClienteDAO/AnfitrionDAO.
        System.out.println("Editando cuentas de usuarios...");
    }

    @Override
    public void generarReporte() throws BusinessLogicException {
        // Pendiente: aquí se podrían consultar ventas, pagos, eventos, etc.
        System.out.println("Generando reporte...");
    }

    @Override
    public void listarUsuarios() throws BusinessLogicException {
        // Pendiente: aquí se usará UsuarioDAO.
        System.out.println("Listando usuarios...");
    }

    @Override
    public void listarEventos() throws BusinessLogicException {
        // Pendiente: aquí se usará EventoDAO.
        System.out.println("Listando eventos...");
    }

    @Override
    public void publicarEvento() throws BusinessLogicException {
        // Pendiente: aquí se usará EventoDAO o EstadoPublicacionDAO.
        System.out.println("Publicando evento...");
    }

    private void validarAdministrador(Administrador administrador) throws BusinessLogicException {
        if (administrador == null) {
            throw new BusinessLogicException("El administrador no puede ser nulo.");
        }

        if (administrador.getIdAdministrador() <= 0) {
            throw new BusinessLogicException("El ID del administrador debe ser mayor a 0.");
        }

        if (administrador.getCodigo() == null || administrador.getCodigo().trim().isEmpty()) {
            throw new BusinessLogicException("El código del administrador es obligatorio.");
        }

        if (administrador.getNombre() == null || administrador.getNombre().trim().isEmpty()) {
            throw new BusinessLogicException("El nombre del administrador es obligatorio.");
        }

        if (administrador.getApellidoPaterno() == null || administrador.getApellidoPaterno().trim().isEmpty()) {
            throw new BusinessLogicException("El apellido paterno del administrador es obligatorio.");
        }

        if (administrador.getApellidoMaterno() == null || administrador.getApellidoMaterno().trim().isEmpty()) {
            throw new BusinessLogicException("El apellido materno del administrador es obligatorio.");
        }

        if (administrador.getDni() == null || administrador.getDni().trim().isEmpty()) {
            throw new BusinessLogicException("El DNI del administrador es obligatorio.");
        }

        if (administrador.getContrasena() == null || administrador.getContrasena().trim().isEmpty()) {
            throw new BusinessLogicException("La contraseña del administrador es obligatoria.");
        }

        if (administrador.getCodigo().length() > 45 ||
                administrador.getNombre().length() > 45 ||
                administrador.getApellidoPaterno().length() > 45 ||
                administrador.getApellidoMaterno().length() > 45 ||
                administrador.getDni().length() > 45 ||
                administrador.getContrasena().length() > 45) {
            throw new BusinessLogicException("Los campos del administrador no pueden superar 45 caracteres.");
        }
    }

    private void validarId(Integer id) throws BusinessLogicException {
        if (id == null || id <= 0) {
            throw new BusinessLogicException("El ID del administrador no es válido.");
        }
    }

}
