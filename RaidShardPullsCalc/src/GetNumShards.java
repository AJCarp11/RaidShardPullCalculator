import java.util.Scanner;

public class GetNumShards {

	//static int numAncients, numVoids, numSacreds;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		GetNumShards userShards = new GetNumShards();
		
		setNumAncientShards(getNumAncientShards());
		setNumVoidShards(getNumVoidShards());
		setNumSacredShards(getNumSacredShards());
	}
	
	
	public static int getNumAncientShards() {
		
		Scanner scan = new Scanner(System.in);
		System.out.print("How many ancients are you pulling? ");
		int num = scan.nextInt();
		return num;
	}
	
	public static void setNumAncientShards(int num) {
	      int numAncients = num;
	   }
	
	public static int getNumVoidShards() {
		
		Scanner scan = new Scanner(System.in);
		System.out.print("How many voids are you pulling? ");
		int num = scan.nextInt();
		return num;
	}
	
	public static void setNumVoidShards(int num) {
	      int numVoids = num;
	   }

	public static int getNumSacredShards() {
	
	Scanner scan = new Scanner(System.in);
	System.out.print("How many sacreds are you pulling? ");
	int num = scan.nextInt();
	scan.close();
	return num;
	}
	
	public static void setNumSacredShards(int num) {
	      int numSacreds = num;
	   }

}