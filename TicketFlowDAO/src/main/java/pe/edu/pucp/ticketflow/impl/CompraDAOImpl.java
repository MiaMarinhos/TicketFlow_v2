package pe.edu.pucp.ticketflow.impl;

import pe.edu.pucp.ticketflow.ICompraDAO;
import pe.edu.pucp.ticketflow.compra.model.Compra;

import java.util.List;

public class CompraDAOImpl implements ICompraDAO{
    @Override
    public Integer create(Compra t){
        return 0;
    }
    @Override
    public Compra read(Integer id){
        return null;
    }
    @Override
    public boolean update(Compra t, Integer id) {
        return false;
    }
    @Override
    public boolean delete(Integer id){
        return false;
    }
    @Override
    public List<Compra> listAll(){
        return null;
    }
}
