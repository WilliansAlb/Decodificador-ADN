/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decodificador.adn;

/**
 *
 * @author yelbetto
 */
public class Detectar implements Runnable{

    private Interfaz usando;
    private boolean corriendo = true;
    private int tiempo = 1000;
    
    @Override
    public void run() {
        while (corriendo) {
            try {
                usando.getJl_secuencia_mayor().setText("Esperando");
                Thread.sleep(getTiempo());
                corriendo = false;
                usando.verificar();
                
            } catch (InterruptedException e) {
                corriendo = false;
            }
        }
    }

    public boolean isCorriendo() {
        return corriendo;
    }

    public void setCorriendo(boolean corriendo) {
        this.corriendo = corriendo;
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    public Interfaz getUsando() {
        return usando;
    }

    public void setUsando(Interfaz usando) {
        this.usando = usando;
    }
    
}
