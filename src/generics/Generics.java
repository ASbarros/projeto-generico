package generics;

import Controller.CategoriaController;
import DAO.PersistenciaJPA;
import Model.Categoria;

public class Generics {

    public static void main(String[] args) {

        CategoriaController controller = new CategoriaController();
        String[] dados = new String[3];
        dados[0] = "0";
        dados[1] = "inserir";
        dados[2] = "true";
        controller.salvar(dados);
        
        dados[0]="1";
        dados[1]="atualizar";
        controller.salvar(dados);
        
        
        String[] recupera = controller.recuperar(1);
        
        for (String string : recupera) {
            System.out.println(string);
        }
        controller.deletar(1);
        
        

    }
}
