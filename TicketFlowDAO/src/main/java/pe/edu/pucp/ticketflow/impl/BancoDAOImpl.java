package pe.edu.pucp.ticketflow.impl;

import pe.edu.pucp.ticketflow.IBancoDAO;
import pe.edu.pucp.ticketflow.banco.model.Banco;
import pe.edu.pucp.ticketflow.dao.manager.DBManager;
import pe.edu.pucp.ticketflow.ubicacion.model.Distrito;
import pe.edu.pucp.ticketflow.ubicacion.model.Region;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class BancoDAOImpl implements IBancoDAO {

    @Override
    public Banco create(Banco t) {
        return null;
    }

    @Override
    public Banco read(Integer id) {
        String sql = "{CALL SP_LEER_BANCO(?)}";
        try (Connection con = DBManager.getInstance().getConnection();
             CallableStatement cs = con.prepareCall(sql)) {

            cs.setInt(1, id);
            try (ResultSet rs = cs.executeQuery()) {
                if (rs.next()) {
                    return mapearBanco(rs);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al leer Banco", e);
        }
        return null;
    }

    @Override
    public Banco update(Banco t, Integer id) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public List<Banco> listAll() {
        return List.of();
    }

    private Banco mapearBanco(ResultSet rs) throws SQLException {
        Banco b = new Banco();
        b.setId(rs.getInt("idBanco"));
        b.setNombre_largo(rs.getString("nombre_largo"));
        b.setNombre_corto(rs.getString("nombre_corto"));

        return b;
    }

}
