package epd.evaluable;

import java.util.Arrays;
//En esta clase creamos las plantillas de los distintos trabajadores, creamos tablas con  objetos limpiadoras y acomodadores y los introducimos en las distintas tablas

public class Plantilla {

    private Limpiadora[] plantillaLimpiadoras; //creamos el atributo de estilo tabla de limpiadoras
    private Acomodador[] plantillaAcomodador;//creamos el atributo de estilo tabla de acomodadores
    public int numLimpiadora, numAcomodador;//numero exacto que hay de limpiadoras y acomodadores en la tabla
    public static final int MAXPLANTILLAS = 10;// max numero de personas en cada plantilla

    public Plantilla() {// al crear un obhje
        plantillaLimpiadoras = new Limpiadora[MAXPLANTILLAS];// creamos una tabla de tamaño max
        plantillaAcomodador = new Acomodador[MAXPLANTILLAS];
        numLimpiadora = 0;// inicializamos los numeros de limpiadoras y acomodador a 0
        numAcomodador = 0;
    }

    public void añadirLimpiadora(Limpiadora o) throws MiExcepcion {// añadimos limpiadoras siempre y cuando no sean iguales o no este completa la plantilla
        int pos = Arrays.binarySearch(plantillaLimpiadoras, 0, numLimpiadora, o);
        if (pos >= 0) {//o esta en la tabla
            throw new MiExcepcion("La limpiadora ya está en la tabla");   //si hay una persona igual entonces sartaria este mensaje de error
        } else if (numLimpiadora >= MAXPLANTILLAS) {
            throw new MiExcepcion("La plantilla de limpiadoras esta completa");// si esta llena entonces salta este error
        } else {
            plantillaLimpiadoras[numLimpiadora] = o;// si no esta llena introduce o, la limpiadora, en la tabla 
            numLimpiadora++;// aumenta el numero de limpiadoras en la tabla
            Arrays.sort(plantillaLimpiadoras, 0, numLimpiadora);// reordena la tabla con cada elemento segun el orden natural realizado en la clase limpiadora
        }

    }

    public void añadirAcomodador(Acomodador o) throws MiExcepcion {// este metodo es similar al anterior pero ejecutandolo todo con la clase acomodador
        int pos = Arrays.binarySearch(plantillaAcomodador, 0, numAcomodador, o);
        if (pos >= 0) {//o esta en la tabla
            throw new MiExcepcion("La limpiadora ya está en la tabla");
        } else if (numAcomodador >= MAXPLANTILLAS) {
            throw new MiExcepcion("La plantilla de acomodadores esta completa");
        } else {
            plantillaAcomodador[numAcomodador] = o;
            numAcomodador++;
            Arrays.sort(plantillaAcomodador, 0, numAcomodador);
        }
    }

    public void ordenarLimpiadorasCompare() {// en este metodo ordena la tabla plantilla limpiadora con el orden definidio en la clase comparador
        Arrays.sort(plantillaLimpiadoras, 0, numLimpiadora, new Comparador());
    }

    public void imprimeLimpiadora() {//en este ,metodo imprimimos la tabla con las limpiadoras registradas en la plantilla
        for (int i = 0; i < numLimpiadora; i++) {
            System.out.println(plantillaLimpiadoras[i]);
        }
        System.out.println();
    }

    public void imprimeAcomodador() {//en este ,metodo imprimimos la tabla con los acomodadores registrados en la plantilla
        for (int i = 0; i < numAcomodador; i++) {
            System.out.println(plantillaAcomodador[i]);
        }
        System.out.println();
    }

    public Limpiadora[] getPlantillaLimpiadoras() {
        return plantillaLimpiadoras;
    }

    public void setPlantillaLimpiadoras(Limpiadora[] plantillaLimpiadoras) {
        this.plantillaLimpiadoras = plantillaLimpiadoras;
    }

    public Acomodador[] getPlantillaAcomodador() {
        return plantillaAcomodador;
    }

    public void setPlantillaAcomodador(Acomodador[] plantillaAcomodador) {
        this.plantillaAcomodador = plantillaAcomodador;
    }

    public int getNumLimpiadora() {
        return numLimpiadora;
    }

    public void setNumLimpiadora(int numLimpiadora) {
        this.numLimpiadora = numLimpiadora;
    }

    public int getNumAcomodador() {
        return numAcomodador;
    }

    public void setNumAcomodador(int numAcomodador) {
        this.numAcomodador = numAcomodador;
    }
    
    public String toString() {// uso el tostring del super pero indicando que el asistente es vip
        String s="";
        for (int i = 0; i < numLimpiadora; i++) {
           s += plantillaLimpiadoras[i];
           s += "\n";
        }
        for (int i = 0; i < numAcomodador; i++) {
             s += plantillaAcomodador[i];
              s += "\n";
        }
        
        return s;
    }
    
    public boolean equals(Object o) {// compara los objetos que le llegan
        Plantilla f = (Plantilla) o;
        return this.plantillaAcomodador == f.getPlantillaAcomodador() && this.plantillaLimpiadoras == f.getPlantillaLimpiadoras();
    }
}
