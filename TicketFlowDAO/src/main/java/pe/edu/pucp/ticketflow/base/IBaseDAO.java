package pe.edu.pucp.ticketflow.base;

import java.util.List;

public interface IBaseDAO <Tipo, ID>{
    ID create(Tipo t);                  // INSERT
    Tipo read(ID id);                   // SELECT por ID
    boolean update(Tipo t, ID id);      // UPDATE
    boolean delete(ID id);              // DELETE
    List<Tipo> listAll();               // SELECT *
}
