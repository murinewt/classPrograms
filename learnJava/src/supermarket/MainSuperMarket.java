package supermarket;

import java.util.Scanner;

public class MainSuperMarket {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner diskScanner = new Scanner(System.in);
		int numOfItems;
		System.out.print("Enter the number of items you want: ");
		numOfItems = diskScanner.nextInt();
//		String codeDetails;
//		int quantity;
//		double costPrice,discount,netMoney;
		double totalMoney =0;
		SuperMarketDetails [] superS = new SuperMarketDetails[numOfItems];
		for(int x=0;x<numOfItems;x++){
			SuperMarketDetails  superSuper=new SuperMarketDetails();
			System.out.print("\nEnter the code of the Item: ");
			superSuper.CodeDetails=diskScanner.next();
			System.out.print("Enter the Quantity required: ");
			superSuper.quantity=diskScanner.nextInt();
			System.out.print("Enter the Price of the Item: ");
			superSuper.costPrice=diskScanner.nextDouble();
			superSuper.totalCost=superSuper.costPrice*superSuper.quantity;
			superSuper.discount=superSuper.getDiscount(superSuper.totalCost);
			superSuper.netMoney=superSuper.getNetMoney(superSuper.totalCost);
			superS[x]=superSuper;
			totalMoney+=superSuper.netMoney;
		}
		System.out.println("\n\nCode\t Quantity\t Price\t \t TotalCost\t Discount\t NetTotal");
		
		for(int x=0;x<numOfItems;x++){
			System.out.println(superS[x].CodeDetails+"\t "+superS[x].quantity+"\t\t "+superS[x].costPrice+"\t\t "+
			superS[x].totalCost+"\t %.2f"+superS[x].discount+"\t\t"+superS[x].netMoney);
		}
		System.out.println("\n\nTotal Cost of Items is: "+totalMoney);
		diskScanner.close();
	}
	
	

}
