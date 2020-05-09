package epd.evaluable;

public class Asistente extends Funcion implements IPersona {

    private int fila;
    private int asiento, codigoPostal,edad;
    private String zona, dni, nombreA, correo, apellidos, localidad;
    private Fecha FechaActual;
    private final Fecha fechaFuncion;

    public Asistente(int fila, int asiento, int codigoPostal, int zona, String dni, String nombreA, String apellidos,int edad, String correo, String localidad, Fecha fechaFuncion, String Nombre, String teatro) {
        super(Nombre, teatro, fechaFuncion);
        this.fila = fila;
        this.asiento = asiento;
        this.codigoPostal = codigoPostal;
        this.dni = dni;
        this.nombreA = nombreA;
        this.correo = correo;
        this.apellidos = apellidos;
        this.localidad = localidad;
        this.fechaFuncion = fechaFuncion;
        this.edad=edad;
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
            default:
                System.out.println("Zona elegida incorrecta");
                break;
        }
    }

    @Override
    public String getNombre() {
        return nombreA;
    }

    @Override
    public void setNombre(String nombreA) {
        this.nombreA = nombreA;
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
    public void setcodigoPostal(int codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    @Override
    public int getcodigoPostal() {
        return codigoPostal;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getAsiento() {
        return asiento;
    }

    public void setAsiento(int asiento) {
        this.asiento = asiento;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {// si el string que entra no corresponde a ninguna zona da un error, se hace uso de constantes de la interfaz para comparar
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
    public String getDNI() {
        return dni;
    }

    @Override
    public void setDNI(String dni) {
        this.dni = dni;
    }

    @Override
    public String getCorreo() {
        return correo;
    }

    @Override
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void modificarLocalidad(int fila, int asiento, int zona) {//para modificar la localidad tiene que cumplir que exista esa zona y que este en los 15 dias antes y en el mismo mes
        this.FechaActual = Fecha.ahora();
        if (FechaActual.getDia() - fechaFuncion.getDia() != 14 && FechaActual.getAnyo() == fechaFuncion.getAnyo() && FechaActual.getMes() == fechaFuncion.getMes()) {// solo se podra modificar la localidad el mismo mes, como minimo 15 dias antes, si es el dia 1 del mes la funcion se podría modificar el mismo dia de antes 
            this.fila = fila;
            this.asiento = asiento;
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
                default:
                    System.out.println("Zona elegida incorrecta");
                    break;
            }
        }else{
            System.out.println("La maximo debe realizarse 15 dias antes, el mimos mes");
        }
    }

    @Override
    public void cancelar() {// en este metodo el asistente cancela la asistencia, eliminando la zona, la fila y el asiento, modificando lo que haría la clase padre
        fila = 0;
        asiento = 0;
        zona = "NULL";
        FechaActual = Fecha.ahora();
        System.out.println("La asistencia de " + nombreA + " " + apellidos + " con DNI: " + dni + " a la funcion " + super.getNombre() + " en el teatro " + super.getTeatro() + " queda cancelada en la fecha: " + FechaActual.toString());
    }

    @Override
    public String toString() {
        String s;
        s = "Confirmado la asistencia de: " + nombreA + " " + apellidos + " con DNI " + dni + " y correo " + correo;
        s += " con el codigo postal " + codigoPostal + " en el asiento " + asiento + " fila " + fila + " en la " + zona;
        s += " para la " + super.toString();
        return s;
    }

    public boolean equals(Object o) {
        Asistente f = (Asistente) o;
        return (nombreA.equals(f.nombreA) && zona.equals(f.zona) && fechaFuncion == f.fechaFuncion && apellidos.equals(f.apellidos) && dni.equals(f.dni)
                && codigoPostal == f.codigoPostal && localidad.equals(f.localidad) && asiento == f.asiento && fila == f.fila && correo.equals(f.correo));
    }

    @Override
    public String descripcion() {
     String s;
     s= "en esta clase se crean asistentes normales, los cuales tienen una localidad comprada";
     return s;
    }
}