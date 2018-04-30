package com.functional.events;

public interface EventStore {
	
	public void addEvent(String name, Event event);
	
	public void executeEvent(String name, EventData<?> data);

}
