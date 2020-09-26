/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reflexao;

import java.lang.reflect.Field;

/**
 *
 * @author hetikos
 */
public class Reflexao {
    public static void refletirObjeto(Object obj, Class classe){
        System.out.println("Nome da classe: "+classe.getName());
        System.out.println("Nome da classe (simples): "+classe.getSimpleName());
        System.out.println("Nome da classe (canonical): "+classe.getResource(classe.getName()));
        System.out.println("Tipo: "+classe.getTypeName());
        System.out.println("===========================");
        System.out.println("=========atributos=========");
       // Field[] atributos = 
    }
}
