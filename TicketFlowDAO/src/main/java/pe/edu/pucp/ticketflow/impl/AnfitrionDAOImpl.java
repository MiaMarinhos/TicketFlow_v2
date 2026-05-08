package pe.edu.pucp.ticketflow.impl;

import pe.edu.pucp.ticketflow.IAnfitrionDAO;
import pe.edu.pucp.ticketflow.dao.manager.DBManager;
import pe.edu.pucp.ticketflow.usuario.model.Anfitrion;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class AnfitrionDAOImpl implements IAnfitrionDAO {


    @Override
    public Anfitrion create(Anfitrion t) {
        String sql = "{CALL SP_INSERTAR_ANFITRION(?, ?, ?, ?, ?)}";
        try (Connection con = DBManager.getInstance().getConnection();
             CallableStatement cs = con.prepareCall(sql)) {

            cs.setInt(1, t.getIdUsuario());
            cs.setString(2, t.getRazonSocial());
            cs.setString(3, t.getRuc());
            cs.setString(4, t.getCuentaBancaria());
            cs.setInt(5, t.getBanco().getId());

            cs.execute();
            return t;
        } catch (SQLException e) {
            throw new RuntimeException("Error al crear anfitrion", e);
        }
    }

    @Override
    public Anfitrion read(Integer id) {
        return null;
    }

    @Override
    public Anfitrion update(Anfitrion t, Integer id) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public List<Anfitrion> listAll() {
        return List.of();
    }
}
