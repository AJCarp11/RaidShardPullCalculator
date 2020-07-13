import java.lang.Math;
import java.util.Scanner;

public class RunCalc {
		
	public static void main(String[] args) {
		
		int[] numShards = new int[3];
		
		numShards[0] = GetNumShards.getNumAncientShards();
		numShards[1] = GetNumShards.getNumVoidShards();
		numShards[2] = GetNumShards.getNumSacredShards();
		
		double[] ancientPulls = new double[3];
		ancientPulls = RunPullsSim.runSimAncients(numShards[0]);
		
		Scanner scanNumSims = new Scanner(System.in);
		System.out.println("How many simulations would you like to run? ");
		int count = scanNumSims.nextInt();
		scanNumSims.close();
		
		double[] simTemp = new double[3];
		double[] averagePulls = new double[3];
		
		if (count > 0) {
			for (int i=0; i < count; i++) {
				ancientPulls = RunPullsSim.runSimAncients(numShards[0]);
				simTemp[0] += ancientPulls[0];
				simTemp[1] += ancientPulls[1];
				simTemp[2] += ancientPulls[2];
				
			}
			
			averagePulls = RunPullsSim.averagePulls(count, simTemp[0], simTemp[1], simTemp[2]);
			
			RunPullsSim.printResults(count, averagePulls[0], averagePulls[1], averagePulls[2]);
		}
		
		runAllCalculations(numShards[0], numShards[1], numShards[2], SetRates.getAncientRates()[0], SetRates.getAncientRates()[1], SetRates.getAncientRates()[2], SetRates.getVoidRates()[0], SetRates.getVoidRates()[1], SetRates.getVoidRates()[2], SetRates.getSacredRates()[0], SetRates.getSacredRates()[1]);
	}
	
public static void runAllCalculations(int numAncients, int numVoids, int numSacreds, double ancientPullRateCommon, double ancientPullRateEpic, double ancientPullRateLego, double voidPullRateCommon, double voidPullRateEpic, double voidPullRateLego, double sacredPullRateEpic, double sacredPullRateLego) {
		
		int flag = 0;
		
		// Only Ancients
		if (numVoids == 0 && numSacreds == 0 && numAncients !=  0) {
			flag = 0;
		}
		// Only Voids
		else if (numAncients == 0 && numSacreds == 0 && numVoids !=  0) {
			flag = 1;
		}
		// Only Sacreds
		else if (numAncients == 0 && numVoids == 0 && numSacreds !=  0) {
			flag = 2;
		}
		// Ancients and Voids
		else if (numSacreds == 0 && numAncients != 0 && numVoids != 0) {
			flag = 3;
		}
		// Ancients and Sacreds
		else if (numVoids == 0 && numAncients != 0 && numSacreds != 0) {
			flag = 4;
		}
		// Voids and Sacreds
		else if (numAncients == 0 && numVoids != 0 && numSacreds != 0) {
			flag = 5;
		}
		// Ancients, Voids, and Sacreds
		else if (numAncients != 0 && numVoids != 0 && numSacreds != 0) {
			flag = 6;
		}
		
		switch (flag) {
			case 0:
				getNumEpicsFromAncients(numAncients, ancientPullRateCommon, ancientPullRateEpic, ancientPullRateLego);
				getNumLegosFromAncients(numAncients, ancientPullRateCommon, ancientPullRateEpic, ancientPullRateLego);
			break;
			
			case 1:
				getNumEpicsFromVoids(numVoids, voidPullRateCommon, voidPullRateEpic, voidPullRateLego);
				getNumLegosFromVoids(numVoids, voidPullRateCommon, voidPullRateEpic, voidPullRateLego);
			break;
			
			case 2:
				getNumLegosFromSacreds(numSacreds, sacredPullRateEpic, sacredPullRateLego);
			break;
			
			// Add epic chances here!
			case 3:
				getNumLegosFromAncients(numAncients, ancientPullRateCommon, ancientPullRateEpic, ancientPullRateLego);
				getNumLegosFromVoids(numVoids, voidPullRateCommon, voidPullRateEpic, voidPullRateLego);
			break;
			
			// Add epic chances here!
			case 4:
				getNumLegosFromAncients(numAncients, ancientPullRateCommon, ancientPullRateEpic, ancientPullRateLego);
				getNumLegosFromSacreds(numSacreds, sacredPullRateEpic, sacredPullRateLego);
			break;
			
			// Add epic chances here!
			case 5:
				getNumLegosFromVoids(numVoids, voidPullRateCommon, voidPullRateEpic, voidPullRateLego);
				getNumLegosFromSacreds(numSacreds, sacredPullRateEpic, sacredPullRateLego);
			break;
			
			// Add epic chances here!
			case 6:
				getNumLegosFromAncients(numAncients, ancientPullRateCommon, ancientPullRateEpic, ancientPullRateLego);
				getNumLegosFromVoids(numVoids, voidPullRateCommon, voidPullRateEpic, voidPullRateLego);
				getNumLegosFromSacreds(numSacreds, sacredPullRateEpic, sacredPullRateLego);
			break;
			
		}
		
	}
	
