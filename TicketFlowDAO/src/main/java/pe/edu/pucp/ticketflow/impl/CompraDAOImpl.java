package pe.edu.pucp.ticketflow.impl;

import pe.edu.pucp.ticketflow.ICompraDAO;
import pe.edu.pucp.ticketflow.compra.model.Compra;
import pe.edu.pucp.ticketflow.dao.manager.DBManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CompraDAOImpl implements ICompraDAO{
    @Override
    public Compra create(Compra t){
        String sql = "{CALL <nombreProcedure>(?,...)}";

        try(Connection con = DBManager.getInstance().getConnection();
            CallableStatement cs = con.prepareCall(sql)){

            //cs.registerOutParameter(1, Types.INTEGER); //SI ES AUTO_INCREMENT

            //TODO

            cs.execute();
            //t.setIdCompra(cs.getInt(1));
            return t;
        }
        catch (SQLException e){
            throw new RuntimeException("Error al crear Compra", e);
        }
    }
    @Override
    public Compra read(Integer id){
        String sql = "{CALL <nombreProcedure>(?,...)}";

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
        String sql = "{CALL <nombreProcedure>(?,...)}";

        try(Connection con = DBManager.getInstance().getConnection();
            CallableStatement cs = con.prepareCall(sql)){

            cs.setInt(1, id);
            //TODO

            cs.execute();
            return t;
        }
        catch (SQLException e){
            throw new RuntimeException("Error al actualizar Compra", e);
        }
    }
    @Override
    public void delete(Integer id){
        String sql = "{CALL <nombreProcedure>(?)}";

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
        String sql = "{CALL <nombreProcedure>()}";
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

    private void mapear(ResultSet rs, Compra t){
        //TODO
        //Ejemplo: u.setIdUsuario(rs.getInt("idUsuario"));

    }
}
