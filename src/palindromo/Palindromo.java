package palindromo;

public class Palindromo {

	public static boolean isPalindrome(String s) {           //complejidad O(1)
		if(s.length() <= 1) {
			System.out.println("La frase tiene que tener longitud mayor que 1");
			return false;
		}
		s = s.toLowerCase();       //complejidad O(n)
		
		int inicio = 0;
		int fin = s.length() - 1;
	
		while(fin > inicio) {               // n es el numero de letras, asumimos charAt con complejidad O(1), hay que pensar cuantas veces se repite ese while, se ejecuta n/2 ¡, la complejidad es O(n/2) = O(n) porque O(n) es dominante
			if(s.charAt(inicio) == ' ') {
				inicio++;
				continue;
			} if(s.charAt(fin) == ' ') {
				fin--;
				continue;
			} 
			if(s.charAt(inicio) != s.charAt(fin)) {
				return false;
			}
			inicio++;
			fin--;
		}
		
		return true;
	}
	
	public static boolean isPalindromeMalo(String s) {
		
		String sentenceClean = "";
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == ' ') {
				continue;
			}
			sentenceClean += s.charAt(i); //O(n)
		}
		for(int i = 0; i < sentenceClean.length(); i++) {        //O(n^2), caso mejor un array vacio, caso peor un palindromo pq hay que recorrer todo
			for(int j = 0; j < sentenceClean.length(); j++)
				if(i+j == sentenceClean.length() - 1) {
					if(sentenceClean.charAt(i) != sentenceClean.charAt(j)) {
						return false;
					}
				}
		}
		return true;
	}
	public static void main(String[] args) {
		String s = "Anita lava la tina";
		System.out.println(isPalindrome(s));

	}

}

