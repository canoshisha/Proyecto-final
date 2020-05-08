/* El programa consiste en una clase padre llamada funcion de la que salen dos clases hijas, una llamada taquilla que se encarga de vender entradas para la funcion y otra asistente que
es la persona que asiste al teatro al comprar la entrada, esta ultima clase tambien tiene implementada una interfaz Ipersona que tambien esta implementada en la clase limpiadora la cual es 
una persona a la que se le da un horario para trabajar y se le contrata por dias no depende de la funcion.
Tambien se ha realizado los arreglos de la clase fecha y se ha utilizado en todas las clases del proyecto, en el unico lugar en el que no se ha utilizado es en la interfaz.
*/

package epd.evaluable;

import poo.io.*;

public class EPDEvaluable {

    public static void main(String[] args){
        String s;
     
        Fecha f = new Fecha(38,11,2020,22,30);//creo un objeto fecha para probar que he solucionado los errores de minutos, hora y dia que habia en el programa entregado
        Fecha Inicio = new Fecha(1,03,2020,10,00);// creo una fella incio para usarlo al crear un objeto taquilla
        Taquilla ta= new Taquilla(Inicio,15,10,"Me rei leon","Gran Teatro Falla",f);// creo un objeto taquilla y uso alguno de sus metodos
        System.out.println(ta.descripcion());//uso al descripcion 
        ta.venderEntrada();// vende una entrada
        System.out.println(ta.getLocalidades());// muestra las localidades que le quedan por vender
        ta.modifcarVenta(10,03,2020,9,00);
        System.out.println(ta.getFechaInicio());
        ta.descripcion();// muestra la descripcion de taquilla      
        ta.venderEntrada();
        ta.venderEntrada();
        ta.venderEntrada();
        ta.venderEntradaVIP();// vendo entrada VIP
        ta.venderEntradaVIP();
        ta.venderEntradaVIP();
        ta.imprimeTabla();
        System.out.println(ta.toString());
        ta.agotar();
        System.out.println(ta.toString());
        ta.cancelar();// el metodo cancelar de esta clase, usa la del super y tambien modifica atributos de su propio objeto
        
        
        
        Asistente as = new Asistente(12,23,41013,2,"30249288-S","Juan","Cintado Gomez",23,"juancingo@gmail.com","Sevilla",f,"Me rei leon","Gran Teatro Falla");// creo un objeto asistente y uso alguno de sus metodos
        System.out.println(as.descripcion());
        as.modificarLocalidad(11,3, 4);
        System.out.println(as.toString());
        as.descripcion();
        s = (String) IO.readLine();// creo un string con la libreria entrgada a los alumnos en la EPD1
        as.setZona(s);// comparo el string utilizado con las constantes de la interfaz IPersona, si es igual a ellas , sin importar las mayusculas, se modificara la zona del asistente sino no se modificara y dira que la zona no existe
        System.out.println(as.getZona());
        as.cancelar();// el metodo cancelar de este objeto es distinto del de la clase padre por ello lo uso aqui
        
        
        Fecha Entrada = new Fecha(1,03,2020,10,50);// nuevo objeto fecha usado en la clase limpiadora
        Limpiadora li = new Limpiadora(2, 20.5,48563,"Materita","Guillermo Martinez",35,"materita@gmail.com","345678-s","Malaga",Entrada,15,10);// realizo un objeto limpiadora y llamo a algunos metodos específicos de esta clase
        System.out.println(li.toString());
        li.modificarHorario(20, 03, 2020, 10, 00, 16, 00);// al modificiar el horario tambien se genera un sueldo diario diferente, ya que depende de las horas que realiza al dia
        System.out.println(li.toString());
        li.modificarHorario(20, 03, 2020, 10, 00, 16, 30);
        System.out.println(li.toString());
        li.subirSueldo(5);
        Limpiadora li2 = new Limpiadora(2, 20.5,48563,"Materita","Guillermo Martinez",35,"materita@gmail.com","345678-s","Malaga",Entrada,15,20);
        System.out.println(li.equals(li2));// comparo las dos limpiadoras, al no ser iguales porque de la anterior he modificado el horario y los dos sueldos, el equals devuelve un false.
        
        
        Plantilla plant= new Plantilla();
        Limpiadora limpiadora1 = new Limpiadora(2, 20.5,48563,"Materita","Guillermo Martinez",35,"materita@gmail.com","345678-s","Malaga",Entrada,16,10);// creo los objetos de la tabla
        Limpiadora limpiadora2 = new Limpiadora(2, 20.5,48563,"Alejandra","Espadiña Martinez",30,"materita@gmail.com","345678-v","Malaga",Entrada,17,10);
        Limpiadora limpiadora3 = new Limpiadora(2, 20.5,48563,"Alejandra","Espadiña Martinez",32,"materita@gmail.com","345679-v","Malaga",Entrada,17,10);
        Limpiadora limpiadora4 = new Limpiadora(2, 20.5,48563,"Juanita","Moreno Martinez",34,"materita@gmail.com","345678-s","Malaga",Entrada,13,10);
        Limpiadora limpiadora5 = new Limpiadora(2, 20.5,48563,"Carla","Herrera Martinez",25,"materita@gmail.com","345678-v","Malaga",Entrada,12,10);
        
        try{
        plant.añadirLimpiadora(limpiadora1);// añadimos una limpiadora a la tabla de plantilla de limpiadoras
        plant.añadirLimpiadora(limpiadora2);// si introdujiese una limpiadora exactamente igual saltaria una excepcion, o si metemos mas de las totales
        plant.imprimeLimpiadora();// imprimo la tabla en orden natural
        plant.añadirLimpiadora(limpiadora3);// añado el objeto a la tabla de plant
        plant.añadirLimpiadora(limpiadora4);
        plant.añadirLimpiadora(limpiadora5);
        plant.imprimeLimpiadora();
        plant.ordenarLimpiadorasCompare();// modifico el orden al orden realizado en la clase compare
        plant.imprimeLimpiadora();//imprimo la tabla
        
        Acomodador acomodador1 = new Acomodador(2, 20.5,48563,"Juan","Hernandez Lopez",35,"materita@gmail.com","345678-s","Malaga",Entrada,16,10,5);
        acomodador1.acompañarAsistente();
        acomodador1.preguntarVIP();// pregunto a los asistente vip si quieren bebidas
        acomodador1.repatirRegalo();// reparte regalos
        acomodador1.obtenerRegalos();// obtiene regalos siempre y cuando sean menos de 12 sino saltaria una excepcion
        acomodador1.repatirRegalo();
        plant.añadirAcomodador(acomodador1);
        Acomodador acomodador2 = new Acomodador(2, 20.5,48563,"Sara","Martinez Gutierrez",33,"materita@gmail.com","345678-s","Malaga",Entrada,16,10,5);
        Acomodador acomodador3 = new Acomodador(2, 20.5,48563,"Esteban","Lopez Villanew",35,"materita@gmail.com","345678-s","Malaga",Entrada,16,10,5);
        plant.añadirAcomodador(acomodador2);
        plant.añadirAcomodador(acomodador3);
        plant.imprimeAcomodador();
        }catch(MiExcepcion ex){
            System.err.println("Excepcion capturada");
            ex.printStackTrace();
        }
        Asistente_VIP asistentevip1 = new Asistente_VIP(12,23,41013,2,"30249288-S","Juan","Cintado Gomez",23,"juancingo@gmail.com","Sevilla",f,"Me rei leon","Gran Teatro Falla");
        asistentevip1.pedirBebidas();// pido una bebida
        asistentevip1.descripcion();// descripcion
        asistentevip1.verActores();// ve a los actores
        System.out.println(asistentevip1.toString());// tostring de la clase
        
        System.out.println(plant.toString());
    }  
}
 

