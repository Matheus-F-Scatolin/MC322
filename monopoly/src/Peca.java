/*
 * Peca.java
 * 
 * Última modificação: 03/07/2024 
 */

/**
 *  Esta classe contém a estrutura de implementação de uma Peca 
 */

import java.io.Serializable;

public class Peca implements Serializable{
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
     * Essa função move a peça do jogador no tabuleiro.
     * @param deslocamento: número de casas que a peça deve se mover
     * @param n_total_posicoes: número total de posições do tabuleiro
     * @param jogador: jogador que está movendo a peça
     */
    public void mover(int deslocamento, Jogador jogador, Tabuleiro tabuleiro){
        // Alterar o multiplicador do aluguel dos serviços públicos
        ServicoPublico.setMultiplicador(deslocamento);

        // Se o jogador completar uma volta, adicionar 350 ao dinheiro
        if (deslocamento + this.posicao >= tabuleiro.getPosicoes().size()){
            jogador.setDinheiro(jogador.getDinheiro() + 350);
            Main.imprimirVoltaCompleta(jogador);
        }
        
        // Atualizar a posição da peça
        this.posicao = (this.posicao + deslocamento)% tabuleiro.getPosicoes().size();
    }

    /*
     * Essa função retorna uma string com os dados da peça no formato:
     * "A peça de cor [cor] está na posição [posicao] do tabuleiro."
     * @return: string com os dados da peça
     */
    public String toString(){
        return "A peça de cor " + this.cor + " está na posição " + this.posicao + " do tabuleiro.";
    }
}