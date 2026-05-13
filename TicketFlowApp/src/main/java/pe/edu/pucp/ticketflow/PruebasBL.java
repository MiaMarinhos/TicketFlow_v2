package pe.edu.pucp.ticketflow;
import pe.edu.pucp.ticketflow.administrador.model.Administrador;
import pe.edu.pucp.ticketflow.evento.model.Evento;
import pe.edu.pucp.ticketflow.exception.BusinessLogicException;
import pe.edu.pucp.ticketflow.impl.AdministradorBLImpl;
import pe.edu.pucp.ticketflow.impl.EventoBLImpl;

import java.util.List;
public class PruebasBL  {
    static void main() throws BusinessLogicException{
        IEventoBL eventoBL = new EventoBLImpl();
        Evento evento = new Evento();
        evento.setIdEvento(1);

        evento.setTitulo("Concierto de Rock Nacional");
        evento.setDescripcion("Festival en vivo con bandas peruanas");
        evento.setCapacidad_entradas(500);

        evento.setFecha(
                java.sql.Date.valueOf("2026-06-20")
        );

        evento.setHora_inicio(
                java.sql.Time.valueOf("19:00:00")
        );

        evento.setHora_fin(
                java.sql.Time.valueOf("23:30:00")
        );

        evento.setUbicacion("Av. Arequipa 1450");
        evento.setNombre_establecimiento("Arena Lima");
        evento.setImg("evento_rock.jpg");

        evento.setPrecio(120.50);

        evento.setFK_idDistrito(15);

        evento.setIdAnfitrion(3);

        evento.setFK_idCategoria_evento(2);

        evento.setFK_idEstadoPublicacion(1);

        evento.setFK_idEstadoEvento(1);

        eventoBL.crearEvento(evento);
    }
}
