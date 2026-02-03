package ClassBase;
import java.io.Serializable;

public abstract class Produto implements Serializable {
    private String Nome;
    private String Descricao;
    private double Preco;
    private int QuantidadeEstoque;

    public Produto(String nome, String Descricao, double Preco, int QuantidadeEstoque){
        this.Nome = nome;
        this.Descricao = Descricao;
        this.Preco = Preco;
        this.QuantidadeEstoque = QuantidadeEstoque;
    }

    public String getNome() {
        return Nome;
    }

    public String getDescricao() {
        return Descricao;
    }

    public double getPreco() {
        return Preco;
    }

    public int getQuantidadeEstoque() {
        return QuantidadeEstoque;
    }

    public void setQuantidadeEstoque(int QuantidadeEstoque) {
        if(QuantidadeEstoque >= 0)
            this.QuantidadeEstoque = QuantidadeEstoque;
    }
    public abstract String getTipo();
}