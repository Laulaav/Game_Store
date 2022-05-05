package com.gamestore.gamestore.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name= "tb_produto")
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotBlank(message="O nome do produto é obrigatório!!")
	@Size(max=150, message= "O nome deve ter no máximo 150 caracteres!!")
	private String nome;
	
	@Size(max= 1000, message= "A descrição deve conter no máximo 1000 caracteres!!")
	private String descricao;
	
	@JsonFormat(shape= JsonFormat.Shape.STRING)
	@Positive(message= "Digite um valor maior que zero")
	private BigDecimal preco;
	
	@NotBlank(message= "A produtora do jogo é obrigatória")
	@Size(max= 200, message = "A produtora deve conter no máximo 200 caracteres!!")
	private String produtora;
	
	@NotBlank(message= "A classificação indicativa é obrigatória!!")
	@Size(max= 10, message= "A classificação indicativa deve conter no máximo 10 caracteres!!")
	private String classificacaoInd;
	
	@ManyToOne
	@JsonIgnoreProperties("produto")
	private Categoria categoria;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public String getProdutora() {
		return produtora;
	}

	public void setProdutora(String produtora) {
		this.produtora = produtora;
	}

	public String getClassificacaoInd() {
		return classificacaoInd;
	}

	public void setClassificacaoInd(String classificacaoInd) {
		this.classificacaoInd = classificacaoInd;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	
}
