package intro;

import java.util.Iterator;

public class Main {

	public static void main(String[] args) {
		String[][] sehirler = new String[2][3];
		
		sehirler[0][0]="�stanbul";
		sehirler[0][1]="Ankara";
		sehirler[0][2]="Konya";
		sehirler[1][0]="�zmir";
		sehirler[1][1]="Kayseri";
		sehirler[1][2]="Ardahan";
		
		for(int i=0;i<2;i++)
		{
			for(int j=0;j<=2;j++)
			{
				System.out.println(sehirler[i][j]);
			}
		}
		
		String mesaj = "Bug�n hava �ok g�zel";
		
		System.out.println(mesaj.indexOf('�'));
		
		System.out.println(mesaj.toUpperCase());
		
	}

}
