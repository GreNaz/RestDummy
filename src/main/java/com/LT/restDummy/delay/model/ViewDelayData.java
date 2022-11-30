package com.LT.restDummy.delay.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/*TODO Что это зачем это*/
// TODO заменить на @data
@Getter
@Setter
public class ViewDelayData {

	private String name;
	private Long delay;
	private Long timeout;
	private Boolean isAvailable;
//	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
//private LocalDateTime scheduler;
	private String scheduler;
//	protected static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");


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

	public ViewDelayData(String name, Long delay, Long timeout, Boolean isAvailable, String scheduler) {
		this.name = name;
		this.delay = delay;
		this.timeout = timeout;
		this.isAvailable = isAvailable;
		this.scheduler = scheduler;
	}

//	public ViewDelayData(String name, Long delay, Long timeout, Boolean isAvailable, LocalDateTime scheduler) {
//		this.name = name;
//		this.delay = delay;
//		this.timeout = timeout;
//		this.isAvailable = isAvailable;
//		this.scheduler = scheduler;
//	}
	public ViewDelayData() {
		this.name = "rand";
		this.delay = 0L;
		this.timeout = 0L;
		this.isAvailable = false;
	}
}
