package uniandes.algorithms.coinchange;

public class DynamicProgrammingCoinChangeAlgorithm implements CoinChangeAlgorithm{

	@Override
	public int[] calculateOptimalChange(int totalValue, int[] denominations) {
		// TODO Auto-generated method stub
		int[][] matriz = new int[denominations.length+1][totalValue+1];

		dynamicProgrammingCoinChangeAlgorithm(totalValue, denominations, matriz);
		int j = totalValue;
		int[] monedas = new int[denominations.length];
		int i = denominations.length;
		while(j !=0 && i>0) {
			int arriba = matriz[i-1][j];
			if(j >= denominations[i-1]) {
				int lateral = matriz[i][j - denominations[i - 1]];
				if(lateral +1 <= arriba) {
					monedas[i-1] += 1;
					j = j-denominations[i-1];
				}
				else {
					i -= 1;
				}
			}
			else {
				i -= 1;
			}
		}
		return monedas;
	}

	private void dynamicProgrammingCoinChangeAlgorithm(int totalValue, int[] denominations, 
			int[][]matriz) {
		
		for(int j = 0; j <= totalValue; j++) {
			matriz[0][j] = Integer.MAX_VALUE;
		}
		
		for(int i = 1; i <= denominations.length; i++) {
			for(int j = 1; j<= totalValue;j++) {
				if(denominations[i-1] <= j) {
					matriz[i][j] = Math.min(1 + matriz[i][j - denominations[i - 1]], 
							matriz[i - 1][j]);
				}
				else {
					matriz[i][j] = matriz[i - 1][j];
				}
			}
		}
	}
	
}
