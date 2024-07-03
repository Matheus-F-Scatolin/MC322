/*
 * ServicoPublico.java
 * 
 * Última modificação: 03/07/2024 
 */

/**
 *  Esta classe contém a estrutura de implementação de um ServicoPublico 
 */

public class ServicoPublico extends Propriedade {
    // Atributo estático para armazenar o multiplicador do aluguel (cada vez que alguém joga o dado, essa variável muda de valor)
   private static int multiplicador = 0;

    // Construtor do serviço público
    public ServicoPublico(String nome, String descricao, Jogador proprietario, int preco, int aluguelBase) {
        // Chamando o construtor da superclasse
        super(nome, descricao, proprietario, preco, aluguelBase);
    }

    // Getters e Setters
    public static int getMultiplicador() {
        return multiplicador;
    }
    public static void setMultiplicador(int multiplicador) {
        ServicoPublico.multiplicador = multiplicador;
    }
    // Métodos
    /*
     * Essa função retorna o aluguel do serviço público.
     * @param dados: valor do dado
     * @return: aluguel do serviço público
     */
    public int calcularAluguel() {
        // O aluguel do serviço público é o aluguel base multiplicado pelo valor do dado
        return super.getAluguelBase() * multiplicador;
    }

    // Método toString para imprimir os dados do serviço público
    public String toString() {
        return "Propriedade: " + super.getNome() + "\n" +
               "Preço: " + super.getPreco() + "\n" +
               "Aluguel Base: " + super.getAluguelBase();
    }
}
