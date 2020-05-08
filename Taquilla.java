package epd.evaluable;

public class Taquilla extends Funcion {

    private Fecha fechaInicio;
    private int localidades, localidadesVIP, ventas, ventasVIP;
    private int[] ventasTotales = new int[4];

    public Taquilla(Fecha fechaInicio, int localidades, int localidadesVIP, String nombre, String teatro, Fecha fechaFuncion) {
        super(nombre, teatro, fechaFuncion);
        this.fechaInicio = fechaInicio;
        this.localidades = localidades;
        this.localidadesVIP = localidadesVIP;
        actualizaTabla();
    }

    public void modifcarVenta(int dia, int mes, int anyo, int hora, int minutos) {// modificar la fecha de venta
        fechaInicio.setAnyo(anyo);
        fechaInicio.setMes(mes);
        fechaInicio.setDia(dia);
        fechaInicio.setHora(hora);
        fechaInicio.setMinutos(minutos);
        System.out.println("El dia de la venta se ha modificado a el dia:" + fechaInicio.toString());
    }

    public void agotar() {// vendo todas las entradas y dijo las localidades a cero disponibles
        System.out.println("La " + super.toString() + " se ha agotado");
        ventas = ventas + localidades;
        localidades = 0;

    }

    public void venderEntrada() {// al vender una entrada, quito una localiodad disponible y subo una venta, si se han agotado, me lleva directroa agotar
        if (localidades == 0) {
            agotar();
        } else {
            localidades--;
            ventas++;
        }
        actualizaTabla();
    }

    public void venderEntradaVIP() {// al vender una entrada, quito una localiodad disponible y subo una venta, si se han agotado, me lleva directroa agotar
        if (localidadesVIP == 0) {
            agotar();
        } else {
            localidadesVIP--;
            ventasVIP++;
        }
        actualizaTabla();
    }

    @Override
    public void cancelar() {// al cancelar la venta se cancela la funcion, por ello llamo al cancelar del super y ademas dejo a 0 las localidades, y decuelvo el dinero de las entradas
        super.cancelar();
        localidades = 0;
        localidadesVIP = 0;
        int total = ventas + ventasVIP;
        System.out.println("Se devolvera el dinero de " + total + " entradas, entre las que se encuentran las VIP y las normales, en un plazo de 15 dias habiles");
    }

    public int getLocalidades() {
        return localidades;
    }

    public void setLocalidades(int localidades) {
        this.localidades = localidades;
        actualizaTabla();
    }

    public int getLocalidadesVIP() {
        return localidadesVIP;
    }

    public void setLocalidadesVIP(int localidadesVIP) {
        this.localidadesVIP = localidadesVIP;
        actualizaTabla();
    }

    public int getVentas() {
        return ventas;
    }

    public void setVentas(int ventas) {
        this.ventas = ventas;
        actualizaTabla();
    }

    public int getVentasVIP() {
        return ventasVIP;
    }

    public void setVentasVIP(int ventas) {
        this.ventasVIP = ventas;
        actualizaTabla();
    }

    public Fecha getFechaInicio() {
        return fechaInicio;
    }

    private void setFechaInicio(Fecha fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    @Override
    public String toString() {
        String s;
        if (localidades == 0) {
            s = "Se han vendido todas las entradas para la " + super.toString();
        } else {
            s = "Se han vendido " + ventas + " entradas para la " + super.toString();
        }
        return s;
    }

    @Override
    public boolean equals(Object o) {
        Taquilla f = (Taquilla) o;
        return (fechaInicio == f.fechaInicio && localidades == f.localidades && ventas == f.ventas);
    }

    @Override
    public String descripcion() {
        String s;
        s = "Esta clase se encarga de vender las entradas y contavilizar cuantas entradas a vendido";
        return s;
    }

    public void actualizaTabla() {// actualiza el atributo ventastotales cada vez que vendemos una entrada nueva
        ventasTotales[0] = localidades;
        ventasTotales[1] = ventas;
        ventasTotales[2] = localidadesVIP;
        ventasTotales[3] = ventasVIP;
    }

    public void imprimeTabla() {// imprimimos la tabla que contiene el registro de ventas y localidades disponibles
        int i = 0;
        System.out.println("LOCALIDADES NORMALES         VENTAS NORMALES            LOCALIDADESVIP                     VENTASVIP");
        while (i < ventasTotales.length) {
            System.out.print(ventasTotales[i] + "\t\t\t\t");
            i++;
        }
        System.out.println("");
    }
}
