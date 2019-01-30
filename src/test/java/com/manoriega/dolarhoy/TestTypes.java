package com.manoriega.dolarhoy;

import org.junit.Test;

public class TestTypes {

    @Test
    public void types(){
//        enteros
        byte edad = 127;
        short anio = -32768;
        int id = 1001;
        long idLong = 123454534534534534L;
//        punto flotante
        float diametro = 34.25F;
        double precio = 123421423123123.12312312312;

//        texto
        char genero = 'M';
//        logico
        boolean esVisible = true;
        Boolean asd = true;
        System.out.println(((Object)edad).getClass().getName());

    }
}
