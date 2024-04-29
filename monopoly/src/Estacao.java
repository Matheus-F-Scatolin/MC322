/*
 * Estacao.java
 * 
 * Última modificação: 03/04/2024 
 */

/**
 *  Esta classe contém a estrutura de implementação de uma Estacao 
 */

public class Estacao extends Propriedade {
    //A estação não possui atributos adicionais

    //Construtor da estação
    public Estacao(String nome, String descricao, Jogador proprietario, int preco, int aluguelBase) {
        //Chamando o construtor da superclasse
        super(nome, descricao, proprietario, preco, aluguelBase);
    }

    // Métodos
    public int calcularAluguel() {
        //O aluguel da estação é o aluguel base multiplicado pelo número de estações do proprietário
        //Porém, como ainda não implementamos isso, ela retorna o aluguel base
        return super.getAluguelBase();
    }
}
