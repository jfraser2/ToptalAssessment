package com.toptal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VendingMachineChange {
	
	private List<Integer> coinList = new ArrayList<Integer>(
	        Arrays.asList(100, 50, 25, 10, 5, 1)); 
	private double epsilon = .01;
	
	private ChangeTypeCounter changeTypeCounter = null; // delegate Object

	
	public VendingMachineChange() {
		this.changeTypeCounter = new ChangeTypeCounter();
	}
	
	private double calculateChange(double chargeValue, double givenValue) {
		
		double retVar = -1.0;
		
		if (isDoubleEqual(chargeValue, givenValue)) {
			retVar = 0.0;
		} else if (chargeValue < givenValue) {
			retVar = givenValue - chargeValue;
		} else {
			retVar = givenValue;
		}
		
		return retVar;
	}
	
	private boolean isDoubleEqual(double inputValue, double compareValue) {
		boolean retVar = false;
		
		if (Math.abs(inputValue - compareValue)  < epsilon) {
			retVar = true;
		}
		
		return retVar;
	}
	
	public void generateCoins(double chargeValue, double givenValue) {
		
		double changeAmount = calculateChange(chargeValue, givenValue);
		
		if (!isDoubleEqual(changeAmount, 0.0)) {
			
			int changeAmountAsPennies = Double.valueOf(changeAmount * 100.0).intValue();
			
			int remainingAmount = changeAmountAsPennies;
			int numberOfCoins = 0;
			int currentCoin;
			
			for (int i = 0; i  < coinList.size(); i++) {
				currentCoin = coinList.get(i);
				numberOfCoins = remainingAmount / currentCoin;
				for(int j = 0; j < numberOfCoins; j++) {
					this.changeTypeCounter.addElement(currentCoin);
				}
				if (numberOfCoins > 0) {
					remainingAmount = remainingAmount - (currentCoin * numberOfCoins);
				}
			} // end the for loop
			
			this.changeTypeCounter.dumpChangeDescending();
			
		} else {
			System.out.println();
			System.out.println();
			System.out.println("Exact Amount was given");
		}
		
		
		
	}

}
