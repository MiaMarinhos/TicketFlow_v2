package pe.edu.pucp.ticketflow.impl;

import pe.edu.pucp.ticketflow.IEstadoPagosDAO;

import java.util.List;

public class EstadoPagosDAOImpl implements IEstadoPagosDAO {
    @Override
    public Integer create(String t){
        return 0;
    }
    @Override
    public String read(Integer id){
        return null;
    }
    @Override
    public boolean update(String t, Integer id) {
        return false;
    }
    @Override
    public boolean delete(Integer id){
        return false;
    }
    @Override
    public List<String> listAll(){
        return null;
    }
}
