/*
 * Terreno.java
 * 
 * Última modificação: 29/04/2024 
 */

/**
 *  Esta classe contém a estrutura de implementação de um Terreno 
 */
public class Terreno extends Propriedade{
    // Atributos
    private int numeroCasas;
    private int valorCasa;
    private int valorHotel;
    private boolean temHotel;

    // Construtor
    public Terreno(String nome, String descricao, Jogador proprietario, int preco, int aluguelBase, int valorCasa, int valorHotel) {
        // Chamando o construtor da superclasse
        super(nome, descricao, proprietario, preco, aluguelBase);
        this.numeroCasas = 0;
        this.valorCasa = valorCasa;
        this.valorHotel = valorHotel;
        this.temHotel = false;
    }

    // Getters e Setters
    // NumeroCasas: número de casas no terreno
    public int getNumeroCasas() {
        return this.numeroCasas;
    }
    public void setNumeroCasas(int numeroCasas) {
        this.numeroCasas = numeroCasas;
    }

    // ValorCasa: valor para construir uma casa no terreno
    public int getValorCasa() {
        return this.valorCasa;
    }
    public void setValorCasa(int valorCasa) {
        this.valorCasa = valorCasa;
    }

    // ValorHotel: valor para construir um hotel no terreno
    public int getValorHotel() {
        return this.valorHotel;
    }
    public void setValorHotel(int valorHotel) {
        this.valorHotel = valorHotel;
    }

    // TemHotel: indica se o terreno possui um hotel
    public boolean getTemHotel() {
        return this.temHotel;
    }
    public void setTemHotel(boolean temHotel) {
        this.temHotel = temHotel;
    }

    // Métodos

    /*
     * Essa função calcula o valor do aluguel do terreno, levando em consideração o número de casas e se há um hotel.
     * @return: valor do aluguel do terreno
     */
    public int calcularAluguel() {
        // O aluguel do terreno é o aluguel base multiplicado pelo número de casas (Se não houver hotel)
        if (!this.temHotel) {
            return super.getAluguelBase() * (1 + this.numeroCasas);
        }
        
        // O aluguel do terreno é o aluguel considerando as casas multiplicado por 2 (Se houver hotel)
        return super.getAluguelBase() * (1 + this.numeroCasas) * 2;
    }

    /*
     * Essa função compra uma casa no terreno.
     * @return: true se a casa foi construída com sucesso, false caso contrário
     */
    public boolean comprarCasa() {
        // Verifica se o jogador tem dinheiro suficiente para comprar uma casa
        if (super.getDono().getDinheiro() < this.valorCasa) {
            return false;
        }
        // Verifica se o terreno já possui um hotel
        if (this.temHotel) {
            return false;
        }
        // Verifica se o número de casas é menor que 4
        if (this.numeroCasas >= 4) {
            return false;
        }
        // Adiciona uma casa ao terreno
        this.numeroCasas += 1;
        // Remove o valor da casa do dinheiro do jogador
        super.getDono().setDinheiro(super.getDono().getDinheiro() - this.valorCasa);

        return true;
    }

    /*
     * Essa função compra um hotel no terreno.
     * @return: true se o hotel foi construído com sucesso, false caso contrário
     */
    public boolean comprarHotel() {
        // Verifica se o jogador tem dinheiro suficiente para comprar um hotel
        if (super.getDono().getDinheiro() < this.valorHotel) {
            return false;
        }
        // Verifica se o terreno já possui um hotel
        if (this.temHotel) {
            return false;
        }
        // Verifica se o número de casas é igual a 4
        if (this.numeroCasas != 4) {
            return false;
        }
        // Adiciona um hotel ao terreno
        this.temHotel = true;
        // Remove o valor do hotel do dinheiro do jogador
        super.getDono().setDinheiro(super.getDono().getDinheiro() - this.valorHotel);

        return true;
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
               "Aluguel Base: " + super.getAluguelBase() + "\n" +
               "Número de casas: " + this.numeroCasas + "\n" +
               "Valor da casa: " + this.valorCasa + "\n" +
               "Valor do hotel: " + this.valorHotel + "\n" +
               "Tem hotel: " + this.temHotel + "\n" +
               "Aluguel: " + this.calcularAluguel();
    }
}
