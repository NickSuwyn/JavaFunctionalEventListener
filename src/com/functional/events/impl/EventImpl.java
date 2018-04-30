package com.functional.events.impl;

import java.util.function.Consumer;

import com.functional.events.Event;
import com.functional.events.EventData;

public class EventImpl implements Event {
	
	private Consumer<EventData<?>> action;
	
	public EventImpl(Consumer<EventData<?>> action) {
		this.action = action;
	}
	
	public void execute(EventData<?> data) {
		action.accept(data);
	}

}
