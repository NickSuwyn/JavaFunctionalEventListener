package com.functional;

import java.util.Scanner;

public class Application {
	
	private static final String EXIT = "exit";
	
	public static void main(String[] args) {
		
		EventStore.addEvent("Test", new Event<String>("Test", x -> System.out.println(x + " working so far!")));
		
		String selection = "";
		Scanner in = new Scanner(System.in);
		
		while (!(selection = in.nextLine()).equalsIgnoreCase(EXIT)) {
			EventStore.executeEvent(selection);			
		}
	}
	
	
	
}
