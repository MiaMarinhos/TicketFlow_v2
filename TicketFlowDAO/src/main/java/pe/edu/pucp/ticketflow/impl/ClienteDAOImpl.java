package pe.edu.pucp.ticketflow.impl;

import pe.edu.pucp.ticketflow.IClienteDAO;
import pe.edu.pucp.ticketflow.dao.manager.DBManager;
import pe.edu.pucp.ticketflow.usuario.model.Cliente;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

public class ClienteDAOImpl implements IClienteDAO {
    @Override
    public Cliente create(Cliente t) {
        String sql = "{CALL SP_INSERTAR_CLIENTE(?, ?)}";
        try (Connection con = DBManager.getInstance().getConnection();
             CallableStatement cs = con.prepareCall(sql)) {

            cs.setInt(1, t.getIdUsuario());
            cs.setInt(2, t.getPuntosBonus());

            cs.execute();
            return t;
        } catch (SQLException e) {
            throw new RuntimeException("Error al crear cliente", e);
        }
    }

    @Override
    public Cliente read(Integer id) {
        return null;
    }

    @Override
    public Cliente update(Cliente t, Integer id) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public List<Cliente> listAll() {
        return List.of();
    }
}
