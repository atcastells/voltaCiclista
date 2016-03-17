/**
 * Created by Aaron Castells on 16/03/2016.
 */
public class Informacio {

	String[][] equips = {
			{"ONZ", "ONZE"}
			,{"TNK", "Tinkof"}
			,{"BCH", "Biancho"}
			,{"BRW", "Bartoloworld"}
			,{"MVX", "Movixtar"}
			,{"BIC", "Bich"}
			,{"CFD", "Cofidos"}
			,{"FON", "Fono"}
			,{"MTX", "Matrix"}
	};

	String[][] etapes = {
			{"Etapa 1","Barcelona", "Girona","Plana"}
			,{"Etapa 2","Girona", "Berga", "Muntanya"}
			,{"Etapa 3","Berga", "Sort", "Alta muntanya"}
			,{"Etapa 4","Sort", "Balaguer", "Alta muntanya"}
			,{"Etapa 5","Balaguer", "Amposta", "Plana"}
			,{"Etapa 6","Amposta", "Manresa", "Plana"}
			,{"Etapa 7","Manresa", "Mataró", "Muntanya"}
	};
	double[] distanciaEtapa ={185.2, 191.8, 156.6, 188.4, 195.4, 194.1, 126.6};

	String[] tipusGeneralEtapa={"Plana","Alta Muntanya","Muntanya"};

	public String dadesPremi[][]={{"Maillot groc","Tisset","General"},
			{"Maillot blanc","Rolax","Muntanya"},
			{"Maillot blau","Supermarx","Plana"},
			{"Maillot verd","BMV","Alta muntanya"}};

	public double[] importPremi={9000, 4500, 3000, 5000};

	String [] [] Ciclistes = new String [equips.length * 5] [4];

	int indexCiclistes = 0; //Variable per controlar el num. de ciclistes.

	String [] [] []tempsEtapes = new String[Ciclistes.length][etapes.length][5]; //Array on es guardarà les dades dels ciclistes respecte a les etapes que fan.

	String[] menu = {"Gestió de inscripció de ciclistes","Gestió de la competició","Sortir"};
	String[] menuGestioCiclistes = {"Inscriure","Llistar","Tornar"};
	String[] menuCompeticio = {"Temps etapes", "Informe de guanyadors", "Llistat de remuneracions","Tornar"};
}