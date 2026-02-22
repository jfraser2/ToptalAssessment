package com.toptal;

public class AppRunner {
	
    public static void main(String[] args) {
		AppRunner myApp = new AppRunner();
		myApp.run();
		
//		System.out.println("Usage - TestDecodeMessage ");
    	
    }
    
    public AppRunner() {
    	
    }

	public void run() {

		System.out.println();
		System.out.println("Begin Application main Method");
		
		VendingMachineChange coinsToGive = new VendingMachineChange();
		
		// chargeValue, givenValue
		coinsToGive.generateCoins(0.33, 0.33);
		
		// chargeValue, givenValue
		coinsToGive.generateCoins(0.33, 1.00);
		
		// chargeValue, givenValue
		coinsToGive.generateCoins(1.50, 1.00);
	}

}
