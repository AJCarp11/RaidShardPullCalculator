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
		
		//double x;
		
		getNumLegosFromAncients(numAncients, ancientPullRateCommon, ancientPullRateEpic, ancientPullRateLego);
		
	}
	
	public static double getNumLegosFromAncients(int numShards, double commonPullRate, double epicPullRate, double legoPullRate) {
		
		double[] percentages = new double[numShards];
		int count = 5;
		
		percentages[0] = Math.pow((1.0-(legoPullRate/100.0)), numShards);
		
		for(int i=1; i<numShards; i++) {
			
			percentages[i] = (1.0 - Math.pow((1.0-(legoPullRate/100.0)), (numShards-i))) * (1.0 * Math.pow((legoPullRate/100.0),i)) * 100.0; 
		}
		
		
		//System.out.println(percentages[0]);
		//System.out.println(percentages[1]);
		
		for (int i=0; i<count-1;i++) {
			System.out.println(percentages[i]);
		}
		
		//System.out.println(legoPullRate);
		return 1.0;
	}
	
	
}