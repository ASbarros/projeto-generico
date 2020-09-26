package Controller;

import DAO.PersistenciaJPA;
import Model.ObjetoBase;
import java.util.List;

public abstract class ControllerBase<T extends ObjetoBase> {

    protected T objetoBase;
    protected PersistenciaJPA<T> dao;

    public void salvar(String[] dados) {
        objetoBase.toObjeto(dados);
        dao.salvar(objetoBase);
    }

    public void deletar(int id) {
        dao.remover(id);
    }

    public String[] recuperar(int id) {
        return dao.recuperar(id).toStringVetor();
    }

    public List<T> recuperarTodos() {
        return dao.recuperarTodos();
    }

}
