package pe.edu.pucp.ticketflow.impl;

import pe.edu.pucp.ticketflow.IAdministradorDAO;
import pe.edu.pucp.ticketflow.administrador.model.Administrador;
import pe.edu.pucp.ticketflow.dao.manager.DBManager;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdministradorDAOImpl implements IAdministradorDAO {
    @Override
    public Administrador create(Administrador t) {

        String sql = "{CALL USP_INSERTAR_ADMINISTRADOR(?, ?, ?, ?, ?, ?, ?)}";

        try (Connection con = DBManager.getInstance().getConnection();
             CallableStatement cs = con.prepareCall(sql)) {

            cs.setInt(1, t.getIdAdministrador());
            cs.setString(2, t.getCodigo());
            cs.setString(3, t.getNombre());
            cs.setString(4, t.getApellidoPaterno());
            cs.setString(5, t.getApellidoMaterno());
            cs.setString(6, t.getDni());
            cs.setString(7, t.getContrasena());

            cs.execute();

            return t;

        } catch (SQLException e) {
            throw new RuntimeException("Error al crear administrador", e);
        }
    }

    @Override
    public Administrador read(Integer id) {
        String sql = "{CALL USP_LEER_ADMINISTRADOR(?)}";

        try (Connection con = DBManager.getInstance().getConnection();
             CallableStatement cs = con.prepareCall(sql)) {

            cs.setInt(1, id);

            try (ResultSet rs = cs.executeQuery()) {
                if (rs.next()) {
                    Administrador t = new Administrador();
                    mapear(rs, t);
                    return t;
                }
            }

            return null;

        } catch (SQLException e) {
            throw new RuntimeException("Error al leer administrador", e);
        }
    }

    @Override
    public Administrador update(Administrador t, Integer id) {
        String sql = "{CALL USP_ACTUALIZAR_ADMINISTRADOR(?, ?, ?, ?, ?, ?, ?)}";

        try (Connection con = DBManager.getInstance().getConnection();
             CallableStatement cs = con.prepareCall(sql)) {

            cs.setInt(1, id);
            cs.setString(2, t.getCodigo());
            cs.setString(3, t.getNombre());
            cs.setString(4, t.getApellidoPaterno());
            cs.setString(5, t.getApellidoMaterno());
            cs.setString(6, t.getDni());
            cs.setString(7, t.getContrasena());

            cs.execute();

            return t;

        } catch (SQLException e) {
            throw new RuntimeException("Error al actualizar administrador", e);
        }
    }

    @Override
    public void delete(Integer id) {
        String sql = "{CALL USP_ELIMINAR_ADMINISTRADOR(?)}";

        try (Connection con = DBManager.getInstance().getConnection();
             CallableStatement cs = con.prepareCall(sql)) {

            cs.setInt(1, id);

            cs.execute();

        } catch (SQLException e) {
            throw new RuntimeException("Error al eliminar administrador", e);
        }
    }

    @Override
    public List<Administrador> listAll() {
        List<Administrador> lista = new ArrayList<>();

        String sql = "{CALL USP_LISTAR_ADMINISTRADORES()}";

        try (Connection con = DBManager.getInstance().getConnection();
             CallableStatement cs = con.prepareCall(sql);
             ResultSet rs = cs.executeQuery()) {

            while (rs.next()) {

                Administrador t = new Administrador();

                mapear(rs, t);

                lista.add(t);
            }

            return lista;

        } catch (SQLException e) {
            throw new RuntimeException("Error en listar administradores", e);
        }
    }

    private void mapear(ResultSet rs, Administrador t) throws SQLException {
        t.setIdAdministrador(rs.getInt("idAdministrador"));
        t.setCodigo(rs.getString("codigo"));
        t.setNombre(rs.getString("nombre"));
        t.setApellidoPaterno(rs.getString("apellido_paterno"));
        t.setApellidoMaterno(rs.getString("apellido_materno"));
        t.setDni(rs.getString("dni"));
        t.setContrasena(rs.getString("contrasena"));
    }
}


