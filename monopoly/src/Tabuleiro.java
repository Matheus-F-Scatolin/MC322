/*
 * Tabuleiro.java
 * 
 * Última modificação: 29/04/2024 
 */

 import java.util.ArrayList;

 /**
  *  Esta classe contém a estrutura de implementação de um Tabuleiro 
  */
 public class Tabuleiro {
     private ArrayList<Jogador> jogadores;
     private ArrayList<Propriedade> propriedades;
 
     // Construtor do tabuleiro
     public Tabuleiro() {
         // Inicializando o arraylist de jogadores e propriedades
         this.jogadores = new ArrayList<Jogador>();
         this.propriedades = new ArrayList<Propriedade>();
     }

     // Getters
    // Jogadores: lista de jogadores no tabuleiro
    public ArrayList<Jogador> getJogadores() {
        return this.jogadores;
    }

    // Propriedades: lista de propriedades no tabuleiro
    public ArrayList<Propriedade> getPropriedades() {
        return this.propriedades;
    }
 
     // Métodos
 
     /*
      * Essa função adiciona um jogador ao tabuleiro.
      * @param jogador: o jogador a ser adicionado
      * @return: true se o jogador foi adicionado com sucesso, false caso contrário
      */
     public boolean addJogador(Jogador jogador) {
         if (jogadores.add(jogador)) {
             return true;
         }
         return false;
     }
 
     /*
      * Essa função remove um jogador do tabuleiro.
      * @param idDoJogador: o id do jogador a ser removido
      * @return: true se o jogador foi removido com sucesso, false caso contrário
      */
     public boolean removeJogador(int idDoJogador) {
         for (int i = 0; i < jogadores.size(); i++) {
             if (jogadores.get(i).getId() == idDoJogador) {
                 jogadores.remove(i);
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
         if (propriedades.add(propriedade)) {
             return true;
         }
         return false;
     }
 
     /*
      * Essa função remove uma propriedade do tabuleiro.
      * @param idDaPropriedade: o id da propriedade a ser removida
      * @return: true se a propriedade foi removida com sucesso, false caso contrário
      */
     public boolean removePropriedade(int idDaPropriedade) {
         for (int i = 0; i < propriedades.size(); i++) {
             if (propriedades.get(i).getId() == idDaPropriedade) {
                 propriedades.remove(i);
                 return true;
             }
         }
         return false;
     }

        /*
        * Essa função retorna os dados de todos os jogadores e propriedades do tabuleiro.
        */
        public String toString(){
            String out = "-------------------------------\n";
            out += "Tabuleiro:\n";
            out += "-------------------------------\n";
            out += "Jogadores:\n";
            for (Jogador jogador : this.jogadores){
                out += jogador.getNome() + " (" + jogador.getId() +").\n";
            }
            out += "-------------------------------\n";
            out += "Propriedades:\n";
            for (Propriedade propriedade : this.propriedades){
                out += propriedade.getNome() + " (" + propriedade.getId() +").\n";
            }
            out += "-------------------------------\n";
            return out;
        }
}