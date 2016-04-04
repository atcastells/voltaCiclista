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
		Biblioteca gui = new Biblioteca();      //Objecte de la classe biblioteca
		Acces acces = new Acces();              //Objecte de la classe Accés
		int controlMenu = 0;                    //Variable per al menú principal
		while (controlMenu < menu.length) {
			gui.funcioMenu(menu);
			controlMenu = gui.readInt("Introdueix una opció: ");
			int controlMenuCompeticio = 0;      //Variable Control per al menu Competició
			int controlMenuCiclistes = 0;       //Variable Control per al menú Ciclistes
			switch (controlMenu) {
				case 1: //Inscripció de ciclistes
					while(controlMenuCiclistes < menuGestioCiclistes.length){
						gui.funcioMenu(menuGestioCiclistes);
						gui.imprimir("Num de ciclistes:"+acces.numCiclistes()+"\n");
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
									if(acces.numCiclistes() >= 0 && acces.numCiclistes() <= 45){
										gui.imprimir("Introdueix el dni del ciclista: ");
										String dni = gui.readString();
										for(int i = 0; i < acces.numCiclistes();i++){
											if(acces.CiclistesGet(i,0).equalsIgnoreCase(dni)){
												gui.imprimir("Aquest dni ja pertany a un ciclista");
											}
										}
										/*Afegim el DNI al ciclista*/
										acces.CiclistesPut(acces.numCiclistes(),0,dni);

										                /*Afegim el nom al ciclista*/
										gui.imprimir("Introdueix un nom per al ciclista: ");
										String nom = gui.controlString(3);
										acces.CiclistesPut(acces.numCiclistes(),1,nom);

										 /*Afegim la data de naixement al ciclista*/
										gui.imprimir("Introdueix una data de naixement per al ciclista:\n");
										acces.CiclistesPut(acces.numCiclistes(),2,gui.funcioData());

										 /*Afegim dorsal*/
										acces.CiclistesPut(acces.numCiclistes(),3,gui.funcioDorsal(acces.CiclistesGet(acces.numCiclistes(),1),acces.numCiclistes()+1,equip));
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
						Scanner sc = new Scanner(System.in);
						System.out.println("\nPrem enter per continuar... ");
						sc.nextLine();
					}
					break;
				case 2:
					while (controlMenuCompeticio < menuCompeticio.length) {
						gui.funcioMenu(menuCompeticio);
						controlMenuCompeticio = gui.readInt("Introdueix una opció: ");
						switch (controlMenuCompeticio){
							case 1:
								int ciclista = 0;
								int etapa = 0;
								gui.imprimir("Gestió\n");
								for(int i = 0;i < acces.numCiclistes();i++){
									gui.imprimir("#"+(i+1)+"\t"+acces.CiclistesGet(i,1)+"\n");
								}
								ciclista = gui.readInt("Selecciona un ciclista: ") -1;
								while(etapa < acces.numEtapes()){
									for(int i = 0; i < acces.numEtapes(); i++){
										gui.imprimir("#"+(i+1)+"\t");
										for (int j = 0; j < acces.numEtapes2d();j++){
											gui.imprimir(acces.EtapesGet(i,j)+"\t");
										}
										gui.imprimir("\n");

									}
									gui.imprimir("#"+(acces.numEtapes()+1)+"\tSortir\n");
									etapa = gui.readInt("Selecciona una etapa") -1;
									/*Definim el temps a la etapa seleccionada*/
									acces.tempsEtapesSet(ciclista,etapa,0,Integer.toString(gui.readInt("Escriu el temps de la etapa (hores): ")));
									acces.tempsEtapesSet(ciclista,etapa,1,Integer.toString(gui.readInt("Escriu el temps de la etapa (minuts): ")));
									acces.tempsEtapesSet(ciclista,etapa,2,Integer.toString(gui.readInt("Escriu el temps de la etapa (segons): ")));

								}

								break;
							case 2:
								break;
							case 3:
								break;
							case 4:
								break;
						}
						Scanner sc = new Scanner(System.in);
						System.out.println("\nPrem enter per continuar... ");
						sc.nextLine();
					}
					break;
			}
			Scanner sc = new Scanner(System.in);
			System.out.println("\nPrem enter per continuar... ");
			sc.nextLine();
		}
	}

	String[] menu = {"Gestió de inscripció de ciclistes","Gestió de la competició","Sortir"};
	String[] menuGestioCiclistes = {"Inscriure","Llistar","Tornar"};
	String[] menuCompeticio = {"Enregistrar temps","Temps etapes", "Informe de guanyadors", "Llistat de remuneracions","Tornar"};

}