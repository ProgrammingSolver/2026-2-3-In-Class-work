package mainPackage;

public class MainClass {
	public static void main(String[] args) {
		try {
			AndrewClass newObj = new AndrewClass();

			for (int i = 0; i < 22; i++) {
				newObj.addToEnd(String.format("String %d", i));

				System.out.println(newObj.getSize());
			}

			newObj.addToBucket("New String?", 10);
			newObj.replace("WHAT??????", 13);
			newObj.printBuckets(System.out);

			newObj.remove(7);
		}

		catch (AndrewClassException e) {
			System.out.println(e);
		}
	}
}