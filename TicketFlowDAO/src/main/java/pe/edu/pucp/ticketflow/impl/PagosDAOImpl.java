package pe.edu.pucp.ticketflow.impl;

import pe.edu.pucp.ticketflow.IPagosDAO;
import pe.edu.pucp.ticketflow.pago.model.Pago;

import java.util.List;

public class PagosDAOImpl implements IPagosDAO {
    @Override
    public Integer create(Pago t){
        return 0;
    }
    @Override
    public Pago read(Integer id){
        return null;
    }
    @Override
    public boolean update(Pago t, Integer id) {
        return false;
    }
    @Override
    public boolean delete(Integer id){
        return false;
    }
    @Override
    public List<Pago> listAll(){
        return null;
    }
}
