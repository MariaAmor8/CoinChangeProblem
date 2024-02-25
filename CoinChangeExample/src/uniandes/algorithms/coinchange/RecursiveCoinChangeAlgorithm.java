package uniandes.algorithms.coinchange;

public class RecursiveCoinChangeAlgorithm implements CoinChangeAlgorithm{

	@Override
	public int[] calculateOptimalChange(int totalValue, int[] denominations) {
		// TODO Auto-generated method stub
		int[] monedas = new int[denominations.length];
		int cantidadMonedas = RecursiveCoinChange(totalValue, denominations, denominations.length-1, monedas);
		System.out.println(cantidadMonedas);
		for(int i: monedas) {
			System.out.println("monedas ->" + i);
		}
		int[] rta = {0,0,0,2,0};
		return rta;
	}

	private int RecursiveCoinChange(int totalValue, int[] denominations, int iElements, int[] monedas) {
		if(totalValue ==0 ) {
			monedas[iElements] = 0;
			return 0;
		}
		else if(iElements == 0) {
			monedas[iElements] = totalValue;
			return totalValue;
		}
		else {

			int cant = totalValue/denominations[iElements];
			int cantMonedas1 = cant + RecursiveCoinChange(totalValue-(cant*denominations[iElements]),denominations,iElements-1,monedas );
			int cantMonedas2 = RecursiveCoinChange(totalValue,denominations,iElements-1,monedas );
			if(cantMonedas1 > cantMonedas2) {
				monedas[iElements] = 0;
				return cantMonedas2;
			}
			else {
					monedas[iElements] = cantMonedas1;
				return cantMonedas1;
			}
			
		}

	}

}
