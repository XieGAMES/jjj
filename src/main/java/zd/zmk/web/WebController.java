package zd.zmk.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Locale;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.LocaleResolver;
import zd.zmk.service.web.WebVendingMachineService;
import zd.zmk.service.web.WebMaintenanceService;
import zd.zmk.service.web.WebWorkScheduleService;

@Controller
@RequestMapping("/")
public class WebController {

    @Autowired
    private LocaleResolver localeResolver;

    @Autowired
    private WebVendingMachineService webVendingMachineService;

    @Autowired
    private WebMaintenanceService webMaintenanceService;

    @Autowired
    private WebWorkScheduleService webWorkScheduleService;

    @GetMapping
    public String home(Model model, Locale locale) {
        model.addAttribute("title", "Home");
        return "index";
    }

    @GetMapping("/vending-machines")
    public String vendingMachines(Model model) {
        model.addAttribute("title", "Vending Machines");
        model.addAttribute("vendingMachines", webVendingMachineService.getAllVendingMachines().getContent());
        return "vending-machines";
    }

    @GetMapping("/maintenance-calendar")
    public String maintenanceCalendar(Model model) {
        model.addAttribute("title", "Maintenance Calendar");
        // In a real implementation, we would fetch calendar data from service
        // For now, we'll add some mock data
        model.addAttribute("days", webMaintenanceService.getCalendarData(2026, 1).get("days"));
        return "maintenance-calendar";
    }

    @GetMapping("/work-schedule")
    public String workSchedule(Model model) {
        model.addAttribute("title", "Work Schedule");
        // In a real implementation, we would fetch schedule data from service
        model.addAttribute("tasks", webWorkScheduleService.getWorkSchedule());
        return "work-schedule";
    }

    // Language switcher endpoint
    @PostMapping("/lang")
    public String changeLanguage(
            @RequestParam("lang") String lang,
            HttpServletRequest request,
            HttpServletResponse response) {

        Locale locale = new Locale(lang);
        localeResolver.setLocale(request, response, locale);

        return "redirect:" + request.getHeader("Referer");
    }
}