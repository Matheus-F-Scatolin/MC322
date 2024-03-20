public class CartaSorte {
    // Atributos da carta de sorte
    private int id;
    private String descricao;
    private int movimentoTabuleiro;
    private int efeito;
    private float valorPagamentoRecebimento;
    private String acaoEspecifica;
    private int tempoAplicacao;
    private String restricoesUso;

    // Construtor da carta de sorte
    public CartaSorte(int id, String descricao, int movimentoTabuleiro, int efeito, float valorPagamentoRecebimento, String acaoEspecifica, int tempoAplicacao, String restricoesUso) {
        this.id = id;
        this.descricao = descricao;
        this.movimentoTabuleiro = movimentoTabuleiro;
        this.efeito = efeito;
        this.valorPagamentoRecebimento = valorPagamentoRecebimento;
        this.acaoEspecifica = acaoEspecifica;
        this.tempoAplicacao = tempoAplicacao;
        this.restricoesUso = restricoesUso;
    }

    // Getters e Setters

    // Id: identificador único
    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
    }

    // Descrição: nome da carta
    public String getDescricao() {
        return this.descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

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

    // Métodos

    /*
     * Essa função retorna uma string com os dados da carta de sorte no formato:
     * "A carta de sorte [descricao] tem efeito [efeito] e valor de pagamento/recebimento [valorPagamentoRecebimento]."
     * @return: string com os dados da carta de sorte
     */
    public String toString(){
        return "A carta de sorte " + this.descricao + " tem efeito " + this.efeito + " e valor de pagamento/recebimento " + this.valorPagamentoRecebimento + ".";
    }
}
