/**
 * class IceCreamStore here.
 */
public class IceCreamStore {
	public static void main (String [] args) {
		IceCreamFactory myFactory = new IceCreamFactory();
		IceCream vanilla = myFactory.makeIceCream("Vanilla");
		vanilla.yummy();
		IceCream choco = myFactory.makeIceCream("Chocolate");
		choco.yummy();
		IceCream straw = myFactory.makeIceCream("Strawberry");
		straw.yummy();
	}
}

