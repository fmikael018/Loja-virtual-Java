package SubClasse;
import ClassBase.Produto;

public class Livro extends Produto {
    public Livro(String nome, String descricao, double preco, int quantidade) {
        super(nome, descricao, preco, quantidade);
    }

    @Override
    public String getTipo() {
        return "Livro";
    }
}