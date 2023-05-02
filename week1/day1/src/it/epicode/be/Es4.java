package it.epicode.be;

public class Es4 {

	public static void main(String[] args) {
		double side1 = 18;
		double side2 = 3;
		double side3 = 3;
		System.out.println(perimetroRettangolo(side1, side2));
		System.out.println(pariDispari(6));
		System.out.println(areaTriangolo(side1, side2, side3));
	}

	private static boolean pariDispari(int num) {
		if (num % 2 == 0) {
			return true;
		} else {
			return false;
		}
	}

	private static double perimetroRettangolo(double side1, double side2) {
		return (side1 + side2) * 2;
	}

	private static double areaTriangolo(double side1, double side2, double side3) {
		double semiPerimeter = (side1 + side2 + side3) / 2;
		return Math.sqrt(semiPerimeter * (semiPerimeter - side1) * (semiPerimeter - side2) * (semiPerimeter - side3));
	}

}
