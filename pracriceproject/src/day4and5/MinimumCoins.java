package day4and5;

import java.util.Arrays;
import java.util.Collections;

public class MinimumCoins {
	
	public static int minCoins(int[] coins, int amount) {
		Arrays.sort(coins);
		int coinCount = 0;
		
		for(int i = coins.length-1; i >= 0; i--) {
			while(amount >= coins[i]) {
				amount -= coins[i];
				coinCount++;
			}
		}
		return amount == 0 ? coinCount : -1; 
	}
	
	public static void main(String args) {
		int[] coins = {1, 2, 5, 10};
		int amount = 97;
		
		int result = minCoins(coins, amount);
		if(result != -1)
			System.out.println("Minimum number of coins required is " + result);
		else
			System.out.println("Amount given, cannot be formed with the given coins");
	}
}
