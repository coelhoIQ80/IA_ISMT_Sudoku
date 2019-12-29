package ag;

public class Populacao {

  private Individuo[] individuos;
  private double total;
  private double media;

  public Populacao(int tamanhoPopulacao){
    individuos = new Individuo[tamanhoPopulacao];
  }

  public Populacao(int tamanhoPopulacao, int tamanhoIndividuos){
    individuos = new Individuo[tamanhoPopulacao];
    for(int i = 0; i < tamanhoPopulacao; i++)
      individuos[i] = new Individuo();
  }

  public void setIndividuo(Individuo individuo, int indice){
    individuos[indice] = individuo;
  }

  public Individuo getIndividuo(int indice){
    return individuos[indice];
  }

  public int getTamanho(){
    return individuos.length;
  }

  public String toString(){
    StringBuffer sb = new StringBuffer();
    for(int g = 0; g < individuos.length; g++)
      sb.append(individuos[g] + "\n");

    return sb.toString();
  }

}