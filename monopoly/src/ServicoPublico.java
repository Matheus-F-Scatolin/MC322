public class ServicoPublico extends Propriedade {
    // O Serviço público não possui atriutos adicionais

    // Construtor do serviço público
    public ServicoPublico(String nome, Jogador proprietario, int preco, int aluguelBase) {
        // Chamando o construtor da superclasse
        super(nome, proprietario, preco, aluguelBase);
    }

    // Métodos
    public int calcularAluguel(int dados) {
        // O aluguel do serviço público é o aluguel base multiplicado pelo valor do dado
        return super.getAluguelBase() * dados;
    }
}
