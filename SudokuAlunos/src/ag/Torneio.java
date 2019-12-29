package ag;

public class Torneio extends MetodoSeleccao{
  private int tamanho;

  public Torneio(){
    this(2);
  }

  public Torneio(int tamanho){
    this.tamanho = tamanho;
  }

  public void executar(Populacao populacaoOrigem, Populacao populacaoResultante){
    for(int i = 0; i < populacaoOrigem.getTamanho(); i++)
      populacaoResultante.setIndividuo(torneio(populacaoOrigem), i);
  }

  private Individuo torneio(Populacao populacao){
    int aux, melhor = AlgoritmoGenetico.aleatorio.nextInt(populacao.getTamanho());

    for(int i = 1; i < tamanho; i++){
      aux = AlgoritmoGenetico.aleatorio.nextInt(populacao.getTamanho());
      if (populacao.getIndividuo(aux).getFitness() < populacao.getIndividuo(melhor).getFitness())
        melhor = aux;
    }
    return (Individuo) populacao.getIndividuo(melhor).clone();
  }


}