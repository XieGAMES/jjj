package zd.zmk.service.web;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class WebMaintenanceService {

    // In a real implementation, this would connect to the API
    // For now, we'll return mock data
    
    public Map<String, Object> getCalendarData(int year, int month) {
        Map<String, Object> calendarData = new HashMap<>();
        
        // Generate days for the month
        List<Map<String, Object>> days = new ArrayList<>();
        
        // Calculate number of days in month
        int daysInMonth = LocalDate.of(year, month, 1).lengthOfMonth();
        
        for (int day = 1; day <= daysInMonth; day++) {
            Map<String, Object> dayData = new HashMap<>();
            dayData.put("number", day);
            
            // Add some mock events
            List<Map<String, String>> events = new ArrayList<>();
            if (day % 7 == 0 || day % 7 == 1) { // Weekend
                Map<String, String> event = new HashMap<>();
                event.put("title", "Scheduled Maintenance");
                events.add(event);
            }
            
            dayData.put("events", events);
            days.add(dayData);
        }
        
        calendarData.put("days", days);
        calendarData.put("year", year);
        calendarData.put("month", month);
        
        return calendarData;
    }
}