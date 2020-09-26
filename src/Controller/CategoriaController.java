package Controller;

import DAO.PersistenciaJPA;
import Model.Categoria;

public class CategoriaController extends ControllerBase<Categoria> {

    public CategoriaController() {
        objetoBase = new Categoria();
        dao = new PersistenciaJPA<Categoria>(Categoria.class);
    }

}
