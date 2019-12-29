package ag;

public class RecombinacaoUmCorte extends Recombinacao{

  public RecombinacaoUmCorte(double probabilidade){
    super(probabilidade);
  }

  public void executar(Individuo individuo1, Individuo individuo2){
    int j, pontoCorte = AlgoritmoGenetico.aleatorio.nextInt(individuo1.getNumGenes());
    Individuo auxInd1 = (Individuo) individuo1.clone();
    Individuo auxInd2 = (Individuo) individuo2.clone();
    
    for(int k = 0; k < individuo1.getNumGenes(); k++){
        for(int g = pontoCorte; g < individuo1.getNumGenes(); g++){              

          for(int i = 0; i < individuo1.getNumGenes(); i++){          
              for(j = 0; j < g; j++){
                  if(auxInd2.getGene(k,i).getNumero() == individuo1.getGene(k,j).getNumero())
                      break;
              }
              if(j == g){
                  individuo1.setGene(k,g, auxInd2.getGene(k,i));
                  break;
              }
          }
          for(int i = 0; i < individuo1.getNumGenes(); i++){
              for(j = 0; j < g; j++){
                  if(auxInd1.getGene(k,i).getNumero() == individuo2.getGene(k,j).getNumero())
                      break;
              }
              if(j == g){
                  individuo2.setGene(k,g, auxInd1.getGene(k,i));
                  break;
              }
          }
        }
    }
  }
}