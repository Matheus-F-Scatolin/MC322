/**
 * Exceção para quando o jogador não tem dinheiro suficiente para realizar uma ação.
 */
public class ExcecaoFaltaDeDinheiro extends Exception{
    public ExcecaoFaltaDeDinheiro(){
        super("Você não tem dinheiro suficiente para realizar essa ação.");
    }
}
