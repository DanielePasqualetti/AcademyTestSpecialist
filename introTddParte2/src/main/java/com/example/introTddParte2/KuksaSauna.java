package com.example.introTddParte2;

import java.util.ArrayList;

public class KuksaSauna {

	public ArrayList<String> generate(int i) {
		ArrayList<String> lista = new ArrayList<>();

		for (int j = 1; j <= i; j++) {
			String output = "";
			
			if(j % 3 == 0) {
				output += "Kuksa!";
			}
			if(j % 5 == 0) {
				output += "Sauna!";
			}
			if(!(j % 3 == 0)&&!(j % 5 == 0))
			output += j;
			
			lista.add(output);
		}
		return lista;
	}
}
