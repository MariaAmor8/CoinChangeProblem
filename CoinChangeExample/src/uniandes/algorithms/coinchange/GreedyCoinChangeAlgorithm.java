package uniandes.algorithms.coinchange;


public class GreedyCoinChangeAlgorithm implements CoinChangeAlgorithm{

	@Override
	public int[] calculateOptimalChange(int totalValue, int[] denominations) {
		// TODO Auto-generated method stub
		int [] monedas = new int[denominations.length];
		coinChangeRecursive(totalValue, denominations, denominations.length-1, monedas);
		return monedas;
	}
	
	private int coinChangeRecursive(int totalValue, int[] denominations, int iElements, int[]monedas) {
		if(denominations.length == 1) {
			monedas[iElements] = 0;
			return 0;
		}
		else if(totalValue == 0) {
			monedas[iElements] = 0;
			return 0;
		}
		else if(iElements == 0) {
			monedas[iElements] = totalValue;
			return denominations[iElements] * totalValue;
		}
		else {
			int cantMonedas = totalValue/denominations[iElements];
			if(cantMonedas == 0) {
				monedas[iElements] = 0;
				int monedasAntes = coinChangeRecursive(totalValue, denominations,iElements-1,monedas);
				return monedasAntes+cantMonedas;
			}
			else {
				int monedasAntes = coinChangeRecursive(totalValue-(cantMonedas*denominations[iElements]), denominations,iElements-1,monedas);
				monedas[iElements] = cantMonedas;
				return monedasAntes+cantMonedas;
			}
		}
	}

}
