package com.functional.events.impl;

import java.util.function.Consumer;

import com.functional.events.Event;

public class EventImpl<T> implements Event<T> {
	
	private T data;
	private Consumer<T> action;
	
	public EventImpl(T data, Consumer<T> action) {
		this.data = data;
		this.action = action;
	}
	
	public void execute() {
		action.accept(data);
	}

}
