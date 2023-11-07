import java.io.File;
import java.io.FileWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author yulia
 */
public class Conserjeria {            
    
    public static void main(String[] args) {                                
        
        try{
        File archivo1 = new File("registro.txt");       
        FileWriter escribir1 = new FileWriter(archivo1, true);

        escribir1.write("*** REGISTRO DE PERSONAS ***");
        escribir1.write("\r\n");
        escribir1.close();
        }catch (Exception e) {
            System.out.println("Error al escribir");
        }
                        
        //definiendo obj y variables
        Scanner sc = new Scanner(System.in);
        Scanner nom = new Scanner(System.in);
        Scanner run = new Scanner(System.in);        

        int cantidad;
        int indice; 
        int varDepto;
        String varNombre;
        String varRut;
        String menu1;
            
        ArrayList<String> nombre = new ArrayList<String>();
        ArrayList<String> rut = new ArrayList<String>();
        ArrayList<Integer> depto = new ArrayList<Integer>();
        //ejecutar menu principal        
        while(true){                         
            
            DateFormat frmt= new SimpleDateFormat("dd/M/y");
            DateFormat time= new SimpleDateFormat("HH:mm");
            Date fecha = new Date();
            
            System.out.println("*** MENU INICIO CONSERJERIA ***");
            System.out.println("a)Ingreso personas");
            System.out.println("b)Salida de personas");
            System.out.println("x)Cerrar programa");
            System.out.print(">");
            menu1 = nom.nextLine();
            
            indice = 0;
            cantidad = 0;
            if(menu1.equals("a")){
                System.out.println("");
                System.out.println("***LIBRO DE REGISTRO (CONSERJERIA)***");
                System.out.println("¿Cuantas personas van a entrar?");
                System.out.print(">");
                cantidad = sc.nextInt();                 

                System.out.println("-----------------------------------");
                System.out.println("Ingrese el Departamento a visitar: ");
                varDepto = sc.nextInt();

                while(indice < cantidad){
                    System.out.println("----------------");
                    System.out.println("Ingrese nombre: ");                    
                    varNombre = nom.nextLine();
                    nombre.add(varNombre);
                    System.out.println("Ingrese rut: ");                    
                    varRut = nom.nextLine();
                    rut.add(varRut);

                    depto.add(varDepto);
                    System.out.println("");
                    //-------------------- reportes
                    try {
                        File registro = new File("registro.txt");
                        File csv = new File("registro.csv");
                        FileWriter escribir = new FileWriter(registro, true);
                        FileWriter escribirCsv = new FileWriter(csv, true);

                        escribir.write("Nombre: "+varNombre+" - Rut: "+varRut+" - Depto: "+varDepto+
                                " - Registro: Ingreso - Fecha: "+frmt.format(fecha)+" - Hora: "+time.format(fecha));
                        escribir.write("\r\n");

                        escribirCsv.write(varNombre+","+varRut+","+varDepto+
                                ",Ingreso,"+frmt.format(fecha)+","+time.format(fecha));
                        escribirCsv.write("\r\n");                                        
                        //Cerramos la conexion
                        escribir.close();
                        escribirCsv.close();
                    } 
                    catch (Exception e) {
                        System.out.println("Error al escribir");
                    }                     
                    //------------------------------
                    indice++;
                }                                   
            
            }else if(menu1.equals("b")){
                //accion2
                String rutSalida;
                System.out.println("-----");
                System.out.println("RUT: ");
                rutSalida = run.nextLine();
                System.out.println("");
                for(int in = 0; in < rut.size();in++){
                    if(rut.get(in).equals(rutSalida)){                        
                        try {
                            File registro = new File("registro.txt");
                            File csv = new File("registro.csv");
                            FileWriter escribir = new FileWriter(registro, true);
                            FileWriter escribirCsv = new FileWriter(csv, true);

                            escribir.write("Nombre: "+nombre.get(in)+" - Rut: "+rut.get(in)+" - Depto: "+depto.get(in)+
                                    " - Registro: Salida - Fecha: "+frmt.format(fecha)+" - Hora: "+time.format(fecha));
                            escribir.write("\r\n");

                            escribirCsv.write(nombre.get(in)+","+rut.get(in)+","+depto.get(in)+
                                    ",Salida,"+frmt.format(fecha)+","+time.format(fecha));
                            escribirCsv.write("\r\n");

                            escribir.close();
                            escribirCsv.close();
                        }
                        catch (Exception e) {
                            System.out.println("Error al escribir");
                        } 
                        
                    }
                }
            
            }else if(menu1.equals("x")){
                break;
            }else{
                System.out.println("");
                System.out.println("ERROR DE DATO, vuelva a intentar.");
                System.out.println("");
            }
        }
        
        
    }

}
