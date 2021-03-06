package reflexao;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Reflexao {

    public static void refletirObjeto(Object obj, Class classe) throws IllegalArgumentException, IllegalAccessException {
        System.out.println("Nome da classe: " + classe.getName());
        System.out.println("Nome da classe (simples): " + classe.getSimpleName());
        System.out.println("Nome da classe (canonical): " + classe.getResource(classe.getName()));
        System.out.println("Tipo: " + classe.getTypeName());
        System.out.println("=============================");
        System.out.println("Atributos");
        final Field[] atributos = classe.getDeclaredFields();
        for (final Field F : atributos) {
            F.setAccessible(true);
            System.out.println(F.getName() + ": " + F.getType().getTypeName() + " ( primitivo: " + F.getType().isPrimitive() + ") -> " + F.get(obj));
        }

        System.out.println("=============================");
        System.out.println("Metodos");
        final Method[] metodos = classe.getDeclaredMethods();
        for (final Method M : metodos) {
            System.out.println(M.getName() + " - parametros: " + Arrays.toString(M.getParameters())
                    + " - retorno: " + M.getReturnType().getSimpleName());
        }
    }
}
