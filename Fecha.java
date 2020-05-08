
package epd.evaluable;

import java.util.*;

public class Fecha {

    private int dia;
    private int mes;
    private int anyo;
    private int hora;
    private int minutos;

    public Fecha(int dia, int mes, int anyo, int hora, int minutos) {
        setAnyo(anyo);
        setMes(mes);
        setDia(dia);
        setHora(hora);
        setMinutos(minutos);
    }
    
   
    
    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        if (dia < 1) {
            System.out.println("ERROR: El dia debe de ser mayor o igual a 1");
            this.dia = 1;
        } else {
            this.dia = dia;
            switch (mes) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    if (dia > 31) {
                        System.out.println("ERROR: El dia no puede ser mayor que 31");
                        this.dia = 31;
                    }
                    break;
                case 4:
                case 6:
                case 9:
                case 11:
                    if (dia > 30) {
                        System.out.println("ERROR: El día no puede ser mayor que 30");
                        this.dia = 30;
                    }
                    break;
                case 2:
                    if ((getAnyo() % 4 == 0 && getAnyo() % 100 != 0) || getAnyo() % 400 == 0) {
                        if (dia > 29) {
                            System.out.println("ERROR: El dia no puede ser mayor que 29");
                            this.dia = 29;
                        }
                    } else if (dia > 28) {
                        System.out.println("ERROR: El dia no puede ser mayor que 28");
                        this.dia = 28;
                    }
                    break;
                default:
                    break;
            }
        }

    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        if (mes >= 1 && mes <= 12) {
            this.mes = mes;
        } else {
            System.out.println("ERROR: El mes debe estar entre 1 y 12.");
        }
    }

    public int getAnyo() {
        return anyo;
    }

    public void setAnyo(int anyo) {
        if (anyo < 1900) {
            System.out.println("ERROR: El anyo no puede ser anterior a 1900");
        } else {
            this.anyo = anyo;
        }
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        if (hora < 0 || hora > 23) {
            System.out.println("La hora no puede ser menor que 0 ni mayor que 23");
        } else {
            this.hora = hora;
        }
    }

    public int getMinutos() {
        return minutos;
    }

    public void setMinutos(int minutos) {
        if (minutos < 0 || minutos > 59) {
            System.out.println("Los minutos no pueden ser menores que 0 ni mayores que 59");
        } else {
            this.minutos = minutos;
        }
    }

    public String toString() {
        String s = dia + "/" + mes + "/" + anyo + " ";
        if (minutos < 10) {
            s += hora + ":0" + minutos;
        } else {
            s += hora + ":" + minutos;
        }
        return s;
    }

    public boolean equals(Object o) {
        Fecha f = (Fecha) o;
        return dia == f.dia && mes == f.mes && anyo == f.anyo & hora == f.hora && minutos == f.minutos;
    }

    public static Fecha ahora() {
        Calendar cal = new GregorianCalendar();
        int hora = cal.get(Calendar.HOUR_OF_DAY);
        int min = cal.get(Calendar.MINUTE);
        int dia = cal.get(Calendar.DAY_OF_MONTH);
        int mes = cal.get(Calendar.MONTH) + 1;
        int anyo = cal.get(Calendar.YEAR);
        return new Fecha(dia, mes, anyo, hora, min);
    }
}
