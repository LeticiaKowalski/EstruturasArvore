package Metodos;

import ArvoreAvl.Arvore;

public class Examinar {
	
		private Arvore arvore;
		
		public Examinar(Arvore arvore) {
			setArvore(arvore);
		}
		
		public Arvore getArvore() {
			return arvore;
		}
		
		public void setArvore(Arvore arvore) {
			this.arvore = arvore;
		}
	
		public boolean verificaArvore(Dados e) {
			
			if(getArvore().ehVazio()) {
				return true;
				
			} else {
				
				if(e.getBalanceamento() > 1 || e.getBalanceamento() < -1) {
					return false;
				}
				
				if(e.getDir() != null) verificaArvore(e.getDir());
				if(e.getEsq() != null) verificaArvore(e.getEsq());
			}
			return true;
		}	
}
