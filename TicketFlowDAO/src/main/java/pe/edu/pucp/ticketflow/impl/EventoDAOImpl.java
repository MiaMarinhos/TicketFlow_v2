package pe.edu.pucp.ticketflow.impl;

import pe.edu.pucp.ticketflow.IEventoDAO;
import pe.edu.pucp.ticketflow.evento.model.EstadoEvento;
import pe.edu.pucp.ticketflow.evento.model.EstadoPublicacion;
import pe.edu.pucp.ticketflow.evento.model.Evento;
import pe.edu.pucp.ticketflow.dao.manager.DBManager;
import pe.edu.pucp.ticketflow.evento.model.categoria_evento;
import pe.edu.pucp.ticketflow.ubicacion.model.Distrito;
import pe.edu.pucp.ticketflow.ubicacion.model.Region;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;

public class EventoDAOImpl implements IEventoDAO {
    @Override
    public Evento create(Evento eve){
        // INSERT
        String sql = "{CALL SP_INSERTAR_EVENTO (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
        try(Connection connection = DBManager.getInstance().getConnection();

            CallableStatement cs = connection.prepareCall(sql)) {
            cs.registerOutParameter(1, Types.INTEGER);

            cs.setString(2, eve.getTitulo());
            cs.setString(3, eve.getDescripcion());
            cs.setInt(4, eve.getCapacidad_entradas());
            cs.setDate(5, (Date) eve.getFecha());
            cs.setTime(6, eve.getHora_inicio());
            cs.setTime(7, eve.getHora_fin());
            cs.setString(8, eve.getUbicacion());
            cs.setString(9, eve.getNombre_establecimiento());
            cs.setString(10, eve.getImg());
            cs.setDouble(11, eve.getPrecio());
            cs.setInt(12, eve.getFK_idDistrito());
            cs.setInt(13, eve.getIdAnfitrion());
            cs.setInt(14, eve.getFK_idCategoria_evento());
            cs.setInt(15, eve.getFK_idEstadoPublicacion());
            cs.setInt(16, eve.getFK_idEstadoEvento());
            cs.setBoolean(17, eve.isActivo()); //aunque en teoria seria siempre true podria hardcodearlo de frente

            cs.execute();
            eve.setIdEvento(cs.getInt(1));

            return eve;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Evento read(Integer id) {
// SELECT por ID
        String sql =
                "SELECT {CALL SP_LEER_EVENTO(?)}";

        try (Connection connection = DBManager.getInstance().getConnection();
             CallableStatement cs = connection.prepareCall(sql)) {

            cs.setInt(1, id);

            try (ResultSet rs = cs.executeQuery()) {

                if (rs.next()) {

                    Evento evento = new Evento();

                    evento.setIdEvento(rs.getInt("idEvento"));
                    evento.setTitulo(rs.getString("titulo"));
                    evento.setDescripcion(rs.getString("descripcion"));
                    evento.setCapacidad_entradas(rs.getInt("capacidad_entradas"));
                    evento.setFecha(rs.getDate("fecha"));
                    evento.setHora_inicio(rs.getTime("hora_inicio"));
                    evento.setHora_fin(rs.getTime("hora_fin"));
                    evento.setUbicacion(rs.getString("ubicacion"));
                    evento.setNombre_establecimiento(rs.getString("nombre_establecimiento"));
                    evento.setImg(rs.getString("img"));
                    evento.setPrecio(rs.getDouble("precio"));
                    evento.setIdAnfitrion(rs.getInt("idAnfitrion"));

                    evento.setFK_idCategoria_evento(rs.getInt("idCategoria_evento"));

                    evento.setFK_idEstadoPublicacion(rs.getInt("idEstado_publicacion"));

                    evento.setFK_idEstadoPublicacion(rs.getInt("idEstado_evento"));

                    evento.setFK_idDistrito(rs.getInt("idDistrito"));

                    return evento;
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    @Override
    public Evento update(Evento evento, Integer id){
        // UPDATE
        String sql =
                "{CALL SP_ACTUALIZAR_EVENTO(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
        try(Connection connection = DBManager.getInstance().getConnection();
            CallableStatement cs = connection.prepareCall(sql)) {

            cs.setInt(1, evento.getIdEvento());
            cs.setString(2, evento.getTitulo());
            cs.setString(3, evento.getDescripcion());
            cs.setInt(4, evento.getCapacidad_entradas());
            cs.setDate(5, (Date) evento.getFecha());
            cs.setTime(6, evento.getHora_inicio());
            cs.setTime(7, evento.getHora_fin());
            cs.setString(8, evento.getUbicacion());
            cs.setString(9, evento.getNombre_establecimiento());
            cs.setString(10, evento.getImg());
            cs.setDouble(11, evento.getPrecio());

            cs.setInt(12, evento.getFK_idDistrito());
            cs.setInt(13, evento.getIdAnfitrion());
            cs.setInt(14, evento.getFK_idCategoria_evento());
            cs.setInt(15, evento.getFK_idEstadoPublicacion());
            cs.setInt(16, evento.getFK_idEstadoEvento());

            cs.setBoolean(17, evento.isActivo());

            int filas = cs.executeUpdate();

            return evento;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Integer id){
        // UPDATE estado = false
        String sql =
                "{CALL SP_ELIMINAR_EVENTO(?)}}";
        try(Connection connection = DBManager.getInstance().getConnection();
            CallableStatement cs = connection.prepareCall(sql)) {
            cs.setInt(1,id);

            cs.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Evento> listAll(){
        //SELECT *
        String sql ="SELECT {CALL SP_LISTAR_EVENTO()}";


        try (Connection connection = DBManager.getInstance().getConnection();
             CallableStatement cs = connection.prepareCall(sql)) {

            try (ResultSet rs = cs.executeQuery()) {
                List<Evento> eventos = new ArrayList<>();

                while (rs.next()) {

                    Evento evento = new Evento();

                    evento.setIdEvento(rs.getInt("idEvento"));
                    evento.setTitulo(rs.getString("titulo"));
                    evento.setDescripcion(rs.getString("descripcion"));
                    evento.setCapacidad_entradas(rs.getInt("capacidad_entradas"));
                    evento.setFecha(rs.getDate("fecha"));
                    evento.setHora_inicio(rs.getTime("hora_inicio"));
                    evento.setHora_fin(rs.getTime("hora_fin"));
                    evento.setUbicacion(rs.getString("ubicacion"));
                    evento.setNombre_establecimiento(
                            rs.getString("nombre_establecimiento")
                    );
                    evento.setImg(rs.getString("img"));
                    evento.setPrecio(rs.getDouble("precio"));
                    evento.setIdAnfitrion(rs.getInt("idAnfitrion"));
                    evento.setActivo(rs.getBoolean("activo"));

                    evento.setFK_idCategoria_evento(rs.getInt("idCategoria_evento"));

                    evento.setFK_idEstadoPublicacion(rs.getInt("idEstado_publicacion"));

                    evento.setFK_idEstadoEvento(rs.getInt("idEstado_evento"));
                    evento.setFK_idDistrito(rs.getInt("idDistrito"));
                    
                    eventos.add(evento);
                }
                return eventos;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
