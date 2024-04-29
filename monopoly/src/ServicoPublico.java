/*
 * ServicoPublico.java
 * 
 * Última modificação: 03/04/2024 
 */

/**
 *  Esta classe contém a estrutura de implementação de um ServicoPublico 
 */

public class ServicoPublico extends Propriedade {
    // O Serviço público não possui atriutos adicionais

    // Construtor do serviço público
    public ServicoPublico(String nome, String descricao, Jogador proprietario, int preco, int aluguelBase) {
        // Chamando o construtor da superclasse
        super(nome, descricao, proprietario, preco, aluguelBase);
    }

    // Métodos
    public int calcularAluguel(int dados) {
        // O aluguel do serviço público é o aluguel base multiplicado pelo valor do dado
        return super.getAluguelBase() * dados;
    }
}