	public static void getNumEpicsFromAncients(int numShards, double commonPullRate, double epicPullRate, double legoPullRate) {
		
		double[] percentages = new double[numShards+1];
		
		percentages[0] = Math.pow((1.0-(epicPullRate/100.0)), numShards) * Math.pow(10, 2);
		
		//double temp1 = percentages[0];
		
		for(int i=1; i<numShards+1; i++) {
			
			percentages[i] = numShards * (Math.pow((1.0 - epicPullRate/100.0), numShards - i)) * (Math.pow((epicPullRate/100.0), i)) * Math.pow(10, 2);
			//temp1 = temp1 + percentages[i];
		}
		
		int flag = 0;
		for (int i=0; i<numShards+1; i++) {
			if (percentages[i] >= Math.pow(10.0, -3)) {
				flag++;
			}
		}
		
		System.out.println();
		System.out.println("Ancient Shard Results:");
		for (int i=0; i<flag; i++) {
			System.out.println("Your chances of pulling " + i + " epics are " + percentages[i] + "%");
		}
		
		//System.out.println("Temp1: " + temp1);
	}
	
	public static void getNumLegosFromAncients(int numShards, double commonPullRate, double epicPullRate, double legoPullRate) {
		
		double[] percentages = new double[numShards+1];
		
		percentages[0] = Math.pow((1.0-(legoPullRate/100.0)), numShards) * Math.pow(10, 2);
		
		//double temp1 = percentages[0];
		
		for(int i=1; i<numShards+1; i++) {
			
			percentages[i] = numShards * (Math.pow((1.0 - legoPullRate/100.0), numShards - i)) * (Math.pow((legoPullRate/100.0), i)) * Math.pow(10, 2);
			//temp1 = temp1 + percentages[i];
		}
		
		int flag = 0;
		for (int i=0; i<numShards+1; i++) {
			if (percentages[i] >= Math.pow(10.0, -3)) {
				flag++;
			}
		}
		
		System.out.println();
		System.out.println("Ancient Shard Results:");
		for (int i=0; i<flag; i++) {
			System.out.println("Your chances of pulling " + i + " legendaries are " + percentages[i] + "%");
		}
		
		//System.out.println("Temp1: " + temp1);
	}
	
	public static void getNumEpicsFromVoids(int numShards, double commonPullRate, double epicPullRate, double legoPullRate) {
		
		double[] percentages = new double[numShards+1];
		
		percentages[0] = Math.pow((1.0-(epicPullRate/100.0)), numShards) * Math.pow(10, 2);
		
		//double temp2 = percentages[0];
		for(int i=1; i<numShards+1; i++) {
			
			
			percentages[i] = numShards * (Math.pow((1.0 - epicPullRate/100.0), numShards - i)) * (Math.pow((epicPullRate/100.0), i)) * Math.pow(10, 2);
			//temp2 = temp2 + percentages[i];
		}
		
		int flag = 0;
		for (int i=0; i<numShards+1; i++) {
			if (percentages[i] >= Math.pow(10.0, -3)) {
				flag++;
			}
		}
		
		System.out.println();
		System.out.println("Void Shard Results:");
		for (int i=0; i<flag; i++) {
			System.out.println("Your chances of pulling " + i + " epics are " + percentages[i] + "%");
		}
	
		//System.out.println("Temp2: " + temp2);
	}
	
	public static void getNumLegosFromVoids(int numShards, double commonPullRate, double epicPullRate, double legoPullRate) {
		
		double[] percentages = new double[numShards+1];
		
		percentages[0] = Math.pow((1.0-(legoPullRate/100.0)), numShards) * Math.pow(10, 2);
		
		//double temp2 = percentages[0];
		for(int i=1; i<numShards+1; i++) {
			
			percentages[i] = numShards * (Math.pow((1.0 - legoPullRate/100.0), numShards - i)) * (Math.pow((legoPullRate/100.0), i)) * Math.pow(10, 2);
			//temp2 = temp2 + percentages[i];
		}
		
		int flag = 0;
		for (int i=0; i<numShards+1; i++) {
			if (percentages[i] >= Math.pow(10.0, -3)) {
				flag++;
			}
		}
		
		System.out.println();
		System.out.println("Void Shard Results:");
		for (int i=0; i<flag; i++) {
			System.out.println("Your chances of pulling " + i + " legendaries are " + percentages[i] + "%");
		}
	
		//System.out.println("Temp2: " + temp2);
	}
	
	public static void getNumLegosFromSacreds(int numShards, double epicPullRate, double legoPullRate) {
			
		double[] percentages = new double[numShards+1];
		//int count = 5;
			
		percentages[0] = Math.pow((epicPullRate/100.0), numShards) * Math.pow(10, 2);
			
		//double temp3 = percentages[0];
			
		for(int i=1; i<numShards+1; i++) {
				
			percentages[i] = numShards * (Math.pow((1.0 - legoPullRate/100.0), numShards - i)) * (Math.pow((legoPullRate/100.0), i)) * Math.pow(10, 2); 
			//temp3 = temp3 + percentages[i];
		}
			
		System.out.println();
		System.out.println("Sacred Shard Results:");
		for (int i=0; i<numShards+1 ;i++) {
			System.out.println("Your chances of pulling " + i + " legendaries are " + percentages[i] + "%");
		}
		//System.out.println("Temp3: " + temp3);
	}
	
}