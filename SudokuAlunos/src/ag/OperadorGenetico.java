package ag;

public class OperadorGenetico {
  protected double probabilidade;

  public OperadorGenetico(double probabilidade){
    //Probabilidade de o operador ser aplicado a um individuo/gene
    this.probabilidade = probabilidade;
  }

  public double getProbabilidade(){
    return probabilidade;
  }
}
