package pe.edu.pucp.ticketflow.impl;

import pe.edu.pucp.ticketflow.IEventoDAO;
import pe.edu.pucp.ticketflow.evento.model.Evento;
import pe.edu.pucp.ticketflow.dao.manager.DBManager;
import java.sql.*;

import java.util.List;

public class EventoDAOImpl implements IEventoDAO {
    @Override
    public Integer create(Evento eve){
        String sql = "insert into Evento (idEvento ,titulo,descripcion,capacidad_entradas,fecha,hora_inicio,hora_fin," +
                "ubicacion,nombre_establecimiento,img,precio,idDistrito,idAnfitrion,idCategoria_evento,idEstado_publicacion," +
                "idEstado_evento) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
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
           // pstmt.setInt(12, eve.getDistrito().ge);

            int affectedRows = pstmt.executeUpdate();
           /* Esto solo funcionara si en el sql el id esta definido como AUTO_INCREMENT :(

            if (affectedRows > 0) {
                 try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        int newId = generatedKeys.getInt(1);
                        eve.setIdEvento(newId);
                    }
                }
            }*/
            return eve.getIdEvento();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override// INSERT
    public Evento read(Integer id){
        return null;
    }

    @Override// SELECT por ID
    public boolean update(Evento t, Integer id){
        return false;
    }

    @Override// UPDATE
    public boolean delete(Integer id){
        return false;
    }

    @Override// DELETE
    public List<Evento> listAll(){
        return null;
    }
}
