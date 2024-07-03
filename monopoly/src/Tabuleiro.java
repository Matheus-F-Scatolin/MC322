/*
 * Tabuleiro.java
 * 
 * Última modificação: 03/07/2024 
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.FileInputStream;
import java.io.FileOutputStream;

 /**
  *  Esta classe contém a estrutura de implementação de um Tabuleiro, que implementa a interface Salvavel e Serializable.
  */
 public class Tabuleiro implements Salvavel, Serializable {
     // versão da classe para serialização
     private static final long serialVersionUID = 1L;
     // Atributos
    private ArrayList<Jogador> jogadores;
    private ArrayList<Propriedade> propriedades;
    private ArrayList<PosicaoTabuleiro> posicoes;
    private ArrayList<CartaSorte> cartasSorte;
 
     // Construtor do tabuleiro
     public Tabuleiro(Jogador jogador1, Jogador jogador2) {
        // Inicializando o arraylist de jogadores e propriedades
        this.jogadores = new ArrayList<Jogador>();
        this.jogadores.add(jogador1);
        this.jogadores.add(jogador2);

        this.propriedades = new ArrayList<Propriedade>();

        // Inicializando o arraylist de cartas de sorte e de propriedades
        this.cartasSorte = new ArrayList<CartaSorte>();
        this.inicializarTabuleiro();

        // Inicializando o arraylist de posicoes
        this.posicoes = new ArrayList<PosicaoTabuleiro>();
        // Distribuindo as cartas em posições do tabuleiro posicoes no tabuleiro
        this.distribuirCartas();
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

    // Posicoes: lista de posicoes no tabuleiro
    public ArrayList<PosicaoTabuleiro> getPosicoes() {
        return this.posicoes;
    }

    // CartasSorte: lista de cartas de sorte no tabuleiro
    public ArrayList<CartaSorte> getCartasSorte() {
        return this.cartasSorte;
    }
 
     // Métodos
    /*
    * Essa função inicializa o tabuleiro com as propriedades e cartas.
    */
    private void inicializarTabuleiro(){
        // Criar as cartas de sorte
        CartaSorte carta = new CartaSorte("Pague 200", 0, 0, -200, "", 0, "", tipoCarta.SORTE);
        this.cartasSorte.add(carta);
        carta = new CartaSorte("Pague 500", 0, 0, -500, "", 0, "", tipoCarta.SORTE);
        this.cartasSorte.add(carta);
        carta = new CartaSorte("Receba 200", 0, 0, 200, "", 0, "", tipoCarta.SORTE);
        this.cartasSorte.add(carta);
        carta = new CartaSorte("Receba 500", 0, 0, 500, "", 0, "", tipoCarta.SORTE);
        this.cartasSorte.add(carta);
        carta = new CartaSorte("Pague 700", 0, 0, -700, "", 0, "", tipoCarta.SORTE);
        this.cartasSorte.add(carta);
        carta = new CartaSorte("Receba 700", 0, 0, 700, "", 0, "", tipoCarta.SORTE);
        this.cartasSorte.add(carta);

        // Criar as estacoes
        Estacao estacao = new Estacao("Estacao 1", "Estacao 1", null, 500, 60, 50);
        this.propriedades.add(estacao);
        estacao = new Estacao("Estacao 2", "Estacao 2", null, 700, 80, 50);
        this.propriedades.add(estacao);
        estacao = new Estacao("Estacao 3", "Estacao 3", null, 900, 90, 50);
        this.propriedades.add(estacao);
        estacao = new Estacao("Estacao 4", "Estacao 4", null, 400, 40, 40);
        this.propriedades.add(estacao);
        estacao = new Estacao("Estacao 5", "Estacao 5", null, 600, 60, 50);
        this.propriedades.add(estacao);

        // Criar os serviços públicos
        ServicoPublico servico = new ServicoPublico("Servico 1", "Servico 1", null, 300, 10);
        this.propriedades.add(servico);
        servico = new ServicoPublico("Servico 2", "Servico 2", null, 400, 15);
        this.propriedades.add(servico);
        servico = new ServicoPublico("Servico 3", "Servico 3", null, 500, 20);
        this.propriedades.add(servico);
        servico = new ServicoPublico("Servico 4", "Servico 4", null, 600, 25);
        this.propriedades.add(servico);
        servico = new ServicoPublico("Servico 5", "Servico 5", null, 700, 30);
        this.propriedades.add(servico);

        // Criar os terrenos
        Terreno terreno = new Terreno("Terreno 1", "Terreno 1", null, 300, 30, 50, 100);
        this.propriedades.add(terreno);
        terreno = new Terreno("Terreno 2", "Terreno 2", null, 400, 40, 60, 120);
        this.propriedades.add(terreno);
        terreno = new Terreno("Terreno 3", "Terreno 3", null, 500, 50, 70, 140);
        this.propriedades.add(terreno);
        terreno = new Terreno("Terreno 4", "Terreno 4", null, 600, 60, 80, 160);
        this.propriedades.add(terreno);
        terreno = new Terreno("Terreno 5", "Terreno 5", null, 700, 70, 90, 180);
        this.propriedades.add(terreno);
    }

    /**
     * Distribui as cartas de propriedades nas posições do tabuleiro.
     * O tabuleiro terá 15 propriedades (5 de cada tipo) e 2 posições
     * nas quais o jogador deve pegar uma carta de sorte. Além disso,
     * a primeira posição será a posição inicial.
    */
    private void distribuirCartas(){
        // Aleatorizar a ordem das propriedades
        Collections.shuffle(this.propriedades);

        int pos_prop = 0;
        // Colocar as propriedades no tabuleiro
        for (int i = 0; i < this.getPropriedades().size() + 2; i++){
            // Adicionar a posição inicial
            if (i == 0){
                PosicaoTabuleiro posicao = new PosicaoTabuleiro(0, null, true);
                this.posicoes.add(posicao);
            }
            // Adicionar as posições de cartas de sorte
            else if (i == 7 || i == 14){
                PosicaoTabuleiro posicao = new PosicaoTabuleiro(i, null, false);
                this.posicoes.add(posicao);
            }
            else{
                PosicaoTabuleiro posicao = new PosicaoTabuleiro(i, this.propriedades.get(pos_prop), false);
                this.posicoes.add(posicao);
                pos_prop++;
            }
        }
        

    }
 
     /**
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
 
     /**
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
 
     /**
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
 
     /**
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

    /**
     * Move um jogador no tabuleiro.
     * De acordo com a posição do jogador, verifica se ele caiu em uma propriedade
     * ou em uma posição de sorte.
     * @param jogador jogador a ser movido
     * @param dado valor do dado
     */
    public void moverJogador(Jogador jogador, int dado, Scanner input){
        // Mover o jogador
        // Se o jogador cruzar a origem, ele recebe 500 reais
        jogador.getPeca().mover(dado, jogador, this);

        // Verificar se o jogador caiu em uma propriedade
        PosicaoTabuleiro posicao = this.posicoes.get(jogador.getPeca().getPosicao());
        if (posicao.getPropriedade() != null){
            // Verificar se a propriedade está disponível
            if (posicao.getPropriedade().getDono() == null){
                // Verificar se o jogador quer comprar a propriedade
                if (Main.perguntaCompraPropriedade(this, jogador, input) == true){
                    try {
                        // Comprar a propriedade
                        jogador.comprarPropriedade(posicao.getPropriedade());
                    } catch (ExcecaoFaltaDeDinheiro e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
            // Verificar se o jogador caiu em uma propriedade dele mesmo
            else if (posicao.getPropriedade().getDono().getId() == jogador.getId()){
                // Verificar se essa propriedade é um terreno
                if (posicao.getPropriedade() instanceof Terreno){
                    Terreno terreno = (Terreno) posicao.getPropriedade();
                    if (terreno.getNumeroCasas() < 4) {
                        // Verificar se o jogador quer construir uma casa
                        if (Main.perguntaConstruirCasa(this, jogador, input) == true){
                            // Construir casa
                            try {
                                terreno.comprarCasa();
                                Main.imprimirConstrucaoCasa(jogador, terreno);
                            } catch (ExcecaoFaltaDeDinheiro e) {
                                System.out.println(e.getMessage());
                            }
                        }
                    }
                    else{
                        // Verificar se o jogador quer construir um hotel
                        if (Main.perguntaConstruirHotel(this, jogador, input) == true){
                            // Construir hotel
                            try {
                                terreno.comprarHotel();
                                Main.imprimirConstrucaoHotel(jogador, terreno);
                            } catch (ExcecaoFaltaDeDinheiro e) {
                                System.out.println(e.getMessage());
                            }
                        }
                    }
                }
            }
            else{
                // Verificar se o jogador caiu em uma propriedade de outro jogador
                if (posicao.getPropriedade().getDono().getId() != jogador.getId()){
                    // Pagar o aluguel
                    jogador.pagarAluguel(posicao.getPropriedade());
                }
            }
        }
        else{
            // Verificar se o jogador caiu em uma posição de sorte
            if ((posicao.getPropriedade() == null) && (posicao.getPosicaoInicial() == false)){
                // Puxar uma carta de sorte
                CartaSorte carta = jogador.puxarCartaSorte(this.cartasSorte);
                jogador.adicionarCarta(carta, 0);
                // Realizar a ação da carta
                carta.executaAcao();
                jogador.removerCarta(carta);
                Main.imprimirCartaSorte(carta);
            }
        }
    }

    /**
     * Salva o log  do tabuleiro de um jogo.
    */
    public void salvaLog(){
    // Salva o log do jogo
    // Tenta abrir o arquivo
    // Cria um novo arquivo
    String nomeArquivo = "logTabuleiro.bytej";
    // Cria o arquivo
    try{
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(nomeArquivo));
        out.writeObject(this);
        // Fecha o arquivo
        out.flush();
        out.close();
    }
    catch (IOException e){
        System.out.println("Erro ao abrir o arquivo.");
    }
    }

    /**
    * Abre o log de um tabuleiro salvo.
    * @return o tabuleiro salvo
    */
    public static Tabuleiro abreLog(){
        // Abre o log do jogo
        String nomeArquivo = "logTabuleiro.bytej";
        try{
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(nomeArquivo));
            Tabuleiro tabuleiro = (Tabuleiro) in.readObject();
            // Fecha o arquivo
            in.close();
            return tabuleiro;
        }
        catch (IOException e){
            System.out.println("Erro ao abrir o arquivo.");
            return null;
        }
        catch (ClassNotFoundException e){
            System.out.println("Classe não encontrada.");
            return null;
        }
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
            out += jogador.getNome() + " (pos: " + jogador.getPeca().getPosicao() +") - saldo: " + jogador.getDinheiro() + ".\n";
        }
        out += "-------------------------------\n";
        out += "Posições do tabuleiro:\n";
        for (PosicaoTabuleiro posicao : this.posicoes){
            // Mostrar a posição no formato: [posicao] - [propriedade]
            out += "[" + posicao.getPosicao() + "] - ";

            // Se a posição for uma propriedade, mostrar o nome da propriedade
            if (posicao.getPropriedade() != null){
                out += posicao.getPropriedade().getNome();
                //Se a propriedade tiver dono, mostrar o nome do dono
                if (posicao.getPropriedade().getDono() != null){
                    out += "(" + posicao.getPropriedade().getDono().getNome() + ").\n";
                }
                else {
                    out += ".\n";
                }
            }
            else if (posicao.getPosicaoInicial() == true){
                out += "Posição inicial.\n";
            }
            else{
                out += "Retire uma carta de Sorte.\n";
            }
        }
        out += "-------------------------------\n";
        return out;
    }
}