package com.functional.events.impl;

import com.functional.events.EventData;

public class EventDataImpl<T> implements EventData<T> {
	
	private T data;
	
	public EventDataImpl(T data) {
		this.data = data;
	}

	@Override
	public T getData() {
		return data;
	}

}
