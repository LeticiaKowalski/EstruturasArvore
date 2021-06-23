package ArvoreAvl;

import java.util.ArrayDeque;
import java.util.Deque;

import Metodos.Dados;

public class Arvore {
	
			private Dados raiz;

			public Arvore() {
				this.raiz = null;
			}

			public Dados getRaiz() {
				return raiz;
			}

			public boolean ehVazio() {
				return this.raiz == null;
			}

			public boolean inserir(int valor, Dados raiz) {
				
				if (ehVazio()) {													
					Dados novo = new Dados(valor);
					this.raiz = novo;
					defineFatorBalanceamento(this.raiz);
					
				} else {
					
					if (valor > raiz.getValor()) {
						
						if (raiz.getDir() == null) {
							Dados novo = new Dados(valor);
							raiz.setDir(novo);
							novo.setPai(raiz);
							defineFatorBalanceamento(this.raiz);								
							this.raiz = balanceamento(this.raiz);
							
						} else { 													
							inserir(valor, raiz.getDir());
						}
						
					} else if (valor < raiz.getValor()) {
						
						if (raiz.getEsq() == null) {
							Dados novo = new Dados(valor);
							raiz.setEsq(novo);
							novo.setPai(raiz);
							defineFatorBalanceamento(this.raiz);									
							this.raiz = balanceamento(this.raiz);
							
						} else {
							inserir(valor, raiz.getEsq());
						}
					} else {													
						return false;
					}
				}
				return true;
			}
			
			public Dados remover(int valor, Dados raiz) {
				
				if (ehVazio()) {											
					System.out.println("A árvore está vazia!");	
					
				} else if (valor > raiz.getValor()) {	
					raiz.setDir(remover(valor, raiz.getDir()));
					
				} else if (valor < raiz.getValor()) {						
					raiz.setEsq(remover(valor, raiz.getEsq()));
					
				} else {								
					
					if (raiz.getDir() == null && raiz.getEsq() == null) {
						
						if (raiz == this.raiz) {
							this.raiz = null;
							
						} else {
							raiz = null;
						}
						
					} else if (raiz.getEsq() == null) {															
						raiz = raiz.getDir();
						
					} else if (raiz.getDir() == null) {																
						raiz = raiz.getEsq();
						
					} else {
						Dados aux = raiz.getEsq();
						
						while (aux.getDir() != null) {
							aux = aux.getDir();
						}
						
						raiz.setValor(aux.getValor()); 
						aux.setValor(valor); 
						raiz.setEsq(remover(valor, raiz.getEsq()));
					}
				}
				
				if (this.raiz != null) {
					defineFatorBalanceamento(this.raiz);
					this.raiz = balanceamento(this.raiz);
				}
				
				return raiz;
			}
			
			public void imprimeArvore(Dados e) {
				
				if (ehVazio()) {
					System.out.println("A árvore está vazia!");
					
				} else {
					System.out.println("*Dado: " + e.getValor() + " *FB do dado: " + e.getBalanceamento());
					
					if (e.getDir() != null) {
						imprimeArvore(e.getDir());
					}
					
					if (e.getEsq() != null) {
						imprimeArvore(e.getEsq());
					}
				}
			}

			public String printArvore(int k, Dados e) {
				
				if(ehVazio()) {
					return ("A árvore está vazia!");
					
				} else {
					String str = toStr(e)+"\n";
					
					for(int i = 0; i < k; i++) {
						str += "\t";
					}
					if(e.getEsq() != null) {
						str += "+-ESQUERDA: " + printArvore(k + 1, e.getEsq());
					} else {
						str += "+-ESQUERDA: Valor Nulo";
					}
					str += "\n";
					
					for(int i = 0; i < k; i++) {
						str += "\t";
					}
					if(e.getDir() != null) {	
						str += "+-DIREITA: " + printArvore(k + 1, e.getDir());
					} else {
						str += "+-DIREITA: Valor Nulo";
					}
					str += "\n";
					return str;
				}
			}
			
			public String toStr(Dados e) {
				return ("[" + e.getValor() + "] FB(" + e.getBalanceamento() + ")");
			}
			
