package pe.edu.pucp.ticketflow.impl;

import pe.edu.pucp.ticketflow.IEventoDAO;
import pe.edu.pucp.ticketflow.evento.model.EstadoEvento;
import pe.edu.pucp.ticketflow.evento.model.EstadoPublicacion;
import pe.edu.pucp.ticketflow.evento.model.Evento;
import pe.edu.pucp.ticketflow.dao.manager.DBManager;
import pe.edu.pucp.ticketflow.evento.model.categoria_evento;
import pe.edu.pucp.ticketflow.ubicacion.model.Distrito;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;

public class EventoDAOImpl implements IEventoDAO {
    @Override
    public Integer create(Evento eve){
        // INSERT
        String sql = "insert into Evento (idEvento ,titulo, descripcion, capacidad_entradas, fecha, hora_inicio, hora_fin," +
                "ubicacion, nombre_establecimiento, img, precio, idDistrito, idAnfitrion, idCategoria_evento, idEstado_publicacion," +
                "idEstado_evento,estado) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try(Connection connection = DBManager.getInstance().getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setInt(1, eve.getIdEvento());
            pstmt.setString(2, eve.getTitulo());
            pstmt.setString(3, eve.getDescripcion());
            pstmt.setInt(4, eve.getCapacidad_entradas());
            pstmt.setDate(5, (Date) eve.getFecha());
            pstmt.setTime(6, eve.getHora_inicio());
            pstmt.setTime(7, eve.getHora_fin());
            pstmt.setString(8, eve.getUbicacion());
            pstmt.setString(9, eve.getNombre_establecimiento());
            pstmt.setString(10, eve.getImg());
            pstmt.setDouble(11, eve.getPrecio());
            pstmt.setInt(12, eve.getDistrito().getIdDistrito());
            pstmt.setInt(13, eve.getIdAnfitrion());
            pstmt.setInt(14, eve.getCategoria().getIdCategoria_evento());
            pstmt.setInt(15, eve.getEstadoPublicacion().getIdEstado_publicacion());
            pstmt.setInt(16, eve.getEstadoEvento().getIdEstado_evento());
            pstmt.setBoolean(17, eve.isActivo()); //aunque en teoria seria siempre true podria hardcodearlo de frente

            /*
            int affectedRows = pstmt.executeUpdate();

             Esto solo funcionara si en el sql el id esta definido como AUTO_INCREMENT :(

            if (affectedRows > 0) {
                 try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        int newId = generatedKeys.getInt(1);
                        eve.setIdEvento(newId);
                    }
                }
            }
            */
            return eve.getIdEvento();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Evento read(Integer id) {
// SELECT por ID
        String sql =
                "SELECT " +
                        "e.idEvento, e.titulo, e.descripcion, e.capacidad_entradas, " +
                        "e.fecha, e.hora_inicio, e.hora_fin, e.ubicacion, " +
                        "e.nombre_establecimiento, e.img, e.precio, e.idAnfitrion," +

                        "c.idCategoria_evento, c.nombre, c.dias_para_publicacion, " +

                        "d.idDistrito, d.nombre, d.idRegion, " +

                        "ep.idEstado_publicacion, ep.estado, " +

                        "ee.idEstado_evento, ee.estado,  e.activo " +

                        "FROM evento e " +

                        "INNER JOIN categoria_evento c " +
                        "ON e.idCategoria_evento = c.idCategoria_evento " +

                        "INNER JOIN distrito d " +
                        "ON e.idDistrito = d.idDistrito " +

                        "INNER JOIN estado_publicacion ep " +
                        "ON e.idEstado_publicacion = ep.idEstado_publicacion " +

                        "INNER JOIN estado_evento ee " +
                        "ON e.idEstado_evento = ee.idEstado_evento " +

                        "WHERE e.idEvento = ?";

        try (Connection connection = DBManager.getInstance().getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setInt(1, id);

            try (ResultSet rs = pstmt.executeQuery()) {

                if (rs.next()) {

                    categoria_evento categoria =
                            new categoria_evento(
                                    rs.getInt(13),
                                    rs.getString(14),
                                    rs.getInt(15)
                            );

                    Distrito distrito =
                            new Distrito(
                                    rs.getInt(16),
                                    rs.getString(17),
                                    rs.getInt(18)
                            );

                    EstadoPublicacion estadoPublicacion =
                            new EstadoPublicacion(
                                    rs.getInt(19),
                                    rs.getString(20)
                            );

                    EstadoEvento estadoEvento =
                            new EstadoEvento(
                                    rs.getInt(21),
                                    rs.getString(22)
                            );

                    Evento evento =
                            new Evento(
                                    rs.getInt(1),
                                    rs.getString(2),
                                    rs.getString(3),
                                    rs.getInt(4),
                                    categoria,
                                    rs.getDate(5),
                                    rs.getTime(6),
                                    rs.getTime(7),
                                    rs.getString(8),
                                    rs.getString(9),
                                    rs.getString(10),
                                    rs.getDouble(11),
                                    distrito,
                                    rs.getInt(12),
                                    estadoPublicacion,
                                    estadoEvento,
                                    rs.getBoolean(23)
                            );

                    return evento;
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    @Override
    public boolean update(Evento evento, Integer id){
        // UPDATE
        String sql =
                "update evento set " +
                        "titulo = ?, " +
                        "descripcion = ?, " +
                        "capacidad_entradas = ?, " +
                        "fecha = ?, " +
                        "hora_inicio = ?, " +
                        "hora_fin = ?, " +
                        "ubicacion = ?, " +
                        "nombre_establecimiento = ?, " +
                        "img = ?, " +
                        "precio = ?, " +
                        "idDistrito = ?, " +
                        "idAnfitrion = ?, " +
                        "idCategoria_evento = ?, " +
                        "idEstado_publicacion = ?, " +
                        "idEstado_evento = ? " +
                        "activo = ? " +
                        "where idEvento = ?";
        try(Connection connection = DBManager.getInstance().getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, evento.getTitulo());
            pstmt.setString(2, evento.getDescripcion());
            pstmt.setInt(3, evento.getCapacidad_entradas());
            pstmt.setDate(4, (Date) evento.getFecha());
            pstmt.setTime(5, evento.getHora_inicio());
            pstmt.setTime(6, evento.getHora_fin());
            pstmt.setString(7, evento.getUbicacion());
            pstmt.setString(8, evento.getNombre_establecimiento());
            pstmt.setString(9, evento.getImg());
            pstmt.setDouble(10, evento.getPrecio());

            pstmt.setInt(
                    11,
                    evento.getDistrito().getIdDistrito()
            );

            pstmt.setInt(12, evento.getIdAnfitrion());

            pstmt.setInt(
                    13,
                    evento.getCategoria().getIdCategoria_evento()
            );

            pstmt.setInt(
                    14,
                    evento.getEstadoPublicacion().getIdEstado_publicacion()
            );

            pstmt.setInt(
                    15,
                    evento.getEstadoEvento().getIdEstado_evento()
            );

            pstmt.setBoolean(16, evento.isActivo());

            pstmt.setInt(17, evento.getIdEvento());


            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean delete(Integer id){
        // UPDATE estado = false
        String sql =
                "update evento set " +
                        "activo = ? " +
                        "where idEvento = ?";
        try(Connection connection = DBManager.getInstance().getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setBoolean(1, false);

            pstmt.executeUpdate();

            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Evento> listAll(){
        //SELECT *
        String sql =
                "SELECT " +
                        "e.idEvento, e.titulo, e.descripcion, e.capacidad_entradas, " +
                        "e.fecha, e.hora_inicio, e.hora_fin, e.ubicacion, " +
                        "e.nombre_establecimiento, e.img, e.precio, e.idAnfitrion," +

                        "c.idCategoria_evento, c.nombre, c.dias_para_publicacion, " +

                        "d.idDistrito, d.nombre, d.idRegion, " +

                        "ep.idEstado_publicacion, ep.estado, " +

                        "ee.idEstado_evento, ee.estado,  e.activo " +

                        "FROM evento e " +

                        "INNER JOIN categoria_evento c " +
                        "ON e.idCategoria_evento = c.idCategoria_evento " +

                        "INNER JOIN distrito d " +
                        "ON e.idDistrito = d.idDistrito " +

                        "INNER JOIN estado_publicacion ep " +
                        "ON e.idEstado_publicacion = ep.idEstado_publicacion " +

                        "INNER JOIN estado_evento ee " +
                        "ON e.idEstado_evento = ee.idEstado_evento " +

                        "ORDER BY e.idEvento";

        try (Connection connection = DBManager.getInstance().getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            List<Evento> eventos = new ArrayList<>();

            try (ResultSet rs = pstmt.executeQuery()) {

                while (rs.next()) {

                    categoria_evento categoria =
                            new categoria_evento(
                                    rs.getInt(13),
                                    rs.getString(14),
                                    rs.getInt(15)
                            );

                    Distrito distrito =
                            new Distrito(
                                    rs.getInt(16),
                                    rs.getString(17),
                                    rs.getInt(18)
                            );

                    EstadoPublicacion estadoPublicacion =
                            new EstadoPublicacion(
                                    rs.getInt(19),
                                    rs.getString(20)
                            );

                    EstadoEvento estadoEvento =
                            new EstadoEvento(
                                    rs.getInt(21),
                                    rs.getString(22)
                            );

                    Evento evento =
                            new Evento(
                                    rs.getInt(1),
                                    rs.getString(2),
                                    rs.getString(3),
                                    rs.getInt(4),
                                    categoria,
                                    rs.getDate(5),
                                    rs.getTime(6),
                                    rs.getTime(7),
                                    rs.getString(8),
                                    rs.getString(9),
                                    rs.getString(10),
                                    rs.getDouble(11),
                                    distrito,
                                    rs.getInt(12),
                                    estadoPublicacion,
                                    estadoEvento,
                                    rs.getBoolean(23)
                            );
                    eventos.add(evento);
                }
                return eventos;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
