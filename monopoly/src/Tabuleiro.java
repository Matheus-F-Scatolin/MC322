/*
 * Tabuleiro.java
 * 
 * Última modificação: 03/04/2024 
 */

/**
 *  Esta classe contém a estrutura de implementação de um Tabuleiro 
 */

public class Tabuleiro {
    private Jogador jogadores[];
    private Propriedade propriedades[];

    // Construtor do tabuleiro
    public Tabuleiro() {
        // Inicializando o vetor de jogadores e propriedades
        // O tabuleiro possui 4 jogadores e 40 propriedades
        this.jogadores = new Jogador[4];
        this.propriedades = new Propriedade[40];
    }

    // Métodos

    /*
     * Essa função adiciona um jogador ao tabuleiro.
     * @param jogador: o jogador a ser adicionado
     * @return: true se o jogador foi adicionado com sucesso, false caso contrário
     */
    public boolean addJogador(Jogador jogador) {
        for (int i = 0; i < 4; i++) {
            if (jogadores[i] == null) {
                jogadores[i] = jogador;
                return true;
            }
        }
        return false;
    }

    /*
     * Essa função remove um jogador do tabuleiro.
     * @param idDoJogador: o id do jogador a ser removido
     * @return: true se o jogador foi removido com sucesso, false caso contrário
     */
    public boolean removeJogador(int idDoJogador) {
        for (int i = 0; i < 4; i++) {
            if (jogadores[i] != null && jogadores[i].getId() == idDoJogador) {
                jogadores[i] = null;
                return true;
            }
        }
        return false;
    }

    /*
     * Essa função adiciona uma propriedade ao tabuleiro.
     * @param propriedade: a propriedade a ser adicionada
     * @return: true se a propriedade foi adicionada com sucesso, false caso contrário
     */
    public boolean addPropriedade(Propriedade propriedade) {
        for (int i = 0; i < 40; i++) {
            if (propriedades[i] == null) {
                propriedades[i] = propriedade;
                return true;
            }
        }
        return false;
    }

    /*
     * Essa função remove uma propriedade do tabuleiro.
     * @param idDaPropriedade: o id da propriedade a ser removida
     * @return: true se a propriedade foi removida com sucesso, false caso contrário
     */
    public boolean removePropriedade(int idDaPropriedade) {
        for (int i = 0; i < 40; i++) {
            if (propriedades[i] != null && propriedades[i].getId() == idDaPropriedade) {
                propriedades[i] = null;
                return true;
            }
        }
        return false;
    }
}
