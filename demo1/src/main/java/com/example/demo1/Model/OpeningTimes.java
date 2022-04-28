package com.example.demo1.Model;
import java.time.DayOfWeek;
import java.time.LocalTime;


public class OpeningTimes {

	    private DayOfWeek dayOfWeek;
	    private LocalTime from;
	    private LocalTime to;

	    public DayOfWeek getDayOfWeek() {
	        return dayOfWeek;
	    }

	    public void setDayOfWeek(DayOfWeek dayOfWeek) {
	        this.dayOfWeek = dayOfWeek;
	    }

	    public LocalTime getFrom() {
	        return from;
	    }

	    public void setFrom(LocalTime from) {
	        this.from = from;
	    }

	    public LocalTime getTo() {
	        return to;
	    }

	    public void setTo(LocalTime to) {
	        this.to = to;
	    }
	}
