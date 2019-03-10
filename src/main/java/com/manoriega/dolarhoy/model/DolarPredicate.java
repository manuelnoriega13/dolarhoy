package com.manoriega.dolarhoy.model;


import java.util.function.Predicate;

public class DolarPredicate {

     public static Predicate<Dolar> registroActivo(Boolean act) {
        return a -> act.equals(a.getActivo());
    }

    public static Predicate<Dolar> fechaDesdeHasta(Integer desde, Integer hasta) {
        return dolar -> dolar.getId() >= desde && dolar.getId() <= hasta;
    }
}
