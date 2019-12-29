/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package principal;

import ag.Casa;
import ag.Individuo;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

public class SudokuPanel extends JPanel{
    
    private Individuo melhorSolucao;
    private static final int QUADRICULA = 30;
    
    public SudokuPanel(){
        super();
        setPreferredSize(new Dimension(200,300));
    }
    
    public void setMelhorSolucao(Individuo melhorSolucao){
        this.melhorSolucao = melhorSolucao;
        repaint();
    }
    
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        if(melhorSolucao == null)
            return;
        g.setColor(Color.WHITE);
        for(int i = 0; i < 3; i++){
            for( int j = 0; j < 3; j++){
                if((j + i) % 2 == 0){
                    g.fillRect(i * QUADRICULA * 3, j * QUADRICULA * 3, QUADRICULA * 3, QUADRICULA * 3);
                }
            }
        }
        for(int i = 0; i < melhorSolucao.getNumGenes(); i++){
            for(int j = 0; j < melhorSolucao.getNumGenes(); j++){
                Casa c = melhorSolucao.getGene(j, i);
                g.setColor(c.isErrada()?Color.RED:c.isBloqueada()?Color.BLACK:Color.BLUE);
                g.drawString("" + c.getNumero(), 10 + i * QUADRICULA, 20 + j * QUADRICULA);
                g.setColor(Color.BLACK);
                g.drawRect(i * QUADRICULA, j * QUADRICULA, QUADRICULA, QUADRICULA);
            }
        }        
    }
    

}
