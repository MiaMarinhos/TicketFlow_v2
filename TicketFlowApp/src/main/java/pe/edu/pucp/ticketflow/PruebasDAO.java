package pe.edu.pucp.ticketflow;


import pe.edu.pucp.ticketflow.administrador.model.Administrador;
import pe.edu.pucp.ticketflow.evento.model.Evento;
import pe.edu.pucp.ticketflow.impl.AdministradorDAOImpl;
import pe.edu.pucp.ticketflow.impl.EventoDAOImpl;

import java.util.List;
public class PruebasDAO {
    static void main(){
        EventoDAOImpl eventoDAO = new EventoDAOImpl();
        Evento ev=eventoDAO.read(1);

        System.out.println(ev.getCategoria());
    }
}
