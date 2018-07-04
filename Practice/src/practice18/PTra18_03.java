/*
 * PTra18_03.java
 *   作成	LIKEIT	2017
 *------------------------------------------------------------
 * Copyright(c) Rhizome Inc. All Rights Reserved.
 */
/*
 * PTra18_03.java
 *   作成	LIKEIT	2017
 *------------------------------------------------------------
 * Copyright(c) Rhizome Inc. All Rights Reserved.
 */
package practice18;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import entity.Player;

public class PTra18_03 {

	/*
	 * PTra19_02で作成したPlayerクラスを使用します
	 */

	public static void main(String[] args) {

		/*
		 * ①
		 * ★ file/BestElevenCandidate.csvの内容を取得し、１行毎にPlayerインスタンスに情報を格納してください
		 * ★ ArrayListを作成して、Playerインスタンスを格納してください
		 */
		ArrayList<Player> array = new ArrayList<>();

		try (Scanner scanner = new Scanner(new File("file/BestElevenCandidate.csv"))) {

			while (scanner.hasNext()) {
				String line = scanner.next();

				String[] a = line.split(",",0);


				Player p= new Player();
				p.setPosition(a[0]);
				p.setName(a[1]);
				p.setCountry(a[2]);
				p.setTeam(a[3]);
				array.add(p);

			}
		} catch (FileNotFoundException e) {
			System.out.println("ファイルが見つかりません");
		}

		// ★ ①のArrayListの中から"レアル・マドリード", "バルセロナ"の選手を除外してください

		
		ArrayList<Player> club = new ArrayList<>();
		for(Player p : array) {
			if(p.getTeam().contains("レアル・マドリード") || p.getTeam().contains("バルセロナ")) {
				club.add(p);
			}
		}
		        array.removeAll(club);
		// ★ 削除後のArrayListの中身を全件出力してください
		     for(Player p : array) {
		
		       System.out.println(p.toString());
		     }
		
	}
}
