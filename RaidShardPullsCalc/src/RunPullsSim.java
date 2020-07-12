import java.util.Random;
import java.lang.Math;

// Currently working on a way to simulate / 'mock pull' shards

/* public class RunPullsSim {
	
	public static void main(String[] args) {
		
		GetNumShards info = new GetNumShards();
		SetRates rates = new SetRates();
		
		double num = generateRandomPull();
		double[] pulls = new double[3];
		//pulls = evaluatePulls(generateRandomPull());
		
		//System.out.println(num);
		
		
		int flag = 0;
		
		// Only Ancients
		if (info.getNumVoidShards() == 0 && info.getNumSacredShards() == 0 && info.getNumAncientShards() !=  0) {
			flag = 0;
		}
		// Only Voids
		else if (info.getNumAncientShards() == 0 && info.getNumSacredShards() == 0 && info.getNumVoidShards() !=  0) {
			flag = 1;
		}
		// Only Sacreds
		else if (info.getNumAncientShards() == 0 && info.getNumVoidShards() == 0 && info.getNumSacredShards() !=  0) {
			flag = 2;
		}
		// Ancients and Voids
		else if (info.getNumSacredShards() == 0 && info.getNumAncientShards() != 0 && info.getNumVoidShards() != 0) {
			flag = 3;
		}
		// Ancients and Sacreds
		else if (info.getNumVoidShards() == 0 && info.getNumAncientShards() != 0 && info.getNumSacredShards() != 0) {
			flag = 4;
		}
		// Voids and Sacreds
		else if (info.getNumAncientShards() == 0 && info.getNumVoidShards() != 0 && info.getNumSacredShards() != 0) {
			flag = 5;
		}
		// Ancients, Voids, and Sacreds
		else if (info.getNumAncientShards() != 0 && info.getNumVoidShards() != 0 && info.getNumSacredShards() != 0) {
			flag = 6;
		}
		
		switch (flag) {
			case 0:
				
			break;
			
			case 1:
				
			break;
			
			case 2:
				
			break;
			
			case 3:
				
			break;
			
			case 4:
				
			break;
			
			case 5:
				
			break;
			
			case 6:
				
			break;
			
		}
		
		
		
		//for (int i=0; info.
		
		
		
		System.out.println(pulls[0]);
		System.out.println(pulls[1]);
		System.out.println(pulls[2]);
	}
	
	public static double generateRandomPull() {
		
		double[] summonsCount = new double[3];
		
		SetRates rates = new SetRates();
		
		double commonInterval = rates.getAncientRates()[0];
		double epicInterval = rates.getAncientRates()[1];
		double legoInterval = rates.getAncientRates()[2];
		
		Random rand = new Random();
		double num = rand.nextDouble() * 1000.0;
		num = Math.round(num);
		
		return num;
	}
	
	public static double[] evaluatePulls(double rand) {
		
		SetRates rates = new SetRates();
		
		double[] results = new double[3];
		
		// Common pull
		if (rand <= rates.getAncientRates()[0] * 10) {
			results[0]++;
		}
		else if (rand > (rates.getAncientRates()[0] * 10) && rand <= ((rates.getAncientRates()[0] + rates.getAncientRates()[1]) * 10)) {
			results[1]++;
		}
		else {
			results[2]++;
		}
		
		return results;
	}
	
}
*/