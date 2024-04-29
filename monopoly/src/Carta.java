/*
 * Carta.java
 * 
 * Última modificação: 20/04/2024 
 */

/**
 *  Esta classe contém a estrutura de implementação de uma Carta 
 */
public class Carta {
    // Atributos da carta
    // Atributo estático para armazenar o número de cartas
    private static int numCartas = 0;
    private int id;
    private String descricao;
    private Jogador dono;

    // Construtor da carta
    public Carta(String descricao, Jogador dono) {
        // Incrementando o número de cartas
        numCartas += 1;
        this.id = numCartas;
        this.descricao = descricao;
        this.dono = dono;
    }

    // Getters e Setters
    // Id: id da carta (o id não pode ser alterado, por isso não tem setter)
    public int getId() {
        return id;
    }

    // Descrição: descrição da carta
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    // Dono: dono da carta
    public Jogador getDono() {
        return dono;
    }
    public void setDono(Jogador dono) {
        this.dono = dono;
    }
}