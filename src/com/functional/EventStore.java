package com.functional;

import java.util.HashMap;
import java.util.Map;

public class EventStore {
	
	private final static Map<String, Event<?>> events = new HashMap<String, Event<?>>();
	
	public static void addEvent(String name, Event<?> event) {
		events.put(name, event);
	}
	
	public static void executeEvent(String name) {
		events.keySet().stream()
			.filter(x -> x.equalsIgnoreCase(name))
			.findFirst()
			.ifPresent(x -> events.get(x).execute());
	}

}
