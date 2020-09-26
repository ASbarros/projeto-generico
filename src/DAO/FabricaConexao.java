package DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FabricaConexao {

    private static EntityManagerFactory Fabrica = null;
    private static final String nomeUndPerstencia = "genericsPU";

    public FabricaConexao() {
        Fabrica = Persistence.createEntityManagerFactory(nomeUndPerstencia);
    }

    public static EntityManager getManager() {
        try {
            if (Fabrica == null) {
                FabricaConexao CONEXAOAPBERTA = new FabricaConexao();
                System.out.println("Fabrica JPA aberta!");
            }
            return Fabrica.createEntityManager();
        } catch (Exception e) {
            System.err.println("Erro ao abrir conexao JPA ou criar gerenciador: " + e.getMessage());
            return null;
        }
    }

    public static void FecharFabrica() {
        Fabrica.close();
    }

}
