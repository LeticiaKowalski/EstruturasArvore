package Main;

import ArvoreBinaria.Arvore;
import Metodos.Dados;

public class PrincipalBinario {

	public static void main(String[] args) {
		
			Arvore narvore = new Arvore();
			
			narvore.inserir(new Dados(10));
			narvore.inserir(new Dados(13));
			narvore.inserir(new Dados(9));
			narvore.inserir(new Dados(3));
			narvore.inserir(new Dados(14));
			narvore.inserir(new Dados(6));
			narvore.inserir(new Dados(12));
			
			System.out.println(narvore.calculaAltura());
			System.out.println(narvore.getBal());
		}
}
