/*
 * Peca.java
 * 
 * Última modificação: 20/03/2024 
 */

/**
 *  Esta classe contém a estrutura de implementação de uma Peca 
 */

public class Peca {
    // Atributos da peça
    private String cor;
    private int posicao;

    // Construtor da peça
    public Peca (String cor, int posicao) {
        this.cor = cor;
        this.posicao = posicao;
    }

    // Getters e Setter

    // Cor: cor da peça
    public String getCor(){
        return this.cor;
    }
    public void setCor(String cor){
        this.cor = cor;
    }

    // Posicao: posição da peça no tabuleiro
    public int getPosicao(){
        return this.posicao;
    }
    public void setPosicao(int posicao){
        this.posicao = posicao;
    }

    // Métodos

    /*
     * Essa função retorna uma string com os dados da peça no formato:
     * "A peça de cor [cor] está na posição [posicao] do tabuleiro."
     * @return: string com os dados da peça
     */
    public String toString(){
        return "A peça de cor " + this.cor + " está na posição " + this.posicao + " do tabuleiro.";
    }
}