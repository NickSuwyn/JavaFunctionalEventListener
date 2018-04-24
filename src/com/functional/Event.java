package com.functional;

import java.util.function.Consumer;

public class Event<T> {
	
	private T data;
	private Consumer<T> action;
	
	public Event(T data, Consumer<T> action) {
		this.data = data;
		this.action = action;
	}
	
	public void execute() {
		action.accept(data);
	}

}
