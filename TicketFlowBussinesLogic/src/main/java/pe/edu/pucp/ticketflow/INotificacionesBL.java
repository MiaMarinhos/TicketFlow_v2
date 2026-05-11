package pe.edu.pucp.ticketflow;

import pe.edu.pucp.ticketflow.exception.BusinessLogicException;

public interface INotificacionesBL {
    void enviarNotificaciones() throws BusinessLogicException;
}
