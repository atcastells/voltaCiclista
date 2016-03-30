import dades.Acces;

import java.util.Scanner;

/**
 * Created by Aaron Castells on 16/03/2016.
 */
public class Principal {

	public static void main (String[] args){
		new Principal().inici();
	}

	void inici(){
		Biblioteca gui = new Biblioteca();
		Acces acces = new Acces();
		int controlMenu = 0;
		while (controlMenu < menu.length) {
			gui.funcioMenu(menu);
			controlMenu = gui.readInt("Introdueix una opció: ");
			int controlMenuCompeticio = 0;
			int controlMenuCiclistes = 0;
			switch (controlMenu) {
				case 1: //Inscripció de ciclistes
					while(controlMenuCiclistes < menuGestioCiclistes.length){
						gui.funcioMenu(menuGestioCiclistes);
						gui.imprimir("Num de ciclistes:"+acces.ciclistesCount+"\n");
						controlMenuCiclistes = gui.readInt("Introdueix una opció: ");
						switch (controlMenuCiclistes){
							case 1:
								gui.imprimir("Introdueix el codi del equip: ");
								String equip = gui.readString();
								if (acces.controlEquip(equip) == -2){
									gui.imprimir("El equip introduït està ple\n");
								}
								if (acces.controlEquip(equip) == -1){
									gui.imprimir("El equip introduït no existeix\n");
								}
								else {
									if(acces.ciclistesCount >= 0 && acces.ciclistesCount <= 45){
										gui.imprimir("Introdueix el dni del ciclista: ");
										String dni = gui.readString();
										for(int i = 0; i < acces.ciclistesCount;i++){
											if(acces.CiclistesGet(i,0).equalsIgnoreCase(dni)){
												gui.imprimir("Aquest dni ja pertany a un ciclista");
											}
										}
										/*Afegim el DNI al ciclista*/
										acces.CiclistesPut(acces.ciclistesCount,0,dni);

										                /*Afegim el nom al ciclista*/
										gui.imprimir("Introdueix un nom per al ciclista: ");
										String nom = gui.controlString(3);
										acces.CiclistesPut(acces.ciclistesCount,1,nom);

										 /*Afegim la data de naixement al ciclista*/
										gui.imprimir("Introdueix una data de naixement per al ciclista:\n");
										acces.CiclistesPut(acces.ciclistesCount,2,gui.funcioData());

										 /*Afegim dorsal*/
										acces.CiclistesPut(acces.ciclistesCount,3,gui.funcioDorsal(acces.CiclistesGet(acces.ciclistesCount,1),acces.ciclistesCount+1,equip));
										acces.afegirCiclista();

									}
									else {
										gui.imprimir("No es poden apuntar mes ciclistes");
									}
								}
								break;
							case 2:
								if(acces.numCiclistes() == 0){
									gui.imprimir("No hi ha cap ciclista inscrit\n");
								}
								else {
									gui.imprimir(acces.CiclistesToString());

								}
								break;
						}
					}
					break;
				case 2:
					while (controlMenuCompeticio < menuCompeticio.length) {
						gui.funcioMenu(menuCompeticio);
						controlMenuCompeticio = gui.readInt("Introdueix una opció: ");
						switch (controlMenuCompeticio){
							case 1:
								gui.imprimir("Selecciona el ciclista:\n");
								for(int i = 0;i < acces.ciclistesCount;i++){
									gui.imprimir(i+"\t"+acces.CiclistesGet(i,1)+"\n");
								}
								break;
							case 2:
								break;
							case 3:
								break;
							case 4:
								break;
						}
					}
					break;
			}
			Scanner sc = new Scanner(System.in);
			System.out.println("\nPrem enter per continuar... ");
			sc.nextLine();
			gui.imprimir("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		}
	}

	String[] menu = {"Gestió de inscripció de ciclistes","Gestió de la competició","Sortir"};
	String[] menuGestioCiclistes = {"Inscriure","Llistar","Tornar"};
	String[] menuCompeticio = {"Enregistrar temps","Temps etapes", "Informe de guanyadors", "Llistat de remuneracions","Tornar"};

}