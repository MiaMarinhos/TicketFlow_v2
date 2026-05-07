package pe.edu.pucp.ticketflow.impl;

import pe.edu.pucp.ticketflow.IPuntosBonusDAO;
import pe.edu.pucp.ticketflow.puntosBonus.model.PuntosBonus;

import java.util.List;

public class PuntosBonusDAOImpl implements IPuntosBonusDAO {
    @Override
    public Integer create(PuntosBonus t){
        return 0;
    }
    @Override
    public PuntosBonus read(Integer id){
        return null;
    }
    @Override
    public boolean update(PuntosBonus t, Integer id) {
        return false;
    }
    @Override
    public boolean delete(Integer id){
        return false;
    }
    @Override
    public List<PuntosBonus> listAll(){
        return null;
    }
}
