package pt.belele.project.alg;

import java.util.ArrayList;
import java.util.List;

public class Algorithm {
	
	Double lucro_total;
	Integer numero_jornadas_disputadas;
	List<Double> lucro_por_jornada = new ArrayList<Double>();
	
	public void calculoLucro(){

		for(Integer i=1; i <= numero_jornadas_disputadas; i++)
		lucro_total = lucro_total + lucro_por_jornada.get(i);
	}
	
	public static void main(String [] args)
	{
	      
	}
}
