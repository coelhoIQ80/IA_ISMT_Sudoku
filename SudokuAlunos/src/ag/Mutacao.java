package ag;

public class Mutacao extends OperadorGenetico{

  public Mutacao(double probabilidade){
    super(probabilidade);
  }

  public void executar(Individuo individuo){
    //A muta��o altera um alelo (valor de um gene) de acordo com a probabilidade de muta��o
    for(int g = 0; g < individuo.getNumGenes(); g++){
        for(int j = 0; j < individuo.getNumGenes(); j++){
      //Gerar o valor aleat�rio, se for inferior � probabilidade de muta��o, altera o valor        
          if (!individuo.getGene(g, j).isBloqueada() && AlgoritmoGenetico.aleatorio.nextDouble() <= probabilidade) {
              int deslocamento = AlgoritmoGenetico.aleatorio.nextInt(9);
              if(individuo.getGene(g, (j+deslocamento) % individuo.getNumGenes()).isBloqueada()){
                  break;
              }
            Casa aux = individuo.getGene(g,j);
            individuo.setGene(g,j,individuo.getGene(g,(j+deslocamento) % individuo.getNumGenes()));
            individuo.setGene(g,(j+deslocamento) % individuo.getNumGenes(),aux);
          }
        }
    }
  }
}
