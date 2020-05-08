
package epd.evaluable;

import poo.io.IO;


public class Acomodador implements ITrabajador,Comparable {
    private double sueldoh, sueldo,minent,minsal;// sueldoh es el sueldo por horas y el sueldo es el sueldo completo tras el dia.
    private int codigoPostal,regalos,edad;
    private String nombre, correo, DNI, apellidos, localidad, zona;
    private Fecha horarioEntrada, horarioSalida;

    public Acomodador(int zona, double sueldoh, int codigoPostal, String nombre, String apellidos, int edad, String correo, String DNI, String localidad, Fecha horarioEntrada, int shora, int sminutos, int regalos) {
        this.sueldoh = sueldoh;
        this.codigoPostal = codigoPostal;
        this.nombre = nombre;
        this.correo = correo;
        this.DNI = DNI;
        this.apellidos = apellidos;
        this.localidad = localidad;
        this.horarioEntrada = horarioEntrada;
        this.edad=edad;
        this.horarioSalida = new Fecha(this.horarioEntrada.getDia(), this.horarioEntrada.getMes(), this.horarioEntrada.getAnyo(), shora, sminutos);// creo una nueva fecha, que sería la de entrada pero con distinta hora, ya que sale el mismo dia que entra
        this.regalos=regalos; 
        switch (zona) {
            case 1:
                this.zona = ZA;
                break;
            case 2:
                this.zona = ZB;
                break;
            case 3:
                this.zona = ZC;
                break;
            case 4:
                this.zona = ZD;
                break;
        }
    }
    
        @Override
    public void setcodigoPostal(int codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    @Override
    public int getcodigoPostal() {
        return codigoPostal;
    }

    @Override
    public String getApellidos() {
        return apellidos;
    }

    @Override
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    @Override
    public String getLocalidad() {
        return localidad;
    }

    @Override
    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    @Override
    public String getDNI() {
        return DNI;
    }

    @Override
    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    @Override
    public Fecha getHorarioEntrada() {
        return horarioEntrada;
    }

    @Override
    public void setHorarioEntrada(Fecha horarioEntrada) {
        this.horarioEntrada = horarioEntrada;
    }

    @Override
    public Fecha getHorarioSalida() {
        return horarioSalida;
    }

    @Override
    public void setHorarioSalida(Fecha horarioSalida) {
        this.horarioSalida = horarioSalida;
    }

    @Override
    public double getSueldoh() {
        return sueldoh;
    }

    @Override
    public void setSueldoh(double sueldoh) {
        this.sueldoh = sueldoh;
    }

    @Override
    public double getSueldo() {
        generarSueldo();
        return sueldo;
    }

    @Override
    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    @Override
    public void generarSueldo() {//sube el sueldo una hora mas a partir de la 30 min es decir, si trabaja 1 hora y 30, el sueldo es de dos horas. Genera el sueldo multiplicando el sueldo por horas por las hroas realizadas
        minent= horarioEntrada.getHora()*60 + horarioEntrada.getMinutos();
        minsal= horarioSalida.getHora()*60 + horarioSalida.getMinutos();
        if (((minsal - minent)%60) >= 30 ){
            sueldo = ((horarioSalida.getHora() - horarioEntrada.getHora()) + 1) * sueldoh;
        } else {
            sueldo = (horarioSalida.getHora() - horarioEntrada.getHora()) * sueldoh;
        }
        sueldo = Math.abs(sueldo);
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    @Override
    public int getEdad() {
        return edad;
    }

    @Override
    public void setEdad(int edad) {
        this.edad = edad;
    }
    @Override
    public String getCorreo() {
        return correo;
    }

    @Override
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {// zona que tiene que limpiar, si el string que entra no corresponde a ninguna zona da un error, se hace uso de constantes de la interfaz para comparar
        if (!ZA.equalsIgnoreCase(zona) && !ZB.equalsIgnoreCase(zona) && !ZC.equalsIgnoreCase(zona) && !ZD.equalsIgnoreCase(zona)) {
            System.out.println("La zona elegida no existe");
        } else {
            if(ZA.equalsIgnoreCase(zona))
                this.zona = ZA;
            if(ZB.equalsIgnoreCase(zona))
                this.zona = ZB;
            if(ZC.equalsIgnoreCase(zona))
                this.zona = ZC;
            if(ZD.equalsIgnoreCase(zona))
                this.zona = ZD;
        }
    }

    @Override
    public void subirSueldo(double sueldo) {//si el trabajo se realiza bien, se le puede subir el sueldo por hora lo que indique
        this.sueldoh = this.sueldoh + sueldo;
        generarSueldo();
        System.out.println("El sueldo de " + nombre + " queda modificacdo a:" + sueldoh + " €/h.Con un sueldo al dia de " + this.sueldo + "€");
    }
    
    public void  repatirRegalo(){
        regalos--;
        System.out.println("El acomodador ha lanzado una camiseta de regalo al publico por la " + zona +" aun le quedan " + regalos + " regalos"); 
    }
    public void obtenerRegalos() throws MiExcepcion{
        int mas;
        System.out.println("¿Cuantos regalos quieres darle a el acomodador para que los reparta si quiere por el publico?");
        mas = (int) IO.readNumber();
        if(mas<12){
        regalos= regalos + mas;
        System.out.println("El acomodador " + nombre + " tiene ahora " + regalos + " regalos");
        }else{
            throw new MiExcepcion();
        }
    }
    public void acompañarAsistente(){
        System.out.println("El acomodador" + nombre + "esta acompañando a un asistente a su asiento");
        
    }
    public void preguntarVIP(){
        System.out.println("El acomodador ha preguntado si quieren bebidas a los asistentes VIP de la " + zona);
    }
    
    @Override
    public int compareTo(Object o) {
    Acomodador acom = (Acomodador)o;
    int cmp= this.apellidos.compareToIgnoreCase(acom.getApellidos());
    if(cmp==0){
       cmp= this.nombre.compareToIgnoreCase(acom.getNombre());
    }  if(cmp==0){
      if(edad>acom.getEdad()){
        cmp=1;
        }
        else if(edad<acom.getEdad()){
                cmp=-1;
                }
        else{
           cmp=0;      
            }  
    }
    return cmp;
    }

    @Override
    public String toString() {// al imprimir le pongo la condicion de que si los minutos son menores a 10 le ponga un cero delante
        String mins;
        if (horarioSalida.getMinutos() < 10) {
            mins = "0" + horarioSalida.getMinutos();
        } else {
            mins = horarioSalida.getMinutos() + "";
        }
        generarSueldo();
        String s = "El acomodador " + nombre + " " + apellidos + " con DNI: " + DNI + " edad: " + edad;
        s += " con correo: " + correo;
        s += " en la fecha " + horarioEntrada.toString() + " entrara a trabajar ";
        s += "y saldra a las " + horarioSalida.getHora() + ":" + mins;
        s += " con un sueldo por horas de: " + sueldoh + " €/h" + " obteniendo un sueldo de ese día de: " + sueldo;
        return s;
    }
    
    @Override
    public boolean equals(Object o) {
        Acomodador f = (Acomodador) o;
        return (nombre.equals(f.nombre) && zona.equals(f.zona) && horarioEntrada == f.horarioEntrada && horarioSalida == f.horarioSalida && apellidos.equals(f.apellidos) && DNI.equals(f.DNI)
                && codigoPostal == f.codigoPostal && sueldoh == f.sueldoh && localidad.equals(f.localidad) && correo.equals(f.correo) && edad == f.edad);
    }
}
