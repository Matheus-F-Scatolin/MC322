/*
 * Propriedade.java
 * 
 * Última modificação: 03/04/2024 
 */

/**
 *  Esta classe contém a estrutura de implementação de um Terreno 
 */

public class Propriedade {
    // Variável de classe para controlar o número de propriedades
    private static int numPropriedades = 0;
    // Atributos da propriedade
    private int id;
    private String nome;
    private Jogador proprietario;
    private int preco;
    private int aluguelBase;

    // Construtor da propriedade
    public Propriedade(String nome, Jogador proprietario, int preco, int aluguelBase) {
        // Incrementando o número de propriedades
        numPropriedades += 1;
        // Atribuindo o id da propriedade
        this.id = numPropriedades;
        this.nome = nome;
        this.proprietario = proprietario;
        this.preco = preco;
        this.aluguelBase = aluguelBase;
    }

    // Getters e Setters

    // Id: identificador único. Não possui setter pois o id não pode ser alterado
    public int getId() {
        return this.id;
    }

    // Nome: nome da propriedade
    public String getNome() {
        return this.nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    // Proprietário: nome do proprietário da propriedade
    public Jogador getProprietario() {
        return this.proprietario;
    }
    public void setProprietario(Jogador proprietario) {
        this.proprietario = proprietario;
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
               "ID: " + this.id + "\n" +
               "Proprietário: " + this.proprietario.getNome() + "\n" +
               "Preço: " + this.preco + "\n" +
               "Aluguel Base: " + this.aluguelBase;
    }
}
