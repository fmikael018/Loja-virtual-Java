package SubClasse;
import ClassBase.Produto;

public class Roupa extends Produto {
    public Roupa(String nome, String descricao, double preco, int quantidade) {
        super(nome, descricao, preco, quantidade);
    }

    @Override
    public String getTipo() {
        return "Roupa";
    }
}