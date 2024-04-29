import java.util.Scanner;

/*
 * Main.java
 * 
 * Última modificação: 29/04/2024 
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
    
    /*
     * Esse método lê os dados de uma propriedade do terminal e retorna a propriedade lida.
     * @param input: um scanner para ler o input do terminal
     * @return: a propriedade lida
     */
    private static Propriedade leituraPropriedade(Scanner input){
        // Instanciando uma propriedade
        Propriedade propriedade = null;
        // Lendo o tipo da propriedade
        System.out.println("Insira o tipo da propriedade:"
                + "\n[1] Terreno"
                + "\n[2] Estação"
                + "\n[3] Serviço Público");
        int tipo = Integer.parseInt(input.nextLine());
        // Lendo o nome da propriedade
        System.out.println("Insira o nome da propriedade:");
        String nome = input.nextLine();
        // Lendo a descrição da propriedade
        System.out.println("Insira a descrição da propriedade:");
        String descricao = input.nextLine();
        // Lendo o preço da propriedade
        System.out.println("Insira o preço da propriedade:");
        int preco = Integer.parseInt(input.nextLine());
        // Lendo o aluguel base da propriedade
        System.out.println("Insira o aluguel base da propriedade:");
        int aluguelBase = Integer.parseInt(input.nextLine());
        if (tipo == 1){
            // Terreno
            // Lendo o valor da casa do terreno
            System.out.println("Insira o valor da casa do terreno:");
            int valorCasa = Integer.parseInt(input.nextLine());
            // Lendo o valor do hotel do terreno
            System.out.println("Insira o valor do hotel do terreno:");
            int valorHotel = Integer.parseInt(input.nextLine());
            propriedade = new Terreno(nome, descricao, null, preco, aluguelBase, valorCasa, valorHotel);
        }
        else if (tipo == 2){
            // Estação
            propriedade = new Estacao(nome, descricao, null, preco, aluguelBase);
        }
        else if (tipo == 3){
            // Serviço Público
            propriedade = new ServicoPublico(nome, descricao, null, preco, aluguelBase);
        }
        else{
            // Tipo inválido
            System.out.println("Tipo inválido.");
        }
        return propriedade;
    }

    /*
     * Esse método lê os dados de um jogador do terminal e retorna o jogador lido.
     * @param input: um scanner para ler o input do terminal
     * @return: o jogador lido
     */
    private static Jogador leituraJogador(Scanner input){
        // Lendo o nome do jogador
        System.out.println("Insira o nome do jogador:");
        String nome = input.nextLine();

        // Lendo o caminho da foto do jogador
        System.out.println("Insira o caminho da foto do jogador:");
        String foto = input.nextLine();

        // Lendo a cor da peça do jogador
        System.out.println("Insira a cor da peça do jogador:");
        String cor = input.nextLine();

        // A posição inicial do jogador é 0
        int posicao = 0;

        // Instanciando um jogador
        Jogador jogador = new Jogador(nome, foto, new Peca(cor, posicao));

        // Lendo o email e o CPF do jogador
        leituraCPFEmail(jogador, input);
        return jogador;
    }

    /*
     * Esse método lê inputs do terminal e executa ações de acordo com o input.
     * O loop é encerrado quando o usuário escolhe a opção de sair.
     * As opções disponíveis são:
     * [1] Adicionar um jogador
     * [2] Remover um jogador
     * [3] Adicionar uma propriedade
     * [4] Remover uma propriedade
     * [5] Exibir dados de um jogador
     * [6] Exibir dados de uma propriedade
     * [7] Sair
     * @param tabuleiro: o tabuleiro do jogo
     * @param input: um scanner para ler o input do terminal
     */
    private static void menuDeLeituraDeDados(Tabuleiro tabuleiro, Scanner input) {
        // Imprimindo o tabuleiro
        System.out.println(tabuleiro.toString());

        //Começar um loop de leitura de dados
        int opcao;
        do {
            System.out.println("O que você deseja fazer?"
                    + "\n[1] Adicionar um jogador"
                    + "\n[2] Remover um jogador"
                    + "\n[3] Adicionar uma propriedade"
                    + "\n[4] Remover uma propriedade"
                    + "\n[5] Exibir dados de um jogador"
                    + "\n[6] Exibir dados de uma propriedade"
                    + "\n[7] Sair");
            opcao = Integer.parseInt(input.nextLine());
            
            if (opcao == 1){
                // Ler um jogador
                Jogador jogador = leituraJogador(input);

                // Adicionando o jogador ao tabuleiro
                tabuleiro.addJogador(jogador);
                System.out.println("Jogador adicionado com sucesso.\n");

                // Imprimindo o tabuleiro
                System.out.println(tabuleiro.toString());
            }
            else if (opcao == 2){
                // Remover um jogador
                System.out.println("Insira o id do jogador que deseja remover:");
                int id = Integer.parseInt(input.nextLine());
                if (tabuleiro.removeJogador(id))
                    System.out.println("Jogador removido com sucesso.\n");
                else
                    System.out.println("Jogador não encontrado.\n");
                // Imprimindo o tabuleiro
                System.out.println(tabuleiro.toString());
            }
            else if (opcao == 3){
                // Ler uma propriedade
                Propriedade propriedade = leituraPropriedade(input);

                // Adicionando a propriedade ao tabuleiro
                tabuleiro.addPropriedade(propriedade);
                System.out.println("Propriedade adicionada com sucesso.\n");

                // Imprimindo o tabuleiro
                System.out.println(tabuleiro.toString());
            }
            else if (opcao == 4){
                // Remover uma propriedade
                System.out.println("Insira o id da propriedade que deseja remover:");
                int id = Integer.parseInt(input.nextLine());
                if (tabuleiro.removePropriedade(id))
                    System.out.println("Propriedade removida com sucesso.\n");
                else
                    System.out.println("Propriedade não encontrada.\n");

                // Imprimindo o tabuleiro
                System.out.println(tabuleiro.toString());
            }
            else if (opcao == 5){
                // Exibir dados de um jogador
                System.out.println("Insira o id do jogador que deseja exibir:");
                int id = Integer.parseInt(input.nextLine());
                Jogador jogador = null;
                for (Jogador j : tabuleiro.getJogadores()){
                    if (j.getId() == id){
                        jogador = j;
                        break;
                    }
                }
                if (jogador != null){
                    System.out.println("\n" + jogador.toString() + "\n");
                }
                else{
                    System.out.println("\nJogador não encontrado.\n");
                }
            }
            else if (opcao == 6){
                // Exibir dados de uma propriedade
                System.out.println("Insira o id da propriedade que deseja exibir:");
                int id = Integer.parseInt(input.nextLine());
                Propriedade propriedade = null;
                for (Propriedade p : tabuleiro.getPropriedades()){
                    if (p.getId() == id){
                        propriedade = p;
                        break;
                    }
                }
                if (propriedade != null){
                    System.out.println("\n" + propriedade.toString() + "\n");
                }
                else{
                    System.out.println("\nPropriedade não encontrada.\n");
                }
            }
            else if (opcao != 7){
                System.out.println("Opção inválida.");
            }
        }
        while (opcao != 7);
    }
    public static void main(String[] args){
        // Criando um scanner para pegar um input do terminal
        Scanner input = new Scanner(System.in);

        // Instanciando um jogador
        Jogador jogador1 = new Jogador("João", "joao.jpg", new Peca("vermelho", 0));
        
        // Lendo o nome e email do jogador
        leituraCPFEmail(jogador1, input);
        
        // Imprimindo os dados do jogador
        System.out.println(jogador1.toString());
        
        //Instanciando um segundo jogador
        Jogador jogador2 = new Jogador("Maria", "maria.jpg", new Peca("azul", 0));

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
        CartaSorte carta1 = new CartaSorte("Pague 200", 0, -1, -200, "", 0, "");

        //Atribuindo ela a um jogador
        jogador1.adicionarCarta(carta1, (int)carta1.getValorPagamentoRecebimento());

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

        //Instanciando um serviço publico
        ServicoPublico servico1 = new ServicoPublico("Serviço 1", "primeiro serv", jogador2, 1500, 300);
        jogador2.adicionarCarta(servico1, servico1.getPreco());
        tabuleiro.addPropriedade(servico1);

        // Instanciando um terreno
        Terreno terreno1 = new Terreno("Terreno 1", "primeiro terreno", jogador1, 1500, 300, 800, 3000);
        jogador1.adicionarCarta(terreno1, terreno1.getPreco());
        tabuleiro.addPropriedade(terreno1);

        // Comprando uma casa no terreno (essa função já testa se o jogador possui dinheiro o suficiente e reduz seu dinheiro)
        terreno1.comprarCasa();
        //Imprimir os dados desse terreno
        System.out.println(terreno1.toString());

        // Instanciando uma estação
        Estacao estacao1 = new Estacao("estação 1", "primeira est", jogador2, 1000,200);
        jogador2.setDinheiro(jogador2.getDinheiro() - estacao1.getPreco());
        tabuleiro.addPropriedade(estacao1);

        // Usando o menu de leitura de dados
        menuDeLeituraDeDados(tabuleiro, input);

        // Fechando o scanner
        input.close();
    }
}