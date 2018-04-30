package com.functional;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.functional.events.EventData;
import com.functional.events.EventStore;
import com.functional.events.impl.EventDataImpl;
import com.functional.events.impl.EventImpl;
import com.functional.events.impl.EventStoreImpl;

public class Application {
	
	private static final EventStore eventStore = new EventStoreImpl();
	
	private static final String EXIT = "exit";
	
	public static void main(String[] args) {
		
		eventStore.addEvent("Test", new EventImpl(x -> System.out.println((String)x.getData() + " working so far!")));
		
		String selection = "";
		Scanner in = new Scanner(System.in);
		List<String> parsedSelection;
		System.out.print("Enter event: ");
		
		while (!(selection = in.nextLine()).equalsIgnoreCase(EXIT)) {
			parsedSelection = parseSelection(selection);
			
			while (parsedSelection.size() < 2) {
				parsedSelection.add("");
			}
			
			String eventName = parsedSelection.get(0);
			EventData<String> eventData = new EventDataImpl<String>(parsedSelection.get(1));
			eventStore.executeEvent(eventName, eventData);
			System.out.print("Enter event: ");
		}
		
		in.close();
	}
	
	private static List<String> parseSelection(String selection) {
		return Stream.of(selection.split("::"))
			.collect(Collectors.toList());
	}
	
}
