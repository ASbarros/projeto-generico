package DAO;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class FuncoesJPA {

    public static EntityManager AbrirTransacao() {
        EntityManager gerente = FabricaConexao.getManager();
        gerente.getTransaction().begin();
        return gerente;
    }
    
    public static void Persistir(Object obj){
        EntityManager trans = AbrirTransacao();
        trans.persist(obj);
        FecharTransacao(trans, true);
    }

    public static void FecharTransacao(EntityManager gerente, boolean bCommit) {
        if (bCommit) {
            gerente.getTransaction().commit();
        } else {
            gerente.getTransaction().rollback();
        }
        gerente.close();
    }

    public static void Fundir(Object obj) {
        EntityManager trans = AbrirTransacao();
        trans.merge(obj);
        FecharTransacao(trans, true);
    }

    public static void Excluir(int iChave, Class classe) {
        EntityManager trans = AbrirTransacao();
        Object obj = trans.find(classe, iChave);
        trans.remove(obj);
        FecharTransacao(trans, true);
    }

    public static Object recuperar(int chave, Class classe) {
        
        EntityManager trans = FabricaConexao.getManager();
        return trans.find(classe, chave);
    }

    public static List<?> Selecionar(Class classe, String whereJPQL) {
        EntityManager trans = FabricaConexao.getManager();
        String sJPQL = "select u from" + classe.getName() + " u " + whereJPQL;
        Query minhaQuery = trans.createQuery(sJPQL);
        return minhaQuery.getResultList();
    }

    public static List<?> Selecionar(Class classe, String[][] parametros) {
        String sWhere = "";
        if (parametros.length > 0) {
            for (int i = 0; i < parametros.length; i++) {
                if (i == 0) {
                    sWhere = sWhere + " where ";
                } else {
                    sWhere = sWhere + " and ";
                }
                String campo = parametros[i][0];
                String valor = parametros[i][1];

                sWhere = sWhere + campo + " = " + valor;
            }
        }
        return Selecionar(classe, sWhere);
    }

    public static List<?> Selecionar(Class classe) {
        return Selecionar(classe, "");
    }
}
