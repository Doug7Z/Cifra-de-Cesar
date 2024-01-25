package cifra;

import java.util.ArrayList;

public class Main {
		
	public static void main(String[] args) {
		
		//***********************************************//
		// Posição de deslocamento da letra
		int posicao = 12;
		
		//Frase a ser codificada
		String palavraTeste = "Teste de palavra XX";
	
		//*************************************************//
		
		int[][] matriz = new int[26][2];

		for (int i = 0; i < 26; i++) {
	            matriz[i][0] = i + 1;  
	            matriz[i][1] = 'a' + i;  
	        }

		ArrayList<String> mensagem = new ArrayList<>();
		ArrayList<String> codificada = new ArrayList<>();
		ArrayList<String> descodificada = new ArrayList<>();
		
		for (int i = 0; i< palavraTeste.length(); i++) {
			char palavra = palavraTeste.charAt(i);
			
			if (palavra == ' ' ) {
				mensagem.add(" ");
				codificada.add(".");
				descodificada.add(" ");
				
			}

			for(int j = 0; j< matriz.length;j++) {
							
				if (Character.toLowerCase(matriz[j][1]) == Character.toLowerCase(palavra)) {
					mensagem.add(String.valueOf((char) matriz[j][1]));
					
					int codif = (j+posicao) % 26;
					int descod = ((j+posicao)-posicao) %26;
					codificada.add(String.valueOf((char) matriz[codif][1]));
					descodificada.add(String.valueOf((char) matriz[descod][1]));
                }
			}
		}
		imprimirMsg("Mensagem: ", mensagem);
		imprimirMsg("Codificado: ", codificada);
		imprimirMsg("Descodificado: ", descodificada);
		
	}
	
	private static void imprimirMsg (String msg, ArrayList<String> lista) {
		System.out.print(msg);
			for(String caracter : lista) {
				System.out.print(caracter);
			}
			System.out.println();
	}
}