			public String caminharNiveis(Dados e) {
				String msg = "";
				
				if(ehVazio()) {
					return ("A árvore está vazia!");
					
				} else {
					
					Deque<Dados> lista = new ArrayDeque<>();
					lista.add(e);
					
					while(!lista.isEmpty()) {
						
						Dados aux = lista.removeFirst();
						msg += aux.getValor() + " ";
						
						if(aux.getEsq() != null) {
							lista.add(aux.getEsq());
						}
						
						if(aux.getDir() != null) {
							lista.add(aux.getDir());
						}
					}
				}
				return msg;
			}
			
			public int alturaElemento(Dados e) {
				
				if (e == null) {
					return -1;
				}
				
				if (e.getDir() == null && e.getEsq() == null) {
					return 0;
					
				} else if (e.getEsq() == null) {
					return 1 + alturaElemento(e.getDir());
					
				} else if (e.getDir() == null) {
					return 1 + alturaElemento(e.getEsq());
					
				} else { 
					
					if (alturaElemento(e.getEsq()) > alturaElemento(e.getDir())) {
						return 1 + alturaElemento(e.getEsq());
						
					} else {
						return 1 + alturaElemento(e.getDir());
					}
				}
			}

			public void defineFatorBalanceamento(Dados e) {
				
				e.setBalanceamento(alturaElemento(e.getEsq()) - alturaElemento(e.getDir()));
				
				if (e.getDir() != null) {
					defineFatorBalanceamento(e.getDir());
				}
				
				if (e.getEsq() != null) {
					defineFatorBalanceamento(e.getEsq());
				}
			}
			
			public Dados rotacaoSimplesDireita(Dados e) {
				
				Dados aux = e.getEsq(); 
				aux.setPai(e.getPai());
				
				if (aux.getDir() != null) {
					aux.getDir().setPai(e);
				}
				
				e.setPai(aux);
				e.setEsq(aux.getDir());
				aux.setDir(e);
				
				if (aux.getPai() != null) {
					
					if (aux.getPai().getDir() == e) {
						
						aux.getPai().setDir(aux);
						
					} else if (aux.getPai().getEsq() == e) {
						aux.getPai().setEsq(aux);
					}
				}
				
				defineFatorBalanceamento(aux);
				return aux; 
			}

			public Dados rotacaoSimplesEsquerda(Dados e) {
				
				Dados aux = e.getDir();
				aux.setPai(e.getPai());
				
				if (aux.getEsq() != null) {
					aux.getEsq().setPai(e);
				}

				e.setPai(aux);
				e.setDir(aux.getEsq());
				aux.setEsq(e);
				
				if (aux.getPai() != null) {
					
					if (aux.getPai().getDir() == e) {
						aux.getPai().setDir(aux);
						
					} else if (aux.getPai().getEsq() == e) {
						aux.getPai().setEsq(aux);
					}
				}
				
				defineFatorBalanceamento(aux);
				return aux;
			}

			public Dados rotacaoDuplaDireita(Dados e) {
				Dados aux = e.getEsq();
				e.setEsq(rotacaoSimplesEsquerda(aux));
				Dados aux2 = rotacaoSimplesDireita(e); 
				return aux2;
			}

			public Dados rotacaoDuplaEsquerda(Dados e) {
				Dados aux = e.getDir();
				e.setDir(rotacaoSimplesDireita(aux));
				Dados aux2 = rotacaoSimplesEsquerda(e);
				return aux2;
			}

			public Dados balanceamento(Dados raiz) {
				
				if (raiz.getBalanceamento() == 2 && raiz.getEsq().getBalanceamento() >= 0) {
					raiz = rotacaoSimplesDireita(raiz);
					
				} else if (raiz.getBalanceamento() == -2 && raiz.getDir().getBalanceamento() <= 0) { 
					raiz = rotacaoSimplesEsquerda(raiz);
					
				} else if (raiz.getBalanceamento() == 2 && raiz.getEsq().getBalanceamento() < 0) {
					raiz = rotacaoDuplaDireita(raiz);
					
				} else if (raiz.getBalanceamento() == -2 && raiz.getDir().getBalanceamento() > 0) {
					raiz = rotacaoDuplaEsquerda(raiz);
				}
				
				if (raiz.getDir() != null) {
					balanceamento(raiz.getDir());
				}
				
				if (raiz.getEsq() != null) {
					balanceamento(raiz.getEsq());
				}
				
				return raiz;
			}
}
