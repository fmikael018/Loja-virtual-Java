package Persistencia;

import ClassBase.Produto;
import Estoque.Estoque;

import java.io.*;
import java.util.HashMap;

public class Persistencia {

    public static void salvar(Estoque estoque, String arquivo) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(arquivo));
        oos.writeObject(estoque.getProdutos());
        oos.close();
    }

    @SuppressWarnings("unchecked")
    public static void carregar(Estoque estoque, String arquivo) throws IOException, ClassNotFoundException {
        File file = new File(arquivo);
        if (!file.exists()) return;
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(arquivo));
        HashMap<String, Produto> dados = (HashMap<String, Produto>) ois.readObject();
        for (Produto p : dados.values()) {
            estoque.adicionarProduto(p);
        }
        ois.close();
    }
}
