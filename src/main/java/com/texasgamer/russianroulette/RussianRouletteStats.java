package com.texasgamer.russianroulette;

public class RussianRouletteStats {

	private int revolvers;
	private int nukes;
	private int moabs;
	private int kicks;
	
	public RussianRouletteStats() {
		revolvers = 0;
		nukes = 0;
		moabs = 0;
		kicks = 0;
	}
	
	public int getRevolvers() {
		return revolvers;
	}
	
	public void increaseRevolvers() {
		revolvers++;
		increaseKicks();
	}

	public int getNukes() {
		return nukes;
	}
	
	public void increaseNukes() {
		nukes++;
		increaseKicks();
	}
	
	public int getMOABS() {
		return moabs;
	}
	
	public void increaseMOABS() {
		moabs++;
		increaseKicks();
	}
	
	public int getKicks() {
		return kicks;
	}
	
	private void increaseKicks() {
		kicks++;
	}
}
