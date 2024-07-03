/*
 * CartaSorte.java
 * 
 * Última modificação: 03/07/2024 
 */

/**
 *  Esta classe contém a estrutura de implementação de um CartaSorte 
 */
public class CartaSorte extends Carta{
    // Atributos da carta de sorte
    private int movimentoTabuleiro;
    private int efeito;
    private float valorPagamentoRecebimento;
    private String acaoEspecifica;
    private int tempoAplicacao;
    private String restricoesUso;
    private tipoCarta tipo;

    // Construtor da carta de sorte
    public CartaSorte(String descricao, int movimentoTabuleiro, int efeito, float valorPagamentoRecebimento, String acaoEspecifica, int tempoAplicacao, String restricoesUso, tipoCarta tipo) {
        // Chamando o construtor da superclasse
        super(descricao, null);
        this.movimentoTabuleiro = movimentoTabuleiro;
        this.efeito = efeito;
        this.valorPagamentoRecebimento = valorPagamentoRecebimento;
        this.acaoEspecifica = acaoEspecifica;
        this.tempoAplicacao = tempoAplicacao;
        this.restricoesUso = restricoesUso;
        this.tipo = tipo;
    }

    // Getters e Setters

    // Movimento no tabuleiro: Para cartas que instruem os jogadores a se moverem para uma determinada casa no tabuleiro
    public int getMovimentoTabuleiro() {
        return this.movimentoTabuleiro;
    }
    public void setMovimentoTabuleiro(int movimentoTabuleiro) {
        this.movimentoTabuleiro = movimentoTabuleiro;
    }

    // Efeito: positivo, negativo, neutro
    public int getEfeito() {
        return this.efeito;
    }
    public void setEfeito(int efeito) {
        this.efeito = efeito;
    }

    // Valor do pagamento/recebimento: Para cartas que envolvem transações financeiras
    public float getValorPagamentoRecebimento() {
        return this.valorPagamentoRecebimento;
    }
    public void setValorPagamentoRecebimento(float valorPagamentoRecebimento) {
        this.valorPagamentoRecebimento = valorPagamentoRecebimento;
    }

    // Ação específica: Para cartas que têm um efeito ́unico e específico
    public String getAcaoEspecifica() {
        return this.acaoEspecifica;
    }
    public void setAcaoEspecifica(String acaoEspecifica) {
        this.acaoEspecifica = acaoEspecifica;
    }

    // Tempo de aplicação: Se a carta precisa ser usada instantaneamente ou pode ser guardada para uso posterior
    public int getTempoAplicacao() {
        return this.tempoAplicacao;
    }
    public void setTempoAplicacao(int tempoAplicacao) {
        this.tempoAplicacao = tempoAplicacao;
    }

    // Restrições de uso: Se a carta tem alguma restrição de uso
    public String getRestricoesUso() {
        return this.restricoesUso;
    }
    public void setRestricoesUso(String restricoesUso) {
        this.restricoesUso = restricoesUso;
    }

    // Tipo: Se a carta é de sorte ou de revés
    public tipoCarta getTipo() {
        return this.tipo;
    }
    public void setTipo(tipoCarta tipo) {
        this.tipo = tipo;
    }

    // Métodos

    /*
     * Essa função executa a ação da carta de sorte
     */
    public void executaAcao(){
        // Remove ou adiciona dinheiro ao jogador
        super.getDono().setDinheiro((int)(super.getDono().getDinheiro() + this.valorPagamentoRecebimento));

        // Remove a carta do jogador
        super.getDono().removerCarta(this);
    }

    /*
     * Essa função retorna uma string com os dados da carta de sorte no formato:
     * "A carta de sorte [descricao] tem efeito [efeito] e valor de pagamento/recebimento [valorPagamentoRecebimento]."
     * @return: string com os dados da carta de sorte
     */
    public String toString(){
        return "A carta de sorte " + super.getDescricao() + " tem efeito " + this.efeito + " e valor de pagamento/recebimento " + this.valorPagamentoRecebimento + ".";
    }
}
