import java.util.Scanner;

public class GetNumShards {

	public static int getNumAncientShards() {
		
		Scanner scan = new Scanner(System.in);
		System.out.print("How many ancients are you pulling? ");
		int num = scan.nextInt();
		return num;
	}
	
	public static int getNumVoidShards() {
		
		Scanner scan = new Scanner(System.in);
		System.out.print("How many voids are you pulling? ");
		int num = scan.nextInt();
		return num;
	}

	public static int getNumSacredShards() {
	
		Scanner scan = new Scanner(System.in);
		System.out.print("How many sacreds are you pulling? ");
		int num = scan.nextInt();
		scan.close();
		return num;
	}

}