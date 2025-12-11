package com.pauloaviila.estoque_api.model;

//Mapeamento Objeto-Relacional (ORM)

import jakarta.persistence.*; // Importa as anotações mágicas

@Entity // Diz pro Spring: "Isso aqui vai virar uma tabela no MySQL"
@Table(name = "tb_itens") // define o nome da tabela
public class Item {

    @Id // Diz que esse é a Chave Primária (PK)
    @GeneratedValue(strategy = GenerationType.IDENTITY) // (Auto Increment)
    private Long id;

    private String nome;
    private String categoria;
    private int quantidade;
    private String filial;

    // Construtor Vazio 
    public Item() {}

    // Construtor Cheio 
    public Item(String nome, String categoria, int quantidade) {
        this.nome = nome;
        this.categoria = categoria;
        this.quantidade = quantidade;
    }

    // Getters e Setters (Botão direito -> Source -> Generate Getters and Setters)
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }

    public int getQuantidade() { return quantidade; }
    public void setQuantidade(int quantidade) { this.quantidade = quantidade; }

	public String getFilial() {
		return filial;
	}

	public void setFilial(String filial) {
		this.filial = filial;
	}
    
    
}