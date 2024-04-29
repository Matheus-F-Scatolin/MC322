/*
 * Tabuleiro.java
 * 
 * Última modificação: 03/04/2024 
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
 }