/**
 * Created by Aaron Castells on 16/03/2016.
 */
public class Acces {
	Informacio dades = new Informacio();

    /*Funció que retorna strings d'una posició de una array*/

	String retornaString(String[] array, int x){
		return array[x];
	}
	String retornaString(String[][] array, int x, int y){
		return array[x][y];
	}

	void addString(String[] array, int x,String text){
		array[x] = text;
	}

	void addString(String[][] array, int x, int y,String text){
		array[x][y] = text;
	}
	int lastPos(String[] array){
		return array.length;
	}


	/*
	* Funció que controla els equips plens i els noms d'equip erronis
	*
	* Valors de retorn:
	*       -1: El equip no existeix.
	*       -2: El equip està ple.
	*       1: Equip amb places disponibles.
	* */
	int controlEquip(String x){
		final int LLOCS = 5;
		int coincidencies = 0; //Variable per contar les coincidències del equip del jugador amb les plaçes
		boolean equipExistent = false;
		for(int i = 0; i < dades.equips.length && !equipExistent;i++){
			if(x.equalsIgnoreCase(dades.equips[i][0])){
				equipExistent = true;
			}
		}
		if (!equipExistent){
			return -1;
		}
		if(dades.indexCiclistes > 0) {

			for (int i = 0; i < numCiclistes(); i++) {
				String comparar = ""+dades.Ciclistes[i][3].charAt(dades.Ciclistes[i][3].length() - 3)+dades.Ciclistes[i][3].charAt(dades.Ciclistes[i][3].length() - 2)+dades.Ciclistes[i][3].charAt(dades.Ciclistes[i][3].length() - 1);
				System.out.print("Comparant "+comparar+" amb "+x+" que es el equip del corredor "+i);
				if (comparar.equalsIgnoreCase(x)) {
					System.out.print("Coincidencia");
					coincidencies++;
					comparar = "";
					System.out.print(coincidencies+"\n");
				}
			}
			if (LLOCS - coincidencies > 0) {
				return 1;
			} else {
				return -2;
			}
		}
		else {
			return 1;
		}
	}
	void afegirCiclista(){
		dades.indexCiclistes++;
	}
	int numCiclistes(){
		return dades.indexCiclistes;
	}

	String toString(String[] array){
		String cadena = "";
		for(int i = 0;i < array.length; i++){
			cadena += "#"+(i+1)+"\t"+array[i]+"\n";
		}
		return cadena;
	}

	String toString(String[][] array){
		String cadena = "";
		for(int i = 0;i < numCiclistes(); i++){
			cadena += "#"+(i+1)+"\t"+array[i][0]+"\t"+array[i][1]+"\t"+array[i][2]+"\t"+array[i][3]+"\t"+"\n";
		}
		return cadena;
	}
}