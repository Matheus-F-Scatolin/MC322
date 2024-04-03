import java.util.Scanner;

/*
 * Main.java
 * 
 * Última modificação: 03/04/2024 
 */
public class Main {
    /*
     * Esse método lê um email e um CPF do terminal e verifica se eles são válidos.	
     * Se não forem válidos, pede para o usuário inserir novamente, até que um email
     * e um CPF válidos sejam inseridos.
     */
    private static void leituraCPFEmail(Jogador jogador, Scanner input){
        //Verificando se esse email é valido e pedindo alteração
        String novoEmail;
        do{
            System.out.println("Por favor, insira um email válido.");
            // Pedir um input pelo terminal para alterar o email do jogador
            novoEmail = input.nextLine();
        }
        while (!Utilidades.validarEmail(novoEmail));
        jogador.setEmail(novoEmail);

        //Verificando o CPF do jogador e pedindo alteração
        String novoCPF;
        do{
            System.out.println("Por favor, insira um CPF válido.");
            // Pedir um input pelo terminal para alterar o CPF do jogador
            novoCPF = input.nextLine();
        }
        while (!Utilidades.validarCPF(novoCPF));
        jogador.setCpf(novoCPF);
        }
    
    public static void main(String[] args){
        // Criando um scanner para pegar um input do terminal
        Scanner input = new Scanner(System.in);

        // Instanciando um jogador
        Jogador jogador1 = new Jogador("João", "joao.jpg");
        
        // Lendo o nome e email do jogador
        leituraCPFEmail(jogador1, input);
        
        // Imprimindo os dados do jogador
        System.out.println(jogador1.toString());
        
        //Instanciando um segundo jogador
        Jogador jogador2 = new Jogador("Maria", "maria.jpg");

        // Lendo o nome e email do jogador
        leituraCPFEmail(jogador2, input);

        // Imprimindo os dados do jogador
        System.out.println(jogador2.toString());

        // Instanciando uma peça
        Peca peca1 = new Peca("vermelho", 0);

        // Alterando a cor da peça
        peca1.setCor("azul");

        // Alterando a posição da peça
        peca1.setPosicao(10);

        // Imprimindo os dados da peça
        System.out.println(peca1.toString());

        // Instanciando uma carta
        CartaSorte carta1 = new CartaSorte(1, "Pague 200", 0, -1, -200, "", 0, "");

        // Alterando a descrição da carta
        carta1.setDescricao("Pague 300");
        carta1.setValorPagamentoRecebimento(-300);

        // Imprimindo os dados da carta
        System.out.println(carta1.toString());

        // Instanciando o tabuleiro
        Tabuleiro tabuleiro = new Tabuleiro();

        //Adicionando os jogadores ao tabuleiro
        tabuleiro.addJogador(jogador1);
        tabuleiro.addJogador(jogador2);

        // Adicionando uma propriedade ao tabuleiro, a qual pertence ao jogador1
        Propriedade propriedade1 = new Propriedade("propriedade 1", jogador1, 1000, 200);
        jogador1.setDinheiro(jogador1.getDinheiro() - propriedade1.getPreco());
        tabuleiro.addPropriedade(propriedade1);

        // Imprimindo os dados da propriedade
        System.out.println(propriedade1.toString());

        //Instanciando um serviço publico
        ServicoPublico servico1 = new ServicoPublico("Serviço 1", jogador2, 1500, 300);
        jogador2.setDinheiro(jogador2.getDinheiro() - servico1.getPreco());
        tabuleiro.addPropriedade(servico1);

        // Instanciando um terreno
        Terreno terreno1 = new Terreno("Terreno 1", jogador1, 1500, 300, 800, 3000);
        jogador1.setDinheiro(jogador1.getDinheiro() - terreno1.getPreco());
        tabuleiro.addPropriedade(terreno1);

        // Comprando uma casa no terreno (essa função já testa se o jogador possui dinheiro o suficiente e reduz seu dinheiro)
        terreno1.comprarCasa();
        //Imprimir os dados desse terreno
        System.out.println(terreno1.toString());

        // Instanciando uma estação
        Estacao estacao1 = new Estacao("estação 1", jogador2, 1000,200);
        jogador2.setDinheiro(jogador2.getDinheiro() - estacao1.getPreco());
        tabuleiro.addPropriedade(estacao1);



        // Fechando o scanner
        input.close();
    }
}