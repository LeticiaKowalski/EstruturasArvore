package Main;

import ArvoreAvl.Arvore;
import Metodos.Compara;
import Metodos.Examinar;

public class PrincipalAvl {

	public static void main(String[] args) {
		
		Arvore arvore = new Arvore();

		arvore.inserir(10, arvore.getRaiz());
		arvore.inserir(13, arvore.getRaiz());
		arvore.inserir(9, arvore.getRaiz());
		arvore.inserir(3, arvore.getRaiz());
		arvore.inserir(14, arvore.getRaiz());
		arvore.inserir(6, arvore.getRaiz());
		arvore.inserir(1, arvore.getRaiz());

		System.out.println("Dados existentes na árvore: ");
		arvore.imprimeArvore(arvore.getRaiz());
		
		System.out.println("\nEstrutura da árvore AVL: ");
		System.out.println(arvore.printArvore(0, arvore.getRaiz()));

		arvore.remover(14, arvore.getRaiz());
		arvore.remover(1, arvore.getRaiz());

		System.out.println("Formação da árvore após exclusão dos elementos 14 e 1: ");
		arvore.imprimeArvore(arvore.getRaiz());

		System.out.println("\nEstrutura da árvore AVL: ");
		System.out.println(arvore.printArvore(0, arvore.getRaiz()));

		System.out.print("\nVerifica se a árvore é AVL:  ");
		Examinar vAvl = new Examinar(arvore);
		System.out.println(vAvl.verificaArvore(arvore.getRaiz()));
		
		Arvore arvore2 = new Arvore();
		arvore2.inserir(2, arvore2.getRaiz());
		arvore2.inserir(16, arvore2.getRaiz());
		arvore2.inserir(9, arvore2.getRaiz());
		arvore2.inserir(8, arvore2.getRaiz());
		arvore2.inserir(1, arvore2.getRaiz());
		
		System.out.print("Caminhamento por níveis: ");
		System.out.print(arvore.caminharNiveis(arvore.getRaiz()));
		
		Compara compara = new Compara(arvore, arvore2);
		System.out.println("\nVerifica se as árvores são iguais: " + compara.validaArvoreAVL());

	}

}

