package generics;

import Controller.CategoriaController;
import DAO.PersistenciaJPA;
import Model.Categoria;
import java.time.ZonedDateTime;
import java.util.GregorianCalendar;
import reflexao.AlunoReflectionExemplo;
import reflexao.Reflexao;

public class Generics {

    public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {

        /*CategoriaController controller = new CategoriaController();
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
        controller.deletar(1);*/
        final AlunoReflectionExemplo alunoReflectionExemplo = new AlunoReflectionExemplo();
        alunoReflectionExemplo.setCodigo(01);
        alunoReflectionExemplo.setDataMatricula(GregorianCalendar.from(ZonedDateTime.now()));
        alunoReflectionExemplo.setNome("anderson");
        alunoReflectionExemplo.setNumMatricula("123456789");
        alunoReflectionExemplo.addNota(1);
        alunoReflectionExemplo.addNota(2);
        alunoReflectionExemplo.setValor(5555);

        Reflexao.refletirObjeto(alunoReflectionExemplo, alunoReflectionExemplo.getClass());

    }
}
