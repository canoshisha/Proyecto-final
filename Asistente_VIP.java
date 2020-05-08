package epd.evaluable;

import poo.io.IO;

public class Asistente_VIP extends Asistente {// en esta clase creamos los asistentes vip los cuales pueden pedir una bebida en la funcion y pueden ir a visitar a los actores.

    public Asistente_VIP(int fila, int asiento, int codigoPostal, int zona, String dni, String nombreA, String apellidos, int edad, String correo, String localidad, Fecha fechaFuncion, String Nombre, String teatro) {
        super(fila, asiento, codigoPostal, zona, dni, nombreA, apellidos, edad, correo, localidad, fechaFuncion, Nombre, teatro);
        System.out.println("El asistente VIP puede ir 30 min antes de la funcion a ver a los actores, y pueden pedir bebidas durante la función a los acomodadores");
    }

    public void verActores() { // con este metodo el asistente vip va a ver a los actores
        String s;
        s = "El asistente " + super.getNombre() + " esta viendo a los actores";
        System.out.println(s);

    }

    public void pedirBebidas() {// en esta clase el asistente vip le pide una bebida a el acomodador.
        System.out.println(super.getNombre() + ": cuando pueda");
        System.out.println("-Acomodador: Dígame");
        System.out.println(super.getNombre() + ":Querría una bebida");
        System.out.println("-Acomodador: ¿Que bebida desea?");
        String s = (String) IO.readLine();
        System.out.println("-Acomodador: Ahora mismo le traigo su " + s);
    }

    @Override
    public String toString() {// uso el tostring del super pero indicando que el asistente es vip
        String s = "";
        s += super.toString();
        s += " como asistente VIP";
        return s;
    }

    @Override
    public boolean equals(Object o) {// uso el equals del super ya que no tiene atributos propios 
        Asistente_VIP f = (Asistente_VIP) o;
        return super.equals(o);
    }
     @Override
    public String descripcion() {
     String s;
     s= "en esta clase se crean asistentes VIPS, los cuales tienen una localidad comprada y tienen privilegios por sser VIPS como ir a ver actores o pedir bebidas durante la funcion";
     return s;
    }
}
