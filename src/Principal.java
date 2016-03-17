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
		int controlMenu = 0;
		while (controlMenu < gui.programa.lastPos(gui.programa.dades.menu)) {
			gui.funcioMenu(gui.programa.dades.menu);
			controlMenu = gui.readInt("Introdueix una opció: ");
			int controlMenuCompeticio = 0;
			int controlMenuCiclistes = 0;
			switch (controlMenu) {
				case 1: //Inscripció de ciclistes
					while(controlMenuCiclistes < gui.programa.lastPos(gui.programa.dades.menuGestioCiclistes)){
						gui.funcioMenu(gui.programa.dades.menuGestioCiclistes);
						controlMenuCiclistes = gui.readInt("Introdueix una opció: ");
						switch (controlMenuCiclistes){
							case 1:
								gui.inscripcioCiclistes();
								break;
							case 2:
								if(gui.programa.numCiclistes() == 0){
									gui.imprimir("No hi ha cap ciclista inscrit\n");
								}
								else {
									gui.imprimir(gui.programa.toString(gui.programa.dades.Ciclistes));

								}
								break;
						}
					}
					break;
				case 2:
					while (controlMenuCompeticio < gui.programa.lastPos(gui.programa.dades.menuCompeticio)) {
						gui.funcioMenu(gui.programa.dades.menuCompeticio);
						controlMenuCompeticio = gui.readInt("Introdueix una opció: ");
						switch (controlMenuCompeticio){
							case 1:
								break;
							case 2:
								break;
							case 3:
								break;
						}
					}
					break;
			}
			Scanner sc = new Scanner(System.in);
			System.out.println("\nPrem enter per continuar... ");
			sc.nextLine();
		}
	}

}