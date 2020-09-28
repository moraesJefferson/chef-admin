package br.com.chefAdmin.util;

public enum Categoria {

		SOBREMESAS("Sobremesa"),
		BEBIDAS("Bebida"),
		ENTRADAS("Entrada"),
		SALADAS("Salada"),
		PRATOS("Prato");

		private final String descricao;

		Categoria(String descricao) {
			this.descricao = descricao;
		}

		public String getDescricao() {
			return descricao;
		}
}
