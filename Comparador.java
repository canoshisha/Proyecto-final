package epd.evaluable;

import java.util.Comparator;

public class Comparador implements Comparator {//  en esta clase creamos un orden alternativo para las tablas con objetos limpiadoras

    @Override
    public int compare(Object o1, Object o2) {// en este metodo comparamos dos objetos de la tabla y lo ordenamos por sueldo
        Limpiadora e1 = (Limpiadora) o1;
        Limpiadora e2 = (Limpiadora) o2;
        int cmp;
        if (e1.getSueldo() > e2.getSueldo()) {
            cmp = 1;
        } else if (e1.getSueldo() < e2.getSueldo()) {
            cmp = -1;
        } else {// si los sueldos son iguales ordena los dos objetos por el orden natural de la clase limpiadora
            cmp = e1.compareTo(e2);
        }
        return cmp;
    }

}
