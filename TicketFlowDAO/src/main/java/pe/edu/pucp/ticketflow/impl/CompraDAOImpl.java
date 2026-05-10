package pe.edu.pucp.ticketflow.impl;

import pe.edu.pucp.ticketflow.*;
import pe.edu.pucp.ticketflow.compra.model.Compra;
import pe.edu.pucp.ticketflow.dao.manager.DBManager;
import pe.edu.pucp.ticketflow.puntosBonus.model.PuntosBonus;

import java.sql.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class CompraDAOImpl implements ICompraDAO{
    @Override
    public Compra create(Compra t){
        String sql = "{CALL sp_create_compras(?,?,?,?,?,?,?,?,?,?,?)}";

        try(Connection con = DBManager.getInstance().getConnection();
            CallableStatement cs = con.prepareCall(sql)){

            cs.setInt(1,t.getIdCompra());
            cs.setInt(2,t.getEntradasCompradas());
            cs.setDate(3,Date.valueOf(t.getFechaCompra()));
            cs.setString(4,t.getMetodoPago());
            cs.setTime(5,Time.valueOf(t.getHoraCompra()));
            cs.setDouble(6,t.getMontoParcial());
            cs.setDouble(7,t.getMontoTotal());
            cs.setInt(8,t.getPuntosBonus().getIdPuntosBonus());
            cs.setInt(9,t.getCliente().getIdUsuario());
            cs.setInt(10,t.getEvento().getIdEvento());
            cs.setInt(11,t.getEstado().getIdEstadoCompra());

            cs.execute();
            return t;
        }
        catch (SQLException e){
            throw new RuntimeException("Error al crear Compra", e);
        }
    }
    @Override
    public Compra read(Integer id){
        String sql = "{CALL sp_read_compras(?)}";

        try(Connection con = DBManager.getInstance().getConnection();
            CallableStatement cs = con.prepareCall(sql)){

            cs.setInt(1, id);
            try(ResultSet rs = cs.executeQuery()){
                if(rs.next()){
                    Compra t = new Compra();
                    mapear(rs, t);
                    return t;
                }
            }
            return null;
        }
        catch (SQLException e){
            throw new RuntimeException("Error al leer Compra", e);
        }
    }
    @Override
    public Compra update(Compra t, Integer id) {
        String sql = "{CALL sp_update_compras(?,?,?,?,?,?,?,?,?,?,?)}";

        try(Connection con = DBManager.getInstance().getConnection();
            CallableStatement cs = con.prepareCall(sql)){

            cs.setInt(1, id);
            cs.setInt(2,t.getEntradasCompradas());
            cs.setDate(3,Date.valueOf(t.getFechaCompra()));
            cs.setString(4,t.getMetodoPago());
            cs.setTime(5,Time.valueOf(t.getHoraCompra()));
            cs.setDouble(6,t.getMontoParcial());
            cs.setDouble(7,t.getMontoTotal());
            cs.setInt(8,t.getPuntosBonus().getIdPuntosBonus());
            cs.setInt(9,t.getCliente().getIdUsuario());
            cs.setInt(10,t.getEvento().getIdEvento());
            cs.setInt(11,t.getEstado().getIdEstadoCompra());

            cs.execute();
            return t;
        }
        catch (SQLException e){
            throw new RuntimeException("Error al actualizar Compra", e);
        }
    }
    @Override
    public void delete(Integer id){
        String sql = "{CALL sp_delete_compras(?)}";

        try (Connection con = DBManager.getInstance().getConnection();
             CallableStatement cs = con.prepareCall(sql)) {

            cs.setInt(1, id);
            cs.execute();
        }
        catch (SQLException e) {
            throw new RuntimeException("Error en eliminar Compra", e);
        }
    }
    @Override
    public List<Compra> listAll(){
        List<Compra> lista = new ArrayList<>();
        String sql = "{CALL sp_listAll_compras()}";
        try (Connection con = DBManager.getInstance().getConnection();
             CallableStatement cs = con.prepareCall(sql);
             ResultSet rs = cs.executeQuery()) {

            while(rs.next()){
                Compra t = new Compra();
                mapear(rs, t);
                lista.add(t);
            }
            return lista;
        }
        catch (SQLException e) {
            throw new RuntimeException("Error en listar Compra", e);
        }
    }

    private void mapear(ResultSet rs, Compra t) throws SQLException{
        t.setIdCompra(rs.getInt("idCompras"));
        t.setEntradasCompradas(rs.getInt("entradas_compradas"));
        t.setFechaCompra(rs.getDate("fecha_compra").toLocalDate());
        t.setMetodoPago(rs.getString("metodo_pago"));
        t.setHoraCompra(rs.getTime("hora_compra").toLocalTime());
        t.setMontoParcial(rs.getDouble("monto_parcial"));
        t.setMontoTotal(rs.getDouble("monto_total"));

        IPuntosBonusDAO puntosBonusDAO = new PuntosBonusDAOImpl();
        t.setPuntosBonus(puntosBonusDAO.read(rs.getInt("idPuntos_bonus")));

        IClienteDAO clienteDAO = new ClienteDAOImpl();
        t.setCliente(clienteDAO.read(rs.getInt("idCliente")));

        IEventoDAO eventoDAO = new EventoDAOImpl();
        t.setEvento(eventoDAO.read(rs.getInt("idEvento")));

        IEstadoComprasDAO estadoComprasDAO = new EstadoComprasDAOImpl();
        t.setEstado(estadoComprasDAO.read(rs.getInt("idEstado")));
    }
}
