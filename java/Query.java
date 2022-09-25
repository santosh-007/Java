package com.java;

public class Query {

	public static void main(String[] args) {

		for (int i = 50000; i < 150000; i++) {
//			for(int j=0;j<100;j++)
//			{
//				System.out.println("INSERT INTO international_number_pattern_info (`country`, `country_code`, `length`, `startswith_series`)  VALUES ('IND"+i+"', "+j+","+(i+j)+", 'K"+i+j+"');");

			System.out.println(
					"INSERT INTO `moservice`.`molog` (`MessageID`, `ToNumber`, `FromNumber`, `Text`, `split_count`, `coding`, `udh`, `processed`, `MOID`, `UserID`, `operator`, `circle`) VALUES ('"
							+ i + "', '" + i + "', '" + i + "', '" + i + "', '', '0', '0', '0', '122150', 'motest" + i
							+ "', 'AIRCEL" + i + "', 'HI" + i + "');");
//			}
		}

	}

}
