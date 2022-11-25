package com.LT.restDummy.delay.model;

import lombok.Getter;
import lombok.Setter;

/*TODO Что это зачем это*/
// TODO заменить на @data
@Getter
@Setter
public class ViewDelayData {

	private String name;
	private Long delay;
	private Long timeout;
	private Boolean isAvailable;

	public ViewDelayData(String name, Long delay) {
		this.name = name;
		this.delay = delay;
	}

	public ViewDelayData(String name, Long delay, Long timeout) {
		this.name = name;
		this.delay = delay;
		this.timeout = timeout;
	}

	public ViewDelayData(String name, Long delay, Long timeout, Boolean isAvailable) {
		this.name = name;
		this.delay = delay;
		this.timeout = timeout;
		this.isAvailable = isAvailable;
	}
	public ViewDelayData() {
		this.name = "rand";
		this.delay = 0L;
		this.timeout = 0L;
		this.isAvailable = false;
	}
}
