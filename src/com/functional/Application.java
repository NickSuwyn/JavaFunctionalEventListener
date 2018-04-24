package com.functional;

import java.util.Scanner;

import com.functional.events.EventStore;
import com.functional.events.impl.EventImpl;
import com.functional.events.impl.EventStoreImpl;

public class Application {
	
	private static final EventStore eventStore = new EventStoreImpl();
	
	private static final String EXIT = "exit";
	
	public static void main(String[] args) {
		
		eventStore.addEvent("Test", new EventImpl<String>("Test", x -> System.out.println(x + " working so far!")));
		
		String selection = "";
		Scanner in = new Scanner(System.in);
		
		while (!(selection = in.nextLine()).equalsIgnoreCase(EXIT)) {
			eventStore.executeEvent(selection);			
		}
	}
	
	
	
}
