/**
 * class IceCreamFactory here.
 */
public class IceCreamFactory implements Factory {

	public IceCream makeIceCream(String type) {
		IceCream newIceCream = null;
		if (type.equals("Vanilla")) {
			newIceCream = new VanillaIceCream();
		} else if (type.equals("Chocolate")) {
			newIceCream = new ChocolateIceCream();
		} else if (type.equals("Strawberry")) {
			newIceCream = new StrawberryIceCream();
		}
		return newIceCream;
	}
}

