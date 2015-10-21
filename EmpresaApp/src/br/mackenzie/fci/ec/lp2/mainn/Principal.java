package br.mackenzie.fci.ec.lp2.mainn;

import br.mackenzie.fci.ec.lp2.main.dao.CargoDAO;
import br.mackenzie.fci.ec.lp2.main.model.Cargo;
import br.mackenzie.fci.ec.lp2.mainn.exception.PersistenciaException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Principal {

    public static void main(String[] args) {
        
        try {
            //List<Cargo> cargos = new ArrayList();
            //for (Cargo cargo : cargos) {
            //  System.out.println(cargo);
            //System.out.print(cargo.getCodigo() + " ");
            //System.out.println(cargo.getNome());
            //}
            
            for(Cargo cargo : new CargoDAO().listar()){
                System.out.println(cargo.getCodigo() + " " + cargo.getNome()); 
            }
        } catch (PersistenciaException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
