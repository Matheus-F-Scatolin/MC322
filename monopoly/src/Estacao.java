/*
 * Estacao.java
 * 
 * Última modificação: 29/04/2024 
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
    /*
     * Essa função retorna o aluguel da estação.
     * @param dados: valor do dado
     * @return: aluguel do serviço público
     */
    public int calcularAluguel() {
        //O aluguel da estação é o aluguel base multiplicado pelo número de estações do proprietário
        //Porém, como ainda não implementamos isso, ela retorna o aluguel base
        return super.getAluguelBase();
    }

    //Método toString para imprimir os dados da estação
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
