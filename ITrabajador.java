package epd.evaluable;

public interface ITrabajador extends IPersona {

    public Fecha getHorarioEntrada();

    public void setHorarioEntrada(Fecha horarioEntrada);

    public Fecha getHorarioSalida();

    public void setHorarioSalida(Fecha horarioSalida);

    public double getSueldoh();

    public void setSueldoh(double sueldoh);

    public double getSueldo();

    public void setSueldo(double sueldo);

    public void generarSueldo();

    public void subirSueldo(double sueldo);
}
