package Estoque;
import ClassBase.Produto;
import java.util.HashMap;

public class Estoque {
    private HashMap<String, Produto> produtos = new HashMap<>();

    public void adicionarProduto(Produto novoProduto) {
        String nome = novoProduto.getNome();

        if (produtos.containsKey(nome)) {
            Produto existente = produtos.get(nome);

            // Verifica se são do mesmo tipo para evitar misturar produtos diferentes com mesmo nome
            if (existente.getClass() == novoProduto.getClass()) {
                int novaQuantidade = existente.getQuantidadeEstoque() + novoProduto.getQuantidadeEstoque();
                existente.setQuantidadeEstoque(novaQuantidade);
                System.out.println("Produto já existe. Estoque atualizado com nova quantidade.");
            } else {
                System.out.println("Erro: Produto com mesmo nome mas tipo diferente já existe.");
            }
        } else {
            produtos.put(nome, novoProduto);
            System.out.println("Novo produto adicionado ao estoque.");
        }
    }

    public Produto buscarProduto(String nome) throws Exception{
        if(!produtos.containsKey(nome)) {
            throw new Exception("Produto não encontrado.");
        }
        return produtos.get(nome);
    }
     public void atualizarEstoque(String nome, int novaQuantidade) throws Exception{
        Produto p = buscarProduto(nome);
        p.setQuantidadeEstoque(novaQuantidade);
     }

     public HashMap<String, Produto> getProdutos(){
        return produtos;
     }
}
