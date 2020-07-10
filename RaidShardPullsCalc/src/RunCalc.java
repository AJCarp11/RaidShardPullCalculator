import java.lang.Math;

public class RunCalc {
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		GetNumShards info = new GetNumShards();
		SetRates rates = new SetRates();
		
		
		runAllCalculations(info.getNumAncientShards(), info.getNumVoidShards(), info.getNumSacredShards(), rates.getAncientRates()[0], rates.getAncientRates()[1], rates.getAncientRates()[2], rates.getVoidRates()[0], rates.getVoidRates()[1], rates.getVoidRates()[2], rates.getSacredRates()[0], rates.getSacredRates()[1]);
		
		
		//System.out.println(info.getNumAncientShards());
		
		//System.out.println(1 + rates.getAncientRates()[1]);
	
	}
	
	public static void runAllCalculations(int numAncients, int numVoids, int numSacreds, double ancientPullRateCommon, double ancientPullRateEpic, double ancientPullRateLego, double voidPullRateCommon, double voidPullRateEpic, double voidPullRateLego, double sacredPullRateEpic, double sacredPullRateLego) {
		
		getNumLegosFromAncients(numAncients, ancientPullRateCommon, ancientPullRateEpic, ancientPullRateLego);
		getNumLegosFromVoids(numVoids, voidPullRateCommon, voidPullRateEpic, voidPullRateLego);
		
	}
	
	public static void getNumLegosFromAncients(int numShards, double commonPullRate, double epicPullRate, double legoPullRate) {
		
		double[] percentages = new double[numShards];
		int count = 5;
		
		percentages[0] = (1.0 - Math.pow((1.0-(legoPullRate/100.0)), numShards)) * Math.pow(10, 2);
		
		for(int i=1; i<numShards; i++) {
			
			percentages[i] = (Math.pow((1.0-(legoPullRate/100.0)), (numShards-i))) * (1.0 * Math.pow((legoPullRate/100.0),i)) * Math.pow(10,4); 
		}
		
		System.out.println();
		System.out.println("Ancient Shard Results:");
		for (int i=0; i<count-1;i++) {
			System.out.println("Your chances of pulling " + i + " legendaries are " + percentages[i] + "%");
		}
		
	}
	
	public static void getNumLegosFromVoids(int numShards, double commonPullRate, double epicPullRate, double legoPullRate) {
		
		double[] percentages = new double[numShards];
		int count = 5;
		
		percentages[0] = (1.0 - Math.pow((1.0-(legoPullRate/100.0)), numShards)) * Math.pow(10, 2);
		
		for(int i=1; i<numShards; i++) {
			
			percentages[i] = (Math.pow((1.0-(legoPullRate/100.0)), (numShards-i))) * (1.0 * Math.pow((legoPullRate/100.0),i)) * Math.pow(10,4); 
		}
		
		System.out.println();
		System.out.println("Void Shard Results:");
		for (int i=0; i<count-1;i++) {
			System.out.println("Your chances of pulling " + i + " legendaries are " + percentages[i] + "%");
		}
		
	}
	
	
	
	
}