/*
 * Jogador.java
 * 
 * Última modificação: 29/04/2024 
 */

import java.util.ArrayList;

/**
 *  Esta classe contém a estrutura de implementação de um Jogador 
 */
public class Jogador {
    // Atributo estático para armazenar o número de jogadores criados
    private static int numJogadores = 0;
    // Atributos do jogador
    private int id;
    private int dinheiro;
    private String nome;
    private String cpf;
    private String email;
    // Atributo para armazenar o caminho da foto do jogador
    private String foto;
    private ArrayList<Carta> cartas;
    private Peca peca;

    // Construtor do jogador
    public Jogador(String nome, String foto, Peca peca) {
        // Incrementando o número de jogadores
        numJogadores += 1;
        this.id = numJogadores;
        // Inicializando o dinheiro de cada jogador com 5000
        this.dinheiro = 5000;
        this.nome = nome;
        this.foto = foto;
        this.cartas = new ArrayList<Carta>();
        this.peca = peca;
    }

    // Getters e setters
    // Id: id do jogador (o id não pode ser alterado, por isso não tem setter)
    public int getId() {
        return id;
    }

    // Dinheiro: dinheiro do jogador
    public int getDinheiro() {
        return dinheiro;
    }
    public void setDinheiro(int dinheiro) {
        this.dinheiro = dinheiro;
    }

    // Nome: nome do jogador
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    // Cpf: CPF do jogador
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    // Email: email do jogador
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    
    // Foto: caminho da foto do jogador
    public String getFoto() {
        return foto;
    }
    public void setFoto(String foto) {
        this.foto = foto;
    }

    // Cartas: cartas do jogador
    public ArrayList<Carta> getCartas() {
        return cartas;
    }
    public void setCartas(ArrayList<Carta> cartas) {
        this.cartas = cartas;
    }

    // Peca: peça do jogador
    public Peca getPeca() {
        return peca;
    }
    public void setPeca(Peca peca) {
        this.peca = peca;
    }

    // Métodos

    /*
     * Essa função adiciona uma carta ao jogador.
     * @param valor: a carta a ser adicionada
     */
    public void adicionarCarta(Carta carta, int custoDaCarta) {
        this.cartas.add(carta);
        carta.setDono(this);
        this.dinheiro -= custoDaCarta;
    }

    /*
     * Essa função remove uma carta do jogador.
     * @param valor: a carta a ser removida
     */
    public boolean removerCarta(Carta carta) {
        if (this.cartas.remove(carta)) {
            carta.setDono(null);
            return true;
        }
        return false;
    }
    
    /**
     * Essa função faz com que o jogador compre uma propriedade.
     * @param propriedade a propriedade a ser comprada
     */
    public void comprarPropriedade(Propriedade propriedade) {
        if (this.dinheiro >= propriedade.getPreco()) {
            this.dinheiro -= propriedade.getPreco();
            propriedade.setDono(this);
            //Adicionar a carta dessa propriedade às cartas do jogador
            this.adicionarCarta(propriedade, 0);

            // Imprimir os dados da compra
            Main.imprimirCompra(this, propriedade);
        }
    }

    /**
     * Essa função faz com que o jogador pague o aluguel de uma propriedade.
     * @param propriedade a propriedade a ser paga.
     */
    public void pagarAluguel(Propriedade propriedade) {
        if (this.dinheiro >= propriedade.calcularAluguel()) {
            this.dinheiro -= propriedade.calcularAluguel();
            propriedade.getDono().setDinheiro(propriedade.getDono().getDinheiro() + propriedade.calcularAluguel());
        }
        // Imprimir os dados do pagamento
        Main.imprimirPagamentoAluguel(this, propriedade);
    }

    /**
     * Essa função faz com que o jogador puxe uma carta aleatória.
     * A carta é retirada permanece no baralho.
     * @param cartasSorte o baralho de cartas de sorte.
     * @return a carta sorte puxada.
     */
    public CartaSorte puxarCartaSorte(ArrayList<CartaSorte> cartasSorte) {
        //Pega uma carta aleatória (a carta permanece no baralho)
        CartaSorte cartaSorte = cartasSorte.get((int) (Math.random() * cartasSorte.size()));
        return cartaSorte;
    }

    /**
     * Essa função retorna os dados do jogador, incluindo nome, CPF, email e foto.
     * @return: os dados do jogador
     */
    public String toString() {
        String cartas = "";
        for (Carta carta : this.cartas) {
            cartas += carta.getDescricao() + ", ";
        }
        return "Dados do jogador:\nNome: " + this.getNome() +
               "\nId: " + this.getId() +
               "\nDinheiro: " + this.getDinheiro() +
               "\nPeca: " + this.getPeca().getCor() +
               "\nPosicao: " + this.getPeca().getPosicao() +
               "\nCartas:" + cartas;
    }
}