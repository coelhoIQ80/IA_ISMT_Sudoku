package ag;

import java.util.Random;

public class Individuo {
    
  protected Casa[][] cromossoma;
  protected double fitness;
  protected double acumulado;

  public Individuo() {
      cromossoma = new Casa[9][9];
          
      for(int i = 0; i < 9; i++){
        for(int j = 0; j < 9; j++){
            int aux = AlgoritmoGenetico.aleatorio.nextInt(9) + 1;
            this.cromossoma[i][j] = new Casa(aux,false);
            for(int k = 0; k < j; k++){
                if(this.cromossoma[i][k].getNumero() == aux){
                    j--;
                    break;
                }
            }
        }
      }
      fitness = 0;
      acumulado = 0;    
  }

  public Individuo(Casa[][] cromossoma, double fitness, double acumulado) {
    this.cromossoma = new Casa[9][9];    
    //Gerar o individuo com o cromossoma fornecido
    for(int i = 0; i < 9; i++){
        for(int j = 0; j < 9; j++){
            this.cromossoma[i][j] = new Casa(cromossoma[i][j]);
        }
    }
    //O m�rito/fitness j� foi calculado
    this.fitness = fitness;
    this.acumulado = acumulado;
  }

  public double calculaFitness() {
    //Normalizar a fitness/m�rito
    //long x = representacaoDecimal();
      
      fitness = 0;
      
      for(int i = 0; i < 9; i++){
          for(int j = 0; j < 9; j++){
              for(int k = j + 1; k < 9; k++){
                  if(cromossoma[i][j].getNumero() == cromossoma[i][k].getNumero()){
                      cromossoma[i][j].setErrada(true);
                      cromossoma[i][k].setErrada(true);
                      fitness++;
                  }
                  if(cromossoma[j][i].getNumero() == cromossoma[k][i].getNumero()){
                      cromossoma[j][i].setErrada(true);
                      cromossoma[k][i].setErrada(true);
                      fitness++;
                  }
              }
          }
      }
      
      for(int a = 0; a < 3; a++){
          for(int b = 0; b < 3; b++){
              for(int i = a*3; i < (a+1)*3; i++){
                  for(int j = b * 3; j < (b + 1)*3; j++){
                      for(int k = a * 3; k < (a + 1)*3; k++){
                          for (int l = b * 3; l < (b + 1) * 3; l++){
                              if(i != k && j != l && cromossoma[i][j].getNumero() == cromossoma[k][l].getNumero()){
                                  cromossoma[i][j].setErrada(true);
                                  cromossoma[k][l].setErrada(true);
                                  fitness++;
                              }
                          }
                      }
                  }
              }
          }
      }

    return fitness;
  }

  public double getFitness() {
    return fitness;
  }

  public void setAcumulado(double acumulado) {
    //Utilizado nos m�todos de selec��o
    this.acumulado = acumulado;
  }

  public double getAcumulado() {
    return acumulado;
  }

  public int getNumGenes() {
    return cromossoma.length;
  }

  public Casa getGene(int x, int y) {
    return cromossoma[x][y];
  }

  public void setGene(int x, int y, Casa casa) {
    //Alterar o valor (designado alelo) de um gene
    cromossoma[x][y] = new Casa(casa);
  }

  public String toString() {
    StringBuffer sb = new StringBuffer();
    
    for (int i = 0; i < 9; i++){
        if(i % 3 == 0){
            sb.append("------------\n");
        }
        for(int j = 0; j < 9; j++){
            if(j % 3 == 0){
                sb.append("|");
            }
            sb.append(cromossoma[i][j].getNumero());            
        }
        sb.append("\n");
    }
    sb.append("fitness: " + fitness + " acumulado: " + acumulado);
    return sb.toString();
  }

  public Object clone() {
    return new Individuo(cromossoma, fitness, acumulado);
  }  

}
