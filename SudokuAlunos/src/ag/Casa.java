/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ag;

public class Casa {
    
    private int numero;
    private boolean bloqueada;
    private boolean errada = false;
    
    public Casa(int numero, boolean bloqueada){
        this.numero = numero;
        this.bloqueada = bloqueada;
    }
    
    public Casa(Casa casa){
        numero = casa.numero;
        bloqueada = casa.bloqueada;
    }
    
    public boolean isBloqueada(){
        return bloqueada;
    }
    
    public void setErrada(boolean errada){
        this.errada = errada;
    }
    
    public boolean isErrada(){
        return errada;
    }
    
    public int getNumero(){
        return numero;
    }

}
