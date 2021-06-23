package Metodos;

public class Dados {

			private int valor;
			private int balanceamento;
			private Dados aux;
			private Dados direita;
			private Dados esquerda;

			public Dados(int valor){
			    this.direita = null;
			    this.esquerda = null;
			    this.aux = null;
			    this.valor = valor;
			}

			public int getValor() {
				return valor;
			}
			public void setValor(int valor) {
				this.valor = valor;
			}
			
			public Dados getPai() {
				return aux;
			}
			public void setPai(Dados pai) {
				this.aux = pai;
			}

			public Dados getDir() {
				return direita;
			}
			public void setDir(Dados dir) {
				this.direita = dir;
			}

			public Dados getEsq() {
				return esquerda;
			}
			public void setEsq(Dados esq) {
				this.esquerda = esq;
			}

			public int getBalanceamento() {
				return balanceamento;
			}
			public void setBalanceamento(int balanceamento) {
				this.balanceamento = balanceamento;
			}
}
