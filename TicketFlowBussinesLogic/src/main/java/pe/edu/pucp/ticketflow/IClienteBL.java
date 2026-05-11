package pe.edu.pucp.ticketflow;

import pe.edu.pucp.ticketflow.exception.BusinessLogicException;

public interface IClienteBL extends IUsuarioBL{
    void comprarEntradas() throws BusinessLogicException;
    void descargarEntradas() throws BusinessLogicException;
}
