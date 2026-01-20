package zd.zmk.service.web;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class WebWorkScheduleService {

    // In a real implementation, this would connect to the API
    // For now, we'll return mock data
    
    public List<Map<String, Object>> getWorkSchedule() {
        List<Map<String, Object>> tasks = new ArrayList<>();
        
        // Add some mock tasks
        for (int i = 1; i <= 5; i++) {
            Map<String, Object> task = new HashMap<>();
            task.put("id", i);
            task.put("title", "Maintenance Task #" + i);
            task.put("date", "2026-01-" + (10 + i));
            task.put("assignedTo", "Engineer " + (i % 3 + 1));
            tasks.add(task);
        }
        
        return tasks;
    }
}