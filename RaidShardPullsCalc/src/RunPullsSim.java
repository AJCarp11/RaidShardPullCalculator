import java.util.Random;
import java.lang.Math;

// Currently working on a way to simulate / 'mock pull' shards

public class RunPullsSim {
		
	public static double[] runSimAncients(int numAncients) {
		
		double[] temp = new double[3];
		double[] pulls = new double[3];
		
		for (int i=0; i < numAncients; i++) {
			double num = generateRandomPull();
			temp = evaluatePulls(num);
			
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
	
	/*public static double[] runSimVoids(int numVoids) {
		
		double[] temp = new double[3];
		double[] pulls = new double[3];
		
		for (int i=0; i < numVoids; i++) {
			double num = generateRandomPull();
			temp = evaluatePulls(num);
			
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
	
	double[] temp = new double[3];
	double[] pulls = new double[3];
	
	for (int i=0; i < numSacreds; i++) {
		double num = generateRandomPull();
		temp = evaluatePulls(num);
		
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
}*/
	
	
	public static double generateRandomPull() {
		
		Random rand = new Random();
		double num = rand.nextDouble() * 1000.0 - 1.0;
		num = Math.round(num);
		
		return num;
	}
	
	public static double[] evaluatePulls(double rand) {
				
		double[] results = new double[3];
		
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
		
		return results;
	}
	
	public static double[] averagePulls(int numSims, double numRares, double numEpics, double numLegos) {
		
		double[] average = new double[3];
		
		average[0] = Math.round(numRares/numSims);
		average[1] = Math.round(numEpics/numSims);
		average[2] = Math.round(numLegos/numSims);
		
		return average;
	}
	
	public static void printResults(int numSims, double numRares, double numEpics, double numLegos) {

		System.out.println("After " + numSims + " simulations, the average of pulls were: ");
		System.out.println(numRares + " rares.");
		System.out.println(numEpics + " epics.");
		System.out.println(numLegos + " legos.");
		
	}
	
	
}
	