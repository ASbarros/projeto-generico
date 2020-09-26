
package DAO;

import Model.ObjetoBase;
import java.util.List;

public class PersistenciaJPA <T extends ObjetoBase>{
    private final Class<T> classePersistente;

    public PersistenciaJPA(Class<T> classePersistente) {
        this.classePersistente = classePersistente;
    }
    
    public void salvar(T obj){
        if(obj.getId()>0)FuncoesJPA.Fundir(obj);
        else FuncoesJPA.Persistir(obj);
    }
    
    public void remover(int i){
        FuncoesJPA.Excluir(i, classePersistente);
    }
    public T recuperar(int id){
        Object obj = FuncoesJPA.recuperar(id, classePersistente);
        return (T)obj;
    }
    public List<T> recuperarTodos(){
        return (List<T>) FuncoesJPA.Selecionar(classePersistente);
    }
    
    
}
