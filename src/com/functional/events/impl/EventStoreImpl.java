package com.functional.events.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import com.functional.events.Event;
import com.functional.events.EventStore;

public class EventStoreImpl implements EventStore {
	
	private final static Map<String, Event<?>> events = new HashMap<String, Event<?>>();
	
	public void addEvent(String name, Event<?> event) {
		events.put(name, event);
	}
	
	public void executeEvent(String name) {
		events.keySet().stream()
			.filter(matchesString(name))
			.findFirst()
			.ifPresent(executeEvent());
	}
	
	//private Function<String, Predicate<String>> matchesString = x -> y -> x.equalsIgnoreCase(y);
	
	private Predicate<String> matchesString(String string) {
		return x -> x.equalsIgnoreCase(string);
	}
	
	private Consumer<String> executeEvent() {
		return x -> events.get(x).execute();
	}

}
