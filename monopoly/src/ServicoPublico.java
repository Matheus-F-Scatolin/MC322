/*
 * ServicoPublico.java
 * 
 * Última modificação: 29/04/2024 
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
    /*
     * Essa função retorna o aluguel do serviço público.
     * @param dados: valor do dado
     * @return: aluguel do serviço público
     */
    public int calcularAluguel(int dados) {
        // O aluguel do serviço público é o aluguel base multiplicado pelo valor do dado
        return super.getAluguelBase() * dados;
    }

    // Método toString para imprimir os dados do serviço público
    public String toString() {
        String dono = "Nenhum";
        if (super.getDono() != null) {
            dono = super.getDono().getNome();
        }
        return "Propriedade: " + super.getNome() + "\n" +
               "ID: " + super.getId() + "\n" +
               "Proprietário: " + dono + "\n" +
               "Preço: " + super.getPreco() + "\n" +
               "Aluguel Base: " + super.getAluguelBase();
    }
}
