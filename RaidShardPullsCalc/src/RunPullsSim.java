import java.util.Random;
import java.lang.Math;

// Currently working on a way to simulate / 'mock pull' shards

public class RunPullsSim {
		
	public static double[] runSimAncients(int numAncients) {
		
		double[] temp = new double[3];
		double[] pulls = new double[3];
		
		for (int i=0; i < numAncients; i++) {
			double num = generateRandomPull();
			temp = evaluatePulls(0, num);
			
			if (temp[0] == 1.0) {
				pulls[0]++;
			}
			else if (temp[1] == 1.0) {
				pulls[1]++;
			}
			else {
				pulls[2]++;
			}
		}
		
		return pulls;
	}
	
	
	// The following is commented out because it needs to track separately the simulations for Voids and Sacreds
	// Also need print statements to distinguish these simulations
	
	public static double[] runSimVoids(int numVoids) {
		
		double[] temp = new double[3];
		double[] pulls = new double[3];
		
		for (int i=0; i < numVoids; i++) {
			double num = generateRandomPull();
			temp = evaluatePulls(1, num);
			
			if (temp[0] == 1.0) {
				pulls[0]++;
			}
			else if (temp[1] == 1.0) {
				pulls[1]++;
			}
			else {
				pulls[2]++;
			}
		}
		
		return pulls;
	}

	public static double[] runSimSacreds(int numSacreds) {
	
	double[] temp = new double[2];
	double[] pulls = new double[2];
	
	for (int i=0; i < numSacreds; i++) {
		double num = generateRandomPull();
		temp = evaluatePulls(2, num);
		
		if (temp[0] == 1.0) {
			pulls[0]++;
		}
		else {
			pulls[1]++;
		}
	}
	
		return pulls;
	}
	
	
	public static double generateRandomPull() {
		
		Random rand = new Random();
		double num = rand.nextDouble() * 1000.0 - 1.0;
		num = Math.round(num);
		
		return num;
	}
	
	// Flag represents which shards are being simulated at their respective rates.
	// Can only be [0, 1, 2] --> [Ancients, Voids, Sacreds].
	public static double[] evaluatePulls(int identifier, double rand) {
		
		int flag = identifier;
		double[] results = new double[3];
		
		
		switch (flag) {
		
			// Ancients
			case 0:
				// Rare pull
				if (rand <= SetRates.getAncientRates()[0] * 10) {
					results[0]++;
				}
				// Epic Pull
				else if (rand > (SetRates.getAncientRates()[0] * 10) && rand <= ((SetRates.getAncientRates()[0] + SetRates.getAncientRates()[1]) * 10)) {
					results[1]++;
				}
				// Lego Pull
				else {
					results[2]++;
				}
			break;
			
			// Voids
			case 1:
				// Rare pull
				if (rand <= SetRates.getVoidRates()[0] * 10) {
					results[0]++;
				}
				// Epic Pull
				else if (rand > (SetRates.getVoidRates()[0] * 10) && rand <= ((SetRates.getVoidRates()[0] + SetRates.getVoidRates()[1]) * 10)) {
					results[1]++;
				}
				// Lego Pull
				else {
					results[2]++;
				}
			break;
			
			// Sacreds
			case 2:
				// Epic Pull
				if (rand <= (SetRates.getSacredRates()[0]) * 10) {
					results[0]++;
				}
				// Lego Pull
				else {
					results[1]++;
				}
			break;
		}
		
		return results;
	}
	
	public static double[] averagePulls(int numSims, double numRares, double numEpics, double numLegos) {
		
		double[] average = new double[3];
		
		average[0] = Math.round(numRares/numSims);
		average[1] = Math.round(numEpics/numSims);
		average[2] = Math.round(numLegos/numSims);
		
		return average;
	}
	
	public static void printResults(int numSims, double numRares, double numEpics, double numLegos, int shardType) {
		
		String shard = "";
		
		if (shardType == 0) {
			shard = "Ancient";
		}
		else if (shardType == 1) {
			shard = "Void";
		}
		else {
			shard = "Sacred";
		}
		
		if (numRares != 0) {
			System.out.println();
			System.out.println("After " + numSims + " " + shard + " simulations, the average of pulls were: ");
			System.out.println(numRares + " rares.");
			System.out.println(numEpics + " epics.");
			System.out.println(numLegos + " legos.");
		}
		else {
			System.out.println();
			System.out.println("After " + numSims + " " + shard + " simulations, the average of pulls were: ");
			System.out.println(numEpics + " epics.");
			System.out.println(numLegos + " legos.");
		}
		
	}
	
	
}
	