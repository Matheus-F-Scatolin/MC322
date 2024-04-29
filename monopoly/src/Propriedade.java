/*
 * Propriedade.java
 * 
 * Última modificação: 03/04/2024 
 */

/**
 *  Esta classe contém a estrutura de implementação de um Terreno 
 */

public class Propriedade extends Carta{
    // Atributos da propriedade
    private String nome;
    private int preco;
    private int aluguelBase;

    // Construtor da propriedade
    public Propriedade(String nome, String descricao, Jogador proprietario, int preco, int aluguelBase) {
        // Chamando o construtor da superclasse
        super(descricao, proprietario);
        this.nome = nome;
        this.preco = preco;
        this.aluguelBase = aluguelBase;
    }

    // Getters e Setters

    // Nome: nome da propriedade
    public String getNome() {
        return this.nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    // Preço: preço da propriedade
    public int getPreco() {
        return this.preco;
    }
    public void setPreco(int preco) {
        this.preco = preco;
    }

    // AluguelBase: valor do aluguel base da propriedade
    public int getAluguelBase() {
        return this.aluguelBase;
    }
    public void setAluguelBase(int aluguelBase) {
        this.aluguelBase = aluguelBase;
    }

    // Métodos
    public int calcularAluguel() {
        // Por enquanto, essa função só retorna o aluguel base (a ideia é mudar mais pra frente)
        return this.aluguelBase;
    }

    // Método toString para imprimir os dados da propriedade
    public String toString() {
        return "Propriedade: " + this.nome + "\n" +
               "ID: " + super.getId() + "\n" +
               "Proprietário: " + super.getDono().getNome() + "\n" +
               "Preço: " + this.preco + "\n" +
               "Aluguel Base: " + this.aluguelBase;
    }
}
