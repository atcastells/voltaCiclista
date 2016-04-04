package dades;

/**
 * Classe on s'accedeix desde el programa principal a la informació enmagatzemada.
 */
public class Acces {
	Informacio dades = new Informacio();

    /*Funció que retorna strings d'una posició de una array*/

	public void addString(String[] array, int x,String text){
		array[x] = text;
	}

	public void addString(String[][] array, int x, int y,String text){
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
	public int controlEquip(String x){
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
				//System.out.print("Comparant "+comparar+" amb "+x+" que es el equip del corredor "+i);
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
	public void afegirCiclista(){
		dades.indexCiclistes++;
	}
	public int numCiclistes(){
		return dades.indexCiclistes;
	}
	public int numEtapes(){
		return dades.etapes.length;
	}

	public int numEtapes2d(){
		return dades.etapes[1].length;
	}

	public String toString(String[] array){
		String cadena = "";
		for(int i = 0;i < array.length; i++){
			cadena += "#"+(i+1)+"\t"+array[i]+"\n";
		}
		return cadena;
	}

	public String CiclistesToString(){
		String cadena = "";
		for(int i = 0;i < numCiclistes(); i++){
			cadena += "#"+(i+1)+"\t"+dades.Ciclistes[i][0]+"\t"+dades.Ciclistes[i][1]+"\t"+dades.Ciclistes[i][2]+"\t"+dades.Ciclistes[i][3]+"\t"+"\n";
		}
		return cadena;
	}

	/*Funcions per retornar dades*/
	public String CiclistesGet(int x, int y){
		return dades.Ciclistes[x][y];
	}

	public void CiclistesPut(int x, int y,String text){
		dades.Ciclistes[x][y] = text;
	}

	public String EtapesGet(int x, int y){
		return dades.etapes[x][y];
	}

	public void tempsEtapesSet(int x, int y,int z,String text){
		dades.tempsEtapes[x][y][z] = text;
	}
}