import java.util.Scanner;

public class Main {
    /*
     * Esse método lê um email e um CPF do terminal e verifica se eles são válidos.	
     * Se não forem válidos, pede para o usuário inserir novamente, até que um email
     * e um CPF válidos sejam inseridos.
     */
    private static void leituraCPFEmail(Jogador jogador){
        // Criando um scanner para pegar um input do terminal
        Scanner input = new Scanner(System.in);
        //Verificando se esse email é valido e pedindo alteração
        while (!jogador.validarEmail()){
            System.out.println("Email inválido! por favor, insira um email válido.");
            // Pedir um input pelo terminal para alterar o email do jogador
            String novoEmail = input.nextLine();
            jogador.setEmail(novoEmail);
        }

        //Verificando o CPF do jogador e pedindo alteração
        while (!jogador.validarCPF()){
            System.out.println("CPF inválido! por favor, insira um CPF válido.");
            // Pedir um input pelo terminal para alterar o CPF do jogador
            String novoCPF = input.nextLine();
            jogador.setCpf(novoCPF); 
            }
            // Fechando o scanner
            input.close();
        }
    
    public static void main(String[] args){
        // Instanciando um jogador
        Jogador jogador1 = new Jogador("João", "123.456.789-00", "joao@gmail.com", "joao.jpg");

        // Alterando o nome do jogador
        jogador1.setNome("João da Silva");

        // Alterando o email do jogador
        jogador1.setEmail("joaosilva.gmail.com");

        //Verificando se o email e o cpf são validos e pedindo alteração
        leituraCPFEmail(jogador1);

        // Imprimindo os dados do jogador
        System.out.println(jogador1.toString());

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

    }
}