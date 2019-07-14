package supermarket;

public class SuperMarketDetails {
	
	
	public String CodeDetails;
	public double money,discount,netMoney,costPrice,totalCost;
	//public String codeDetails;
	public int quantity;
	
	public double getDiscount(double costTotal){
		money=costTotal;
		if(costTotal>=20000){
			discount=0.14*costTotal;
			return discount;
		}
		else if(costTotal >=10000 && costTotal<20000){
			discount=0.1*costTotal;
			return discount;
		}
		else{
			discount=0;
			return discount;
		}
		
	}
//	public double getTotalCost(double totalCost){	
//		totalCost = this.totalCost;
//		return 
//	}
	public double getNetMoney(double moneyMoney){
		discount=getDiscount(moneyMoney);
		netMoney = totalCost-discount;
		return netMoney;
	}
}
