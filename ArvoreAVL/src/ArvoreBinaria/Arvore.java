package ArvoreBinaria;

import Metodos.Dados;

public class Arvore {
	
		private Dados aux;
		private Arvore direita;
		private Arvore esquerda;
		private int quant;
	
		public Arvore() {
			setAux(null);
			setDireita(null);
			setEsquerda(null);
			setQuant(0);
		}
		
		public Arvore(Dados aux) {
			setAux(aux);
			setDireita(null);
			setEsquerda(null);
			setQuant(0);
		}

		public Dados getAux() {
			return aux;
		}
		
		public void setAux(Dados aux) {
			this.aux = aux;
		}
		
		public Arvore getDireita() {
			return direita;
		}
		
		public void setDireita(Arvore direita) {
			this.direita = direita;
		}
		
		public Arvore getEsquerda() {
			return esquerda;
		}
		public void setEsquerda(Arvore esquerda) {
			this.esquerda = esquerda;
		}
		
		public int getQuant() {
			return quant;
		}
		
		public void setQuant(int quant) {
			this.quant = quant;
		}
		
		public boolean ehVazio() {
			return (this.aux == null);
		}
		
		public void inserir(Dados aux) {
			
			if(ehVazio()) {
				this.aux = aux;
				
			} else {
				Arvore arvore = new Arvore(aux);
				
				if (aux.getValor() < this.aux.getValor()) {
					
					if(this.esquerda == null) {
						this.esquerda = arvore;
						
					} else {
						this.esquerda.inserir(aux);
					}
					
				} else if(aux.getValor() > this.aux.getValor()) {
					
					if(this.direita == null) {
						this.direita = arvore;
						
					} else {
						this.direita.inserir(aux);
					}
				}
			}
			this.quant++;
		}

		public Arvore remover(Dados aux) {
			
			if(this.aux.getValor() == aux.getValor()) {
				
				if(this.esquerda == null && this.direita == null) {
					return null;
					
				} else if(this.esquerda != null && this.direita == null) {
					return this.esquerda;
					
				} else if(this.esquerda == null && this.direita != null) {
					return this.direita;
					
				} else {
					Arvore aux1 = this.esquerda;
					
					while(aux1.direita != null) {
						aux1 = aux1.direita;
					}
					
					this.aux = aux1.getAux();
					aux1.setAux(aux);
					this.esquerda = esquerda.remover(aux);	
				}
				
			} else if(aux.getValor() < this.aux.getValor()) {
				this.esquerda = this.esquerda.remover(aux);
				
			} else if(aux.getValor() > this.aux.getValor()) {
				this.direita = this.direita.remover(aux);
			}
			this.quant--;
			return this;
		}
		
		public boolean buscar(int valor) {
			
			if(ehVazio()) {
				return false;
				
			} else {
				if(this.aux.getValor() == valor) {
					return true;
					
				} else if(valor < this.aux.getValor()) {
					
					if(this.esquerda == null) {
						return false;
						
					} else {
						return this.esquerda.buscar(valor);
					}
					
				} else if(valor > this.aux.getValor()) {
					
					if(this.direita == null) {
						return false;
						
					} else {
						return this.direita.buscar(valor);
					}
				}
			}
			return false;
		}
		
		public int calculaAltura() {
			
			if(this.esquerda == null && this.direita == null) {
				return 1;
				
			} else if(this.esquerda != null && this.direita == null) {
				return (1 + this.esquerda.calculaAltura());
				
			} else if(this.esquerda == null && this.direita != null) {
				return (1+ this.direita.calculaAltura());
				
			} else {
				return 1 + Math.max(this.esquerda.calculaAltura(), this.direita.calculaAltura());
			}
		}
		
		private int auxi;
		public void setBal(int auxi) {
			this.auxi = auxi;
		}
		
		public int getBal() {
			return auxi;
		}
		
		public void calculaBalanceamento() {
			
			if(this.direita == null && this.esquerda == null) {
				setBal(0);
				
			} else if(this.esquerda == null && this.direita != null) {
				setBal(this.direita.calculaAltura() - 0);
				
			} else if(this.esquerda != null && this.direita == null) {
				setBal(0 - this.esquerda.calculaAltura());
				
			} else {
				setBal(this.direita.calculaAltura() - this.esquerda.calculaAltura());
			}
			
			if(this.direita != null) {
				this.direita.calculaBalanceamento();
			}
			
			if(this.esquerda != null) {
				this.esquerda.calculaBalanceamento();
			}
		}
}
