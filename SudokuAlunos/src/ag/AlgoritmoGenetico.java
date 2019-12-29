package ag;

import java.util.Random;
import principal.SudokuPanel;

public class AlgoritmoGenetico {
  public static Random aleatorio;
  public int tamanhoPopulacao;
  public int tamanhoIndividuos;
  public int maximoGeracoes;
  private Populacao populacaoActual;
  private Populacao proximaPopulacao;
  private MetodoSeleccao metodoSeleccao;
  private Recombinacao operadorRecombinacao;
  private Mutacao operadorMutacao;
  private int geracao;

  //Estatisticas
  Individuo melhorIndividuoGeracao;
  double mediaGeracao;
  Individuo melhorIndividuoRun;
  int geracaoMelhorIndividuoRun;
  private SudokuPanel sudokuPanel;

  public AlgoritmoGenetico(long seed, int tamanhoPopulacao, int tamanhoIndividuos,
                           int maximoGeracoes, MetodoSeleccao metodoSeleccao,
                           Recombinacao operadorRecombinacao, Mutacao operadorMutacao, SudokuPanel sudokuPanel){

    aleatorio = new Random(seed);
    this.tamanhoPopulacao = tamanhoPopulacao;
    this.tamanhoIndividuos = tamanhoIndividuos;
    this.maximoGeracoes = maximoGeracoes;
    this.metodoSeleccao = metodoSeleccao;
    this.operadorRecombinacao = operadorRecombinacao;
    this.operadorMutacao = operadorMutacao;
    this.sudokuPanel = sudokuPanel;
  }

  public Individuo executar(){

      // Em FALTA
	  System.out.println("Para estar funcional tem de implementar o c�digo do m�todo executar() da classe AlgoritmoGenetico.");

   return null;
  }

  private void avaliar(Populacao populacao){
    double somaFitness = 0;

    //Interessa-nos saber o melhor individuo em cada instante, por representar a melhor solu��o encontrada
    populacao.getIndividuo(0).calculaFitness();
    melhorIndividuoGeracao = (Individuo) populacao.getIndividuo(0).clone();

    for(int i = 0; i < tamanhoPopulacao; i++){
      //Calcular o m�rito (qualidade ou fitness) do individuo para resolver o problema
      somaFitness += populacao.getIndividuo(i).calculaFitness();
      if(melhorIndividuoGeracao.getFitness() > populacao.getIndividuo(i).getFitness())
        melhorIndividuoGeracao = (Individuo) populacao.getIndividuo(i).clone();
    }
    //media de toda a populacao
    mediaGeracao = somaFitness / (double) tamanhoPopulacao;

   //Melhoramos a solucao conhecida?
    if(geracao == 0 || melhorIndividuoRun.getFitness() > melhorIndividuoGeracao.getFitness()){
      melhorIndividuoRun = (Individuo) melhorIndividuoGeracao.clone();
      geracaoMelhorIndividuoRun = geracao;
    }
    this.mostra();
  }

  private void seleccao(Populacao populacaoActual, Populacao proximaPopulacao){
    //Evocar o metodo indicado no construtor
    metodoSeleccao.executar(populacaoActual, proximaPopulacao);
  }

  private boolean criterioParagem(Populacao populacao, int geracaoActual){
    //Pode-se adicionar outros criterios de paragem, como atingir a solucao aceitavel para o problema
      //geracaoActual == maximoGeracoes || 
    if(melhorIndividuoRun.fitness == 0)
      return true;
    return false;
  }

  void recombinacao(Populacao populacao){
    for(int i = 0; i < tamanhoPopulacao; i += 2)
      //Aplicar a recombina��o se foi escolhido aleatoriamente
      if(aleatorio.nextDouble() < operadorRecombinacao.getProbabilidade())
        operadorRecombinacao.executar(populacao.getIndividuo(i), populacao.getIndividuo(i + 1));
  }

  void mutacao(Populacao populacao){
   //Aplicar a muta��o a todos individuos (probabilidade de muta��o ao nivel do gene)
    for(int i = 0; i < populacao.getTamanho(); i++)
      operadorMutacao.executar(populacao.getIndividuo(i));
  }

  public Populacao criarNovaPopulacao(Populacao populacaoActual, Populacao proximaPopulacao){
    Populacao aux = proximaPopulacao;
    proximaPopulacao = populacaoActual;
    return aux;
  }

  private void mostra(){
//        try {
                  

//    System.out.println("Melhor individuo da geracao actual: " + melhorIndividuoGeracao);
//    System.out.println("Media da geracao actual: " + mediaGeracao);
//
//    System.out.println("Melhor individuo do run (geracao: " + geracaoMelhorIndividuoRun + ")");
//    System.out.println(melhorIndividuoRun);
//    System.out.println("---------------------------------------");
            //StandardInput.readString();
            melhorIndividuoRun.calculaFitness();
            sudokuPanel.setMelhorSolucao(melhorIndividuoRun);
//            Thread.sleep(100);
//        } catch (InterruptedException ex) {
//            Logger.getLogger(AlgoritmoGenetico.class.getName()).log(Level.SEVERE, null, ex);
//        }
  }  

}
