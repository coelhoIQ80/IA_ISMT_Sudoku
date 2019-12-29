/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package principal;

import ag.AlgoritmoGenetico;
import ag.Mutacao;
import ag.RecombinacaoUmCorte;
import ag.Torneio;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FramePrincipal extends JFrame{
    
    private AlgoritmoGenetico ag;
    private SudokuPanel sudokuPanel;
    
    public FramePrincipal(){
        
    	this.setTitle("Este e o titulo!!!!!!");
    	//super("Titulo - Sudoku Solver");
        
        sudokuPanel = new SudokuPanel();        
        ag = new AlgoritmoGenetico(1, 200, 5, 120, new Torneio(5),
                                                 new RecombinacaoUmCorte(0.7),
                                                 new Mutacao(0.01),sudokuPanel);        
        
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(sudokuPanel,BorderLayout.CENTER);
        
        JPanel rightPanel = new JPanel(new FlowLayout());
        getContentPane().add(rightPanel,BorderLayout.EAST);
        
        JButton solveButton = new JButton("Resolver");
        rightPanel.add(solveButton);
        
        solveButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                Thread t = new Thread(){
                    public void run(){
                        ag.executar();                        
                    }
                };
                t.start();
                                
            }
        });
        
    }
    
    

}
