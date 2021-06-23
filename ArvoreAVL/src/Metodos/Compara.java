package Metodos;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import ArvoreAvl.Arvore;

public class Compara {

		private Arvore avl1;
		private Arvore avl2;
		
		public Compara(Arvore avl1, Arvore avl2) {
			setAv1(avl1);
			setAv2(avl2);
		}
		
		public Arvore getAv1() {
			return avl1;
		}
		public void setAv1(Arvore avl1) {
			this.avl1 = avl1;
		}
		
		public Arvore getAv2() {
			return avl2;
		}
		
		public void setAv2(Arvore avl2) {
			this.avl2 = avl2;
		}
		
		public boolean validaArvoreAVL() {	
			
			if(verificaEhVazio() || verificaRaiz() && verificaSubDir() && verificaSubEsq()) {
				return true;
				
			} else {
				return false;
			}
		}
		
		public boolean verificaEhVazio() {
			
			if(avl1.ehVazio() && avl2.ehVazio()) {
				return true;
			} else {
				
				return false;
			}
		}
		
		public boolean verificaRaiz() {
			if(avl1.getRaiz().getValor() == avl2.getRaiz().getValor()) {
				return true;
				
			} else {
				return false;
			}
		}
		
		public boolean verificaSubEsq() {
			
			List<Integer> lista1 = new ArrayList<>();
			List<Integer> lista2 = new ArrayList<>();
			
			if(!getAv1().ehVazio() && !getAv2().ehVazio()) {
				
				Deque<Dados> esquerda1 = new ArrayDeque<>();
				Dados e1 = getAv1().getRaiz().getEsq();
				esquerda1.add(e1);
				
				while(!esquerda1.isEmpty()) {
					
					Dados aux1 = esquerda1.removeFirst();
					lista1.add(aux1.getValor());
					
					if(aux1.getEsq() != null) esquerda1.add(aux1.getEsq());
					if(aux1.getDir() != null) esquerda1.add(aux1.getDir());
	 			}
				
				Deque<Dados> esquerda2 = new ArrayDeque<>();
				Dados e2 = getAv2().getRaiz().getEsq();
				esquerda2.add(e2);
				
				while(!esquerda2.isEmpty()) {
					
					Dados aux2 = esquerda2.removeFirst();
					lista2.add(aux2.getValor());
					
					if(aux2.getEsq() != null) esquerda2.add(aux2.getEsq());
					if(aux2.getDir() != null) esquerda2.add(aux2.getDir());
				}
				
				if(lista1.equals(lista2) && lista2.equals(lista1)) {
					
					return true;
				} else {
					
					return false;
				}
			} else {
				
				return false;
			} 
		}
		
		public boolean verificaSubDir() {
			
			List<Integer> lista1 = new ArrayList<>();
			List<Integer> lista2 = new ArrayList<>();
			
			if(!getAv1().ehVazio() && !getAv2().ehVazio()) {
				
				Deque<Dados> direita1 = new ArrayDeque<>();
				Dados e1 = getAv1().getRaiz().getDir();
				direita1.add(e1);
				
				while(!direita1.isEmpty()) {
					
					Dados aux1 = direita1.removeFirst();
					lista1.add(aux1.getValor());
					
					if(aux1.getEsq() != null) direita1.add(aux1.getEsq());
					if(aux1.getDir() != null) direita1.add(aux1.getDir());
	 			}
				
				Deque<Dados> direita2 = new ArrayDeque<>();
				Dados e2 = getAv2().getRaiz().getDir();
				direita2.add(e2);
				
				while(!direita2.isEmpty()) {
					
					Dados aux2 = direita2.removeFirst();
					lista2.add(aux2.getValor());
					
					if(aux2.getEsq() != null) direita2.add(aux2.getEsq());
					if(aux2.getDir() != null) direita2.add(aux2.getDir());
				}
				
				if(lista1.equals(lista2) && lista2.equals(lista1)) {
					return true;
					
				} else {
					return false;
				}
				
			} else {
				return false;
			} 
		}
}
