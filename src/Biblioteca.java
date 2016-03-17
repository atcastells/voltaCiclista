import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by Aaron Castells on 16/03/2016.
 */
public class Biblioteca {
	Acces programa = new Acces();

	void funcioMenu(String[] menu){
		for(int i = 0; i < menu.length; i++){
			imprimir("#"+(i+1)+"\t"+programa.retornaString(menu,i)+"\n");
		}
	}

	void imprimir(String t){
		System.out.print(t);
	}
	void imprimir(int x){
		System.out.print(x);
	}

	int readInt(String missatge) {
		Scanner sc = new Scanner(System.in);
		try {
			imprimir(missatge);
			return sc.nextInt();
		} catch (InputMismatchException e) {
			imprimir("Error d'entrada, introdueix una xifra!\n");
			return (readInt(missatge));
		}
	}

	String readString() {
		Scanner sc = new Scanner(System.in);
		String newString = sc.nextLine();
		return newString;
	}

	/*
	Funció que realitza el procés d'inscripció de ciclistes
	Valors de retorn:
		-1: Error
		1: Correcte
	 */
	int inscripcioCiclistes(){
		imprimir("Introdueix el codi d'equip on vols inscriure el ciclista:");
		String equipCiclista = readString();
		if(programa.controlEquip(equipCiclista) == -1){
			imprimir("El equip introduït no existeix\n");
			return -1;
		}
		if(programa.controlEquip(equipCiclista) == -2){
			imprimir("El equip introduït està ple\n");
			return -1;
		}
		else {
			if (programa.numCiclistes() >= 0 && programa.numCiclistes() < 45) {
				imprimir("Introdueix el dni del ciclista: ");
				String dni = readString();
				for(int i = 0; i < programa.numCiclistes();i++){
					if(programa.retornaString(programa.dades.Ciclistes,i,1).equalsIgnoreCase(dni)){
						imprimir("Aquest dni ja pertany a un ciclista");
					}
				}
                /*Afegim el DNI al ciclista*/
				programa.addString(programa.dades.Ciclistes,programa.numCiclistes(),0,dni);
                /*Afegim el nom al ciclista*/
				imprimir("Introdueix un nom per al ciclista: ");
				String nom = controlString(3);
				programa.addString(programa.dades.Ciclistes,programa.numCiclistes(),1,nom);
				imprimir("el nom es"+programa.retornaString(programa.dades.Ciclistes,programa.numCiclistes(),1)+"\n");
                /*Afegim la data de naixement al ciclista*/
				imprimir("Introdueix una data de naixement per al ciclista:\n");
				programa.addString(programa.dades.Ciclistes,programa.numCiclistes(),2,funcioData());
                /*Afegim dorsal*/
				programa.addString(programa.dades.Ciclistes,programa.numCiclistes(),3,funcioDorsal(programa.retornaString(programa.dades.Ciclistes,programa.numCiclistes(),1),(programa.numCiclistes()+1),equipCiclista));
				programa.afegirCiclista();
				return 1;
			}
			else {
				imprimir("No es poden apuntar mes ciclistes");
				return -1;
			}
		}
	}

	String funcioData(){
		int dia = readInt("Dia: (xx)");
		if(dia > 31){
			imprimir("Introdueix el nº de dia correctament:\n");
			funcioData();
		}
		int mes = readInt("Mes (xx):");
		if(mes>12){
			imprimir("Introdueix el nº de més correctament\n");
			funcioData();
		}
		int any = readInt("Any (xxxx)");
		if(any < 1900 && (any - 2016) < 16){
			imprimir("Introdueix el nº de any correctament\n");
			funcioData();
		}
		return dia+"/"+mes+"/"+any;
	}

	String funcioDorsal(String nom,int pos,String equip){
		return ""+nom.charAt(0)+nom.charAt(1)+nom.charAt(2)+pos+equip;
	}

	/*Variable que valida un string amb la mida indicada*/
	String controlString(int x){
		Scanner sc = new Scanner(System.in);
		String y = sc.nextLine();
		if(y.length() < x){
			imprimir("El text te que tenir com a minim "+x+" caràcters.\n");
			return controlString(x);
		}
		else {}
		return y;
	}
}