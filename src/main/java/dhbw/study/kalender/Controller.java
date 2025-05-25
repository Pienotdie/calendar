package dhbw.study.kalender;

import java.io.*;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Beans.Event;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "calendar", value = "/calendar")
public class Controller extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<Event> events = fetchEvents();
        request.setAttribute("events", events);

        LocalDate today = LocalDate.now();
        LocalDate monday = today.with(DayOfWeek.MONDAY);
        List<LocalDate> weekDays = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            weekDays.add(monday.plusDays(i));
        }
        request.setAttribute("weekDays", weekDays);

        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

    private List<Event> fetchEvents() {
        return List.of(
                new Event("Java", "2025-05-19T10:00:00", "2025-05-19T11:00:00"),
                new Event("Python", "2025-05-19T12:00:00", "2025-05-19T13:00:00"),
                new Event("C++", "2025-05-23T12:00:00", "2025-05-23T16:00:00")
        );
    }
}
