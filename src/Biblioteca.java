import dades.Acces;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by Aaron Castells on 16/03/2016.
 */
public class Biblioteca {

	void funcioMenu(String[] menu){
		for(int i = 0; i < menu.length; i++){
			imprimir("#"+(i+1)+"\t"+menu[i]+"\n");
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

	String funcioData(){
		int dia = readInt("Dia: (xx): ");
		if(dia > 31){
			imprimir("Introdueix el nº de dia correctament:\n");
			return funcioData();
		}
		int mes = readInt("Mes (xx):");
		if(mes>12){
			imprimir("Introdueix el nº de més correctament\n");
			return funcioData();
		}
		int any = readInt("Any (xxxx): ");
		if(any < 1900 && (any - 2016) < 16){
			imprimir("Introdueix el nº de any correctament\n");
			return funcioData();
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