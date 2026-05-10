package pe.edu.pucp.ticketflow.impl;

import pe.edu.pucp.ticketflow.IEstadoPagosDAO;
import pe.edu.pucp.ticketflow.IEventoDAO;
import pe.edu.pucp.ticketflow.IPagosDAO;
import pe.edu.pucp.ticketflow.dao.manager.DBManager;
import pe.edu.pucp.ticketflow.pago.model.Pago;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;

public class PagosDAOImpl implements IPagosDAO {
    @Override
    public Pago create(Pago t){
        String sql = "{CALL sp_create_pagos(?,?,?,?,?,?,?)}";

        try(Connection con = DBManager.getInstance().getConnection();
            CallableStatement cs = con.prepareCall(sql)){

            cs.setInt(1,t.getIdPago());
            cs.setDate(2, Date.valueOf(t.getFechaPago()));
            cs.setDate(3, Date.valueOf(t.getFechaLimitePago()));
            cs.setDouble(4, t.getTotalAPagar());
            cs.setString(5, t.getComprobante());
            cs.setInt(6, t.getEvento().getIdEvento());
            cs.setInt(7,t.getEstado().getIdEstadoPago());

            cs.execute();
            return t;
        }
        catch (SQLException e){
            throw new RuntimeException("Error al crear Pago", e);
        }
    }
    @Override
    public Pago read(Integer id){
        String sql = "{CALL sp_read_pagos(?)}";

        try(Connection con = DBManager.getInstance().getConnection();
            CallableStatement cs = con.prepareCall(sql)){

            cs.setInt(1, id);
            try(ResultSet rs = cs.executeQuery()){
                if(rs.next()){
                    Pago t = new Pago();
                    mapear(rs, t);
                    return t;
                }
            }
            return null;
        }
        catch (SQLException e){
            throw new RuntimeException("Error al leer Pago", e);
        }
    }
    @Override
    public Pago update(Pago t, Integer id) {
        String sql = "{CALL sp_update_pagos(?,?,?,?,?,?,?)}";

        try(Connection con = DBManager.getInstance().getConnection();
            CallableStatement cs = con.prepareCall(sql)){

            cs.setInt(1, id);
            cs.setDate(2, Date.valueOf(t.getFechaPago()));
            cs.setDate(3, Date.valueOf(t.getFechaLimitePago()));
            cs.setDouble(4, t.getTotalAPagar());
            cs.setString(5, t.getComprobante());
            cs.setInt(6, t.getEvento().getIdEvento());
            cs.setInt(7,t.getEstado().getIdEstadoPago());

            cs.execute();
            return t;
        }
        catch (SQLException e){
            throw new RuntimeException("Error al actualizar Pago", e);
        }
    }
    @Override
    public void delete(Integer id){
        String sql = "{CALL sp_delete_pagos(?)}";

        try (Connection con = DBManager.getInstance().getConnection();
             CallableStatement cs = con.prepareCall(sql)) {

            cs.setInt(1, id);
            cs.execute();
        }
        catch (SQLException e) {
            throw new RuntimeException("Error en eliminar Pago", e);
        }
    }
    @Override
    public List<Pago> listAll(){
        List<Pago> lista = new ArrayList<>();
        String sql = "{CALL sp_listAll_pagos()}";
        try (Connection con = DBManager.getInstance().getConnection();
             CallableStatement cs = con.prepareCall(sql);
             ResultSet rs = cs.executeQuery()) {

            while(rs.next()){
                Pago t = new Pago();
                mapear(rs, t);
                lista.add(t);
            }
            return lista;
        }
        catch (SQLException e) {
            throw new RuntimeException("Error en listar Pago", e);
        }
    }

    private void mapear(ResultSet rs, Pago t) throws SQLException{
        t.setIdPago(rs.getInt("idPagos"));
        t.setFechaPago(rs.getDate("fecha_pago").toLocalDate());
        t.setFechaLimitePago(rs.getDate("fecha_limite_pago").toLocalDate());
        t.setTotalAPagar(rs.getDouble("total_a_pagar"));
        t.setComprobante(rs.getString("comprobante"));

        IEventoDAO eventoDAO = new EventoDAOImpl();
        t.setEvento(eventoDAO.read(rs.getInt("idEvento")));

        IEstadoPagosDAO estadoPagosDAO = new EstadoPagosDAOImpl();
        t.setEstado(estadoPagosDAO.read(rs.getInt("idEstado")));
    }
}
