package com.example.ArabiRomani;

public class ArabiRomani {

	public String arabsToRomans(int i) {
		
		String romanNum = "";
		
		while(i >= 1000) {
			romanNum += "M";
			i -= 1000;
		}
		while(i >= 900) {
			romanNum += "CM";
			i -= 900;
		}
		while(i >= 800) {
			romanNum += "DCCC";
			i -= 800;
		}
		while(i >= 700) {
			romanNum += "DCC";
			i -= 700;
		}
		while(i >= 600) {
			romanNum += "DC";
			i -= 600;
		}
		while(i >= 500) {
			romanNum += "D";
			i -= 500;
		}
		while(i >= 400) {
			romanNum += "CD";
			i -= 400;
		}
		while(i >= 300) {
			romanNum += "CCC";
			i -= 300;
		}
		while(i >= 200) {
			romanNum += "CC";
			i -= 200;
		}
		while(i >= 100) {
			romanNum += "C";
			i -= 100;
		}
		while(i >= 90) {
			romanNum += "XC";
			i -= 90;
		}
		while(i >= 80) {
			romanNum += "LXXX";
			i -= 80;
		}
		while(i >= 70) {
			romanNum += "LXX";
			i -= 70;
		}
		while(i >= 60) {
			romanNum += "LX";
			i -= 60;
		}
		while(i >= 50) {
			romanNum += "L";
			i -= 50;
		}
		while(i >= 40) {
			romanNum += "XL";
			i -= 40;
		}
		while(i >= 30) {
			romanNum += "XXX";
			i -= 30;
		}
		while(i >= 20) {
			romanNum += "XX";
			i -= 20;
		}
		while(i >= 10) {
			romanNum += "X";
			i -= 10;
		}
		while(i >= 9) {
			romanNum += "IX";
			i -= 9;
		}
		while(i >= 8) {
			romanNum += "VIII";
			i -= 8;
		}
		while(i >= 7) {
			romanNum += "VII";
			i -= 7;
		}
		while(i >= 6) {
			romanNum += "VI";
			i -= 6;
		}
		while(i >= 5) {
			romanNum += "V";
			i -= 5;
		}
		while(i >= 4) {
			romanNum += "IV";
			i -= 4;
		}
		while(i >= 3) {
			romanNum += "III";
			i -= 3;
		}
		while(i >= 2) {
			romanNum += "II";
			i -= 2;
		}
		while(i >= 1) {
			romanNum += "I";
			i -= 1;
		}
		return romanNum;
	}
	
}
