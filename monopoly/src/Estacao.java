/*
 * Estacao.java
 * 
 * Última modificação: 03/07/2024 
 */

/**
 *  Esta classe contém a estrutura de implementação de uma Estacao 
 */

public class Estacao extends Propriedade {
    //Atributos
    //Tarifa a ser adicionada ao aluguel base para cada estação do proprietário
    private int tarifa;

    //Construtor da estação
    public Estacao(String nome, String descricao, Jogador proprietario, int preco, int aluguelBase, int tarifa) {
        //Chamando o construtor da superclasse
        super(nome, descricao, proprietario, preco, aluguelBase);
        this.tarifa = tarifa;
    }

    // Métodos
    /*
     * Essa função conta o numero de estações do jogador.
     * @param jogador: jogador que possui as estações
     * @return: número de estações do jogador
     */
    private int contarEstacoes(Jogador jogador) {
        int estacoes = 0;
        for (Carta carta : jogador.getCartas()) {
            if (carta instanceof Estacao) {
                estacoes++;
            }
        }
        return estacoes;
    }

    /*
     * Essa função retorna o aluguel da estação.
     * @param dados: valor do dado
     * @return: aluguel do serviço público
     */
    public int calcularAluguel() {
        //O aluguel da estação é o aluguel base mais a tarifa multiplicada pelo número de estações do proprietário
        return super.getAluguelBase() + tarifa * contarEstacoes(super.getDono());
    }

    //Método toString para imprimir os dados da estação
    public String toString() {
        return "Propriedade: " + super.getNome() + "\n" +
               "Preço: " + super.getPreco() + "\n" +
               "Aluguel Base: " + super.getAluguelBase();
    }
}
