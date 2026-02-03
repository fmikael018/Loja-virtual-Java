package Pedido;
import ClassBase.Produto;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private String cliente;
    private List<ItemPedido> itens;

    public Pedido(String cliente) {
        this.cliente = cliente;
        this.itens = new ArrayList<>();
    }

    public void adicionarItem(Produto produto, int quantidade) {
        itens.add(new ItemPedido(produto, quantidade));
    }

    public double calcularTotal() {
        return itens.stream().mapToDouble(ItemPedido::getSubtotal).sum();
    }

    public String getCliente() {
        return cliente;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }
}