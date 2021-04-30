package intro;

import java.util.Iterator;

public class Main {

	public static void main(String[] args) {

		// camel case

		String internetSubeButonu = "Ýnternet þubesi";

		int vade = 36;

		double dolarDun = 8.15;
		double dolarBugun = 8.18;

		boolean dustuMu = false;

		System.out.println("Hello world");
		System.out.println(internetSubeButonu);

		if (dolarBugun < dolarDun) {
			System.out.println("Dolar düþtü resmi");
		} else if (dolarBugun == dolarDun) {
			System.out.println("Dolar sabit resmi");
		} else {
			System.out.println("Dolar yükseldi resmi");
		}

		System.out.println("--------");

		String kredi1 = "Hýzlý Kredi";

		String[] krediler = { "Hýzlý kredi", "Mutlu emekli kredisi", "Konut kredisi", "Çiftçi kredisi", "Msb kredisi",
				"Meb kredisi" };

		// foreach döngüsü
		for (String kredi : krediler) {
			System.out.println(kredi);
		}

		System.out.println("--------");

		for (int i = 0; i < krediler.length; i++) {
			System.out.println(krediler[i]);
		}

		System.out.println("--------");

		int sayi1 = 10;
		int sayi2 = 20;

		sayi1 = sayi2;
		sayi2 = 100;

		System.out.println(sayi1);

		System.out.println("--------");

		int[] sayilar1 = { 1, 2, 3, 4, 5 };
		int[] sayilar2 = { 10, 20, 30, 40, 50 };

		sayilar1 = sayilar2;
		sayilar2[0] = 100;

		System.out.println(sayilar1[0]);

		String sehir1 = "Ankara";
		String sehir2 = "Ýstanbul";

		sehir1 = sehir2;
		sehir2 = "Ýzmir";

		System.out.println(sehir1);

		System.out.println("--------");

		int ogrenciSayisi = 10;

		System.out.println("Öðrenci Sayýsý : " + ogrenciSayisi);

		System.out.println("--------");

		

		

	}

}
