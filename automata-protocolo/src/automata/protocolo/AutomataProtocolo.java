package automata.protocolo;

import java.util.ArrayList;

public class AutomataProtocolo {
    public ArrayList<String> historia = new ArrayList<>();
    private Ack automata_paridad;
    private ArchivosProtocolo admin_archivos;
    private ArchivosProtocolo admin_historia;
    private String palabra;
    private String palabra_historia="";
    private ArrayList<String> lineas_leidas;
    private ArrayList<String> historia_ack;
    private int estado;
    private boolean estado_paridad;
    public AutomataProtocolo(){
        automata_paridad = new Ack();
        admin_historia = new ArchivosProtocolo();
        admin_historia.crear_escritor("historia_ack.txt");
    }
    public int recibirProtocolo(float is_encendido){
        historia.clear();
        //No se reciben datos
        if(is_encendido < 0.5){
            estado = 0;
            return estado;
        }else{
            try{
            //Escritura de datos, modo aleatorio
            estado = 1;
            historia.add("q0");
            admin_archivos = new ArchivosProtocolo();
            admin_archivos.crear_escritor("data.txt");
            for(int i=0; i<50;i++){
                palabra = crearDatos();
                admin_archivos.setElemento_escrito(palabra);  
            }
            admin_archivos.guardar_archivo();
            try {
                //1 segundo
                    Thread.sleep(1000);
                    estado=1;
                    historia.add("q1");
                } catch(InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
                //Lector
                admin_archivos.crear_lector("data.txt");
                admin_archivos.leer_elementos();
                lineas_leidas = admin_archivos.getLineas_leidas();
                }catch(Exception e){
                estado = 0;
                System.out.println("Error: "+e.toString());
            }
                            
            //Escritor paridad
            int aux=0;
            admin_archivos = new ArchivosProtocolo();
            admin_archivos.crear_escritor("output.txt");
            automata_paridad = new Ack();
            for(String palabra_leida : lineas_leidas){
                estado_paridad = automata_paridad.calcularParidad(palabra_leida);
                if(estado_paridad == true){
                    aux++;
                    admin_archivos.setElemento_escrito(palabra_leida);
                }
                historia_ack = automata_paridad.historia;
                for(String estado_ack:historia_ack){
                    palabra_historia+=estado_ack;
                }
                admin_historia.setElemento_escrito(palabra_historia);
                historia_ack.clear();
                palabra_historia="";
            }
            admin_archivos.guardar_archivo();
            historia.add("q2");
        }
        return estado;
    }
    public String crearDatos(){
        String data_aleatoria="";
        float caracter;
        for(int i=0; i<16;i++){
            caracter = (float) Math.random();
            if(caracter < 0.5){
                data_aleatoria += "0";
            }else{
                data_aleatoria += "1";
            }
        }
        return data_aleatoria;
    }
    public void guardarHistoria(){
        admin_historia.guardar_archivo();
    }
}