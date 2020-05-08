package epd.evaluable;
//en esta clase creamos la excepcion propia y le definimos dos constructores distintos dependiendo de como queramos utilizarlo.

public class MiExcepcion extends Exception {

    private static final String MENSAJEPORDEFECTO = "ERROR:Se ha producido un error en un metodo propio";

    public MiExcepcion() {
        super(MENSAJEPORDEFECTO);//con este constructor coge el mensaje predefinido en esta clase
    }

    public MiExcepcion(String mensaje) {// con este constructor coge el mensaje que recibe por parametro 
        super(mensaje);
    }
}
