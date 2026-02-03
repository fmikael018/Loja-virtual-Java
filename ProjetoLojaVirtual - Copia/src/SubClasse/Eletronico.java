package SubClasse;
import ClassBase.Produto;

public class Eletronico extends Produto {
    public Eletronico(String nome, String descricao, double preco, int quantidade) {
        super(nome, descricao, preco, quantidade);
    }

    @Override
    public String getTipo() {
        return "Eletrônico";
    }
}