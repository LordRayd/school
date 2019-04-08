package afd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * Interpréteur d'expressions arithmétiques en Notation Polonaise Inversée
 */
public class NPI {

	/**
	 * Construction de l'automate pour la NPI
	 * 
	 * @return l'automate créé et complété (A COMPLETER)
	 */
	static AFD build_AFD() {
		AFD afd = new AFD(9);

		try {
			afd.setInitial(0);
			afd.setFinal(8);

			afd.addTransition(0, ' ', 0, 0);
			afd.addTransition(0, '-', 1, 0);
			afd.addTransition(0, '1', 2, 1);
			afd.addTransition(0, '2', 2, 1);
			afd.addTransition(0, '3', 2, 1);
			afd.addTransition(0, '4', 2, 1);
			afd.addTransition(0, '5', 2, 1);
			afd.addTransition(0, '6', 2, 1);
			afd.addTransition(0, '7', 2, 1);
			afd.addTransition(0, '8', 2, 1);
			afd.addTransition(0, '9', 2, 1);
			afd.addTransition(0, '0', 3, 1);
			afd.addTransition(0, '+', 6, 11);
			afd.addTransition(0, '*', 6, 13);
			afd.addTransition(0, '/', 6, 15);
			afd.addTransition(0, '\n', 7, 8);
			afd.addTransition(0, '#', 8, 0);

			afd.addTransition(1, ' ', 0, 9);
			afd.addTransition(1, '1', 2, 5);
			afd.addTransition(1, '2', 2, 5);
			afd.addTransition(1, '3', 2, 5);
			afd.addTransition(1, '4', 2, 5);
			afd.addTransition(1, '5', 2, 5);
			afd.addTransition(1, '6', 2, 5);
			afd.addTransition(1, '7', 2, 5);
			afd.addTransition(1, '8', 2, 5);
			afd.addTransition(1, '9', 2, 5);
			afd.addTransition(1, '\n', 7, 8);
			afd.addTransition(1, '#', 8, 0);

			afd.addTransition(2, ' ', 0, 6);
			afd.addTransition(2, '0', 2, 2);
			afd.addTransition(2, '1', 2, 2);
			afd.addTransition(2, '2', 2, 2);
			afd.addTransition(2, '3', 2, 2);
			afd.addTransition(2, '4', 2, 2);
			afd.addTransition(2, '5', 2, 2);
			afd.addTransition(2, '6', 2, 2);
			afd.addTransition(2, '7', 2, 2);
			afd.addTransition(2, '8', 2, 2);
			afd.addTransition(2, '9', 2, 2);
			afd.addTransition(2, ',', 4, 0);
			afd.addTransition(2, '\n', 7, 8);
			afd.addTransition(2, '#', 8, 0);

			afd.addTransition(3, ' ', 0, 6);
			afd.addTransition(3, ',', 4, 0);
			afd.addTransition(3, '\n', 7, 8);
			afd.addTransition(3, '#', 8, 0);

			afd.addTransition(4, '0', 5, 3);
			afd.addTransition(4, '1', 5, 3);
			afd.addTransition(4, '2', 5, 3);
			afd.addTransition(4, '3', 5, 3);
			afd.addTransition(4, '4', 5, 3);
			afd.addTransition(4, '5', 5, 3);
			afd.addTransition(4, '6', 5, 3);
			afd.addTransition(4, '7', 5, 3);
			afd.addTransition(4, '8', 5, 3);
			afd.addTransition(4, '9', 5, 3);
			afd.addTransition(4, '#', 8, 0);

			afd.addTransition(5, ' ', 0, 6);
			afd.addTransition(5, '0', 5, 4);
			afd.addTransition(5, '1', 5, 4);
			afd.addTransition(5, '2', 5, 4);
			afd.addTransition(5, '3', 5, 4);
			afd.addTransition(5, '4', 5, 4);
			afd.addTransition(5, '5', 5, 4);
			afd.addTransition(5, '6', 5, 4);
			afd.addTransition(5, '7', 5, 4);
			afd.addTransition(5, '8', 5, 4);
			afd.addTransition(5, '9', 5, 4);
			afd.addTransition(5, '\n', 7, 8);
			afd.addTransition(5, '#', 8, 0);

			afd.addTransition(6, ' ', 0, 0);
			afd.addTransition(6, '\n', 7, 8);
			afd.addTransition(6, '#', 8, 0);

			afd.addTransition(7, '#', 8, 0);

		} catch (AFDException e) {
			System.err.println(e.getMessage());
			System.exit(1);
		}
		afd.toDot(); // pour debug
		return afd;
	}

