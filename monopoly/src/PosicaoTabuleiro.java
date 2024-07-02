public class PosicaoTabuleiro {
    private int posicao;
    Propriedade propriedade;
    boolean posicaoInicial;

    /**
     * Construtor da classe PosicaoTabuleiro
     * OBS: Se propriedade = null, isso indica que o jogador deve pegar uma carta de sorte ou revés.
     * @param posicao posição no tabuleiro
     * @param propriedade propriedade na posição.
     * @param posicaoInicial indica se a posição é a posição inicial. 
     */
    public PosicaoTabuleiro(int posicao, Propriedade propriedade, boolean posicaoInicial) {
        this.posicao = posicao;
        this.propriedade = propriedade;
        this.posicaoInicial = posicaoInicial;
    }

    // Setters e Getters
    // Posicao: posição no tabuleiro
    public int getPosicao() {
        return this.posicao;
    }
    public void setPosicao(int posicao) {
        this.posicao = posicao;
    }

    // Propriedade: propriedade na posição
    public Propriedade getPropriedade() {
        return this.propriedade;
    }
    public void setPropriedade(Propriedade propriedade) {
        this.propriedade = propriedade;
    }

    // PosicaoInicial: indica se a posição é a posição inicial
    public boolean getPosicaoInicial() {
        return this.posicaoInicial;
    }
    public void setPosicaoInicial(boolean posicaoInicial) {
        this.posicaoInicial = posicaoInicial;
    }
}
