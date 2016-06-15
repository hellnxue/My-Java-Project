package com.java.Polymorphic;

public class Music {

	public static void tune(Instrument i){
		i.play(Note.MIDDLE_C);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Wind flute=new Wind();
		tune(flute);

	}

}
