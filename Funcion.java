
package epd.evaluable;

public abstract class Funcion {

    private String nombre;
    private String teatro;
    private Fecha fechaFuncion;

    public Funcion(String nombre, String teatro, Fecha fechaFuncion) {
        this.nombre = nombre;
        this.teatro = teatro;
        this.fechaFuncion = fechaFuncion;
    }
    @Override
    public String toString() {
        String s = "Funcion: " + nombre + " en el teatro " + teatro + " en la fecha " + fechaFuncion.toString();
        return s;
    }

    public String getNombre() {
        return nombre;
    }

    private void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTeatro() {
        return teatro;
    }

    private void setTeatro(String teatro) {
        this.teatro = teatro;
    }

    public void cancelar() {// cancela la funcion, hace un toString y luego pone el nombre del teatro y el nombre de la funcion a cero
        System.out.println(toString()+ " queda cancelada");
        nombre = "";
        teatro = "";
    }

    public void modificarLugar(String lugar) {// modifica el lugar donde se realizara la funcion
        this.teatro = lugar;
        System.out.println("La funcion:" + nombre + "se translada a el lugar:" + lugar);
    }

    public Fecha getFechaFuncion() {
        return fechaFuncion;
    }

    public void setFechaFuncion(Fecha fechaFuncion) {
        this.fechaFuncion = fechaFuncion;
    }
    public void ModificarFechaFuncion(int dia, int mes, int anyo, int hora, int minutos){// modifica la fecha completa de la funcion.
        fechaFuncion.setAnyo(anyo);
        fechaFuncion.setMes(mes);
        fechaFuncion.setDia(dia);
        fechaFuncion.setHora(hora);
        fechaFuncion.setMinutos(minutos);
    }
    @Override
    public boolean equals(Object o) {
       Funcion f = (Funcion) o;
        return (nombre.equals(f.nombre) && teatro.equals(f.teatro) && fechaFuncion == f.fechaFuncion );
    }

    public abstract String descripcion();
}
