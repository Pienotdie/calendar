package Beans;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class Event {
    private String title;
    private String start;
    private String end;

    public Event(String title, String start, String end) {
        this.title = title;
        this.start = start;
        this.end = end;
    }

    public String getTitle() { return title; }
    public String getStart() { return start; }
    public String getEnd() { return end; }

    public LocalDateTime getStartDateTime() {
        return LocalDateTime.parse(start, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    }

    public LocalDateTime getEndDateTime() {
        return LocalDateTime.parse(end, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    }

    public int getDayOfWeekIndex() {
        return getStartDateTime().getDayOfWeek().getValue(); // 1 = Montag
    }

    public int getStartOffsetMinutes() {
        return (getStartDateTime().getHour() * 60 + getStartDateTime().getMinute()) - 480; // ab 8:00 Uhr
    }

    public int getDurationMinutes() {
        return (int) Duration.between(getStartDateTime(), getEndDateTime()).toMinutes();
    }

    public String getFormattedTimeRange() {
        return getStartDateTime().toLocalTime() + " – " + getEndDateTime().toLocalTime();
    }

    public int getTopPx() {
        return (int)(getStartOffsetMinutes() * 2.0 / 3.0) + 40;
    }

    public int getHeightPx() {
        return (int)(getDurationMinutes() * 2.0 / 3.0);
    }
}
