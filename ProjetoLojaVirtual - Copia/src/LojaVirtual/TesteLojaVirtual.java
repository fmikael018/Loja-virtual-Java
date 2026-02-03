package LojaVirtual;

import ClassBase.Produto;
import Estoque.Estoque;
import InterfaceLoja.InterfaceLoja;
import Persistencia.Persistencia;
import SubClasse.Eletronico;
import SubClasse.Livro;
import SubClasse.Roupa;

public class TesteLojaVirtual {
    public static void main(String[] args) {
        Estoque estoque = new Estoque();

        try {
            Persistencia.carregar(estoque, "produtos.dat");

            if (estoque.getProdutos().isEmpty()) {
                adicionarProdutosExemplo(estoque);
                System.out.println("Produtos de exemplo adicionado.");
            } else {
                System.out.println("Produtos carregados do arquivo.");
            }

        } catch (Exception e) {
            System.out.println("Erro ao carregar produtos. Adicionando produtos de exemplo...");
            adicionarProdutosExemplo(estoque);
        }

        InterfaceLoja interfaceLoja = new InterfaceLoja(estoque);
        interfaceLoja.iniciar();

        try {
            Persistencia.salvar(estoque, "produtos.dat");
            System.out.println("Produtos salvos com sucesso.");
        } catch (Exception e) {
            System.out.println("Erro ao salvar os produtos.");
        }
    }

    public static void adicionarProdutosExemplo(Estoque estoque) {
            estoque.adicionarProduto(new Eletronico("Smartphone", "Android 128GB", 1500.0, 10));
            estoque.adicionarProduto(new Eletronico("Notebook", "Intel i5 8GB RAM", 3500.0, 5));
            estoque.adicionarProduto(new Roupa("Camiseta", "Algodão M", 50.0, 20));
            estoque.adicionarProduto(new Roupa("Calça Jeans", "Tamanho 42", 120.0, 15));
            estoque.adicionarProduto(new Livro("Java Básico", "Introdução ao Java", 80.0, 8));
            estoque.adicionarProduto(new Livro("Dom Casmurro", "Machado de Assis", 60.0, 12));
    }
}

