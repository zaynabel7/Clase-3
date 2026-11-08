package recursividad;

import java.util.Arrays;

public class Backtracking {
	
	static class Laberinto{
		int[][] mapa;
		public Laberinto (int[][] mapa) {
			this.mapa =  mapa;
		}
		@Override
		
		public String toString(){
			
			String resultado = "";
			for(int[] fila : mapa) {
				for(int valor : fila) {
					resultado += valor + " ";
				}
				resultado += "\n";
			}
			return resultado;
		}
	}
		
	public static String matrizToString(int[][] arr) {
		String resultado = "";
		for(int[] fila : arr) {
			for(int valor : fila) {
				resultado += valor + " ";
			}
			resultado += "\n";
		}
		return resultado;
	}
	//int[][] mapa o Laberinto laberinto
	public static boolean camino(Laberinto laberinto, int fila, int columna) { //le tengo que pasar la fila y la columna (y el mapa) para que el metodo sepa que posicion explorar
	
		System.out.println("Intento: " + fila + "," + columna);
		//el caso base es cuando se para y el caso recurisvo donde voy a seguir probando
		
		//Fuera de limites (mapa = laberinto.mapa.length)
		
		if(fila > laberinto.mapa.length -1 || fila < 0) {//mapa.length -> accedo al numero de filas, mapa[0].length -> accedo a la fila, primer caso: cuando salgo por abajo de la matriz, segundo caso: cuando salgo por encima de la matriz
			return false; //no hay camino por aqui
		}
		//Choco con la pared
		if(laberinto.mapa[fila][columna] == 1 ||  laberinto.mapa[fila][columna] == 2) {
			return false;
		}
		
		//Salida
		if(fila == laberinto.mapa.length - 1 && columna == laberinto.mapa[0].length -1) { //si quiero que la salida sea (3,3) if(fila == 3 && columna == 3)
			return true;
		}
		
		//Backtracking
		//PRUEBO
		System.out.println(laberinto);
		laberinto.mapa[fila][columna] = 2; //actualizo el mapa, el 2 significa que estoy avanzando posiciones
		
		//EXPLORO (llamo a mi propio metodo y le tengo que pasar parametros
		
		//si cualquiera de los metodos devuelve true, para que no vuelva y devuelva false
		//camino(mapa, fila + 1, columna);  -> avanzo a la siguiente fila en la misma columna
		//camino(mapa, fila -1, columna);   -> retrocedo a la anterior fila en la misma columna
		//camino(mapa, fila, columna +1);   -> salto a la siguiente columna en la misma fila
		//camino(mapa, fila, columna -1);
		
		if(camino(laberinto, fila + 1, columna) || camino(laberinto, fila - 1, columna) || camino(laberinto, fila, columna +1) || camino(laberinto, fila, columna -1)) {
			return true; 
		}
			//VUELVO
		System.out.println("Retrocedo desde: " + fila + "," + columna);
		System.out.println(laberinto);
		laberinto.mapa[fila][columna] = 0;  //vuelvo en 0 porque voy deshaciendo el camino
		return false;

		}	
	
	
	public static void main(String[] args) {
		int[][] mapa = {        
				{0, 0, 1, 0},
				{1, 0, 0, 0},
				{0, 0, 1, 1},
				{0, 0, 0, 0}
				};	
		
		Laberinto laberinto = new Laberinto(mapa);
		
		//al intentar imprimir el array no me va a devolver el array ya que es una referencia, para poder imprimirlo hay que recorrerlo e imprimir posicion a posicion
		//System.out.println(Arrays.toString(mapa[0]));        //imprime solo una fila
		//System.out.println(Arrays.deepToString(mapa));      imprime todas las filas
//		boolean[][] visitado = {
//				{false, false, false, false}, 
//				{false, false, false, false},
//				{false, false, false, false},
//				{false, false, false, false},
//			};
 		System.out.println(camino(laberinto,0,0));
		}
	
}













//laberinto: los 0 son caminos por los que puedo pasar y los 1 son paredes que no puedo pasar
//entrada(0,0), salida (3,3)
//
//      0100
//      0001
//      1101
//      0100

//empiezo en (0,0 con un 2 puedo ir a la derecha o abajo, pero no puedo ir a la izda o hacia arriba pero mi
//programa no conoce los limites

//puedo representar la matriz con un array de dos dimensiones, int [][] arr; entonces arr[0] me devuelve una fila, para poder obtener un vlalor lo que hay que hacer es valor = arr[2][2]
