package com.manoriega.dolarhoy.sandbox;

import com.manoriega.dolarhoy.util.HtmlDataParser;
import org.junit.Test;

import java.lang.reflect.*;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class TestApiReflex {

    @Test
    public void test() throws NoSuchFieldException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {


        //obtengo la clase
        Class htmlClass = HtmlDataParser.class;
//        System.err.println("nombre de clase: ");
//        System.out.println( htmlClass.getSimpleName());
//
////        obtener una variable publica
//        Field variablePublica = htmlClass.getField("DOLAR");
//        System.err.println("variable publica: ");
//        System.out.println(variablePublica);
//
////        otener una variable privada o no privada
//        Field privadaOnPrivada = htmlClass.getDeclaredField("foo");
//        System.err.println("variable privada: ");
//        System.out.println(privadaOnPrivada);
//
////        todas las variables declaradas publicas
//        Field[] variablesPublicas = htmlClass.getFields();
//        List<Field> variablesPublicasList = Arrays.asList(variablesPublicas);
//        System.err.println("variables publicas:");
//        variablesPublicasList.forEach(System.out::println);
//
//        Field[] variablesPublicasPrivadas = htmlClass.getDeclaredFields();
//        List<Field> variablesPublicasPivadasFieldList = Arrays.asList(variablesPublicasPrivadas);
//        System.err.println("variables publicas privadas: ");
//        variablesPublicasPivadasFieldList.forEach(System.out::println);
//
////        metodos
////        obtener un metodo publico
//        Method metodoGetCompra = htmlClass.getMethod("getCompra");
//        System.err.println(metodoGetCompra.getModifiers());
//        Boolean privado = Modifier.isPublic(metodoGetCompra.getModifiers());
////        obtener metodo privado
//        Method metodoFoo = htmlClass.getDeclaredMethod("foo");
//
//
//        System.out.println(metodoFoo);
////        mtodos publicos
//        Method[] metodosPublicos = htmlClass.getMethods();
//        List<Method> metodosPublicosList = Arrays.asList(metodosPublicos);
//        System.err.println("metodos publicos: ");
//        metodosPublicosList.forEach(System.out::println);

        HtmlDataParser htmlDataParser = new HtmlDataParser();
        Method metodoPrivado = htmlClass.getDeclaredMethod("foo");
        metodoPrivado.setAccessible(true);
        String end = (String) metodoPrivado.invoke(htmlDataParser);

        Method[] metodosPublicosPrivados = htmlClass.getDeclaredMethods();
        List<Method> metodosPublicosPrivadosList = Arrays.asList(metodosPublicosPrivados);
        System.err.println("metodos publicos privados:");
        metodosPublicosPrivadosList.forEach(System.out::println);

//        constructores
        Constructor[] contructoresPublicos = htmlClass.getConstructors();
        System.err.println("contructores publicos: ");
        Arrays.stream(contructoresPublicos).forEach(System.out::println);

        Constructor[] constructors = htmlClass.getDeclaredConstructors();
        System.err.println("contructores privados:");
         Arrays.stream(constructors).forEach(System.out::println);

//        String nombreVariable =  variablePublica.getName();
//        System.out.println("nombre variable: " + nombreVariable);
    }
}
