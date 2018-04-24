package com.functional.events.impl;

import java.util.HashMap;
import java.util.Map;

import com.functional.events.Event;
import com.functional.events.EventStore;

public class EventStoreImpl implements EventStore {
	
	private final static Map<String, Event<?>> events = new HashMap<String, Event<?>>();
	
	public void addEvent(String name, Event<?> event) {
		events.put(name, event);
	}
	
	public void executeEvent(String name) {
		events.keySet().stream()
			.filter(x -> x.equalsIgnoreCase(name))
			.findFirst()
			.ifPresent(x -> events.get(x).execute());
	}

}