	static Stack<Double> pile; // pile des valeurs
	static AFD automate; // l'automate
	static BufferedReader console; // le lecteur sur la console

	/**
	 * Programme principal
	 * 
	 * @param args pas de paramètre sur la ligne de commande
	 */
	public static void main(String[] args) {

		// initialisation
		BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

		// A COMPLETER
		pile = new Stack<Double>();
		double decimale = 0.01;
		double nombre = 0.0;
		boolean erreur = false;
		automate = build_AFD();

		do {// boucle sur la lecture des symboles
			char symb = ' '; // symbole lu
			try {
				symb = (char) console.read();
			} catch (IOException e) {
				System.out.println("char prob lecture");
				System.exit(1);
			}
			int a = 0; // numéro de l'action a executer

			// execution de la transition
			try {
				a = automate.makeTransition(symb);
			} catch (AFDException e) {
				System.err.println(e.getMessage());
				System.exit(1);
			}

			switch (a) { // execution de l'action no a
			case 0: // rien à faire
				break;
			case 1: // premier chiffre de la partie entière
				nombre = (symb-48);
				break;
			case 2: // chiffre suivant de la partie entière
				nombre = nombre * 10 + (symb-48);
				break;
			case 3: // premier chiffre de la partie décimale
				nombre = nombre + 0.1 * (symb-48);
				break;
			case 4: // chiffre suivant de la partie décimale
				nombre = nombre + decimale * (symb-48);
				decimale = decimale * 0.1;
				break;
			case 5: // premier chiffre de la partie entière suivant un '-'
				nombre = (symb-48);
				nombre = - nombre;
				break;
			case 6: // valeur décimale empilée
				pile.push(nombre);
				break;
			case 7: // valeur décimale empilée et affichage du sommet de pile
				pile.push(nombre);
				System.out.println("Sommet Pile : "+ pile.peek());
				break;
			case 8: // affichage du sommet de pile et du prompt
				if(!erreur){
					if(pile.size() == 1){
						System.out.println("Resultat Calcul : "+ pile.peek());
					}else{
						System.out.println("Pas assez d operateur");
					}
				}
				break;
			case 9: // soustraction
				if(pile.size()>= 2){
					pile.push(pile.pop() - pile.pop());
				}else{
					System.out.println("Pas assez de nombre ");
					symb = '\n';
					erreur = true;
				}
				break;
			case 10: // soustraction et affichage
				if(pile.size()>= 2){
					pile.push(pile.pop() - pile.pop());
					System.out.println("Sommet Pile : "+ pile.peek());
				}else{
					System.out.println("Pas assez de nombre ");
					symb = '\n';
					erreur = true;
				}
				break;
			case 11: // addition
				if(pile.size()>= 2){
					pile.push(pile.pop() + pile.pop());
				}else{
					System.out.println("Pas assez de nombre ");
					symb = '\n';
					erreur = true;
				}
				break;
			case 12: // addition et affichage
				if(pile.size()>= 2){
					pile.push(pile.pop() + pile.pop());
					System.out.println("Sommet Pile : "+ pile.peek());
				}else{
					System.out.println("Pas assez de nombre ");
					symb = '\n';
					erreur = true;
				}
				break;
			case 13: // multiplication
				if(pile.size()>= 1){
					pile.push(pile.pop() * pile.pop());
				}else{
					System.out.println("Pas assez de nombre ");
					symb = '\n';
					erreur = true;
				}
				break;
			case 14: // multiplication et affichage
				if(pile.size()>= 2){
					pile.push(pile.pop() * pile.pop());
					System.out.println("Sommet Pile : "+ pile.peek());
				}else{
					System.out.println("Pas assez de nombre ");
					symb = '\n';
					erreur = true;
				}
				break;
			case 15: // division
				if(pile.size()>= 2){
					pile.push(pile.pop() / pile.pop());
				}else{
					System.out.println("Pas assez de nombre ");
					symb = '\n';
					erreur = true;
				}
				break;
			case 16: // division et affichage
				if(pile.size()>= 2){
					pile.push(pile.pop() / pile.pop());
					System.out.println("Sommet Pile : "+ pile.peek());
				}else{
					System.out.println("Pas assez de nombre ");
					symb = '\n';
					erreur = true;
				}
				break;
			}

			if(symb == '\n'){
				pile = new Stack<Double>();
				erreur = false;
				try{
					automate.reset();
				}catch(AFDException e) {
					System.err.println(e.getMessage());
					System.exit(1);
				}
			}
		} while (!automate.isFinal()); // tant que l'on atteint pas un état final	
		System.out.println("Fin du programme");
	}
}
