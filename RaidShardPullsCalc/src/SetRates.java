import java.util.Scanner;

public class SetRates {
	
	// This is where you can change pull rates for x2 summons!!
	static double[] AncientPullRates = {91.5, 8.0, 0.5};
	static double[] VoidPullRates = {83.0, 16.0, 1.0};
	static double[] SacredPullRates = {94, 6.0};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
				
		SetRates userRates = new SetRates();
		
		getAncientRates();
		getVoidRates();
		getSacredRates();
		
	}

	public static double[] getAncientRates() {
		
		return AncientPullRates;
	}
	
	
	public static double[] getVoidRates() {
		
		return VoidPullRates;
	}
	
	
	public static double[] getSacredRates() {
		
		return SacredPullRates;
	}
}


