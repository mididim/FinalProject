package lv.sda.finalproject.controller;

import lv.sda.finalproject.dto.NumberForm;
import lv.sda.finalproject.service.SumHistoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {
    private SumHistoryService sumHistoryService;

    public HomeController(SumHistoryService sumHistoryService){
        this.sumHistoryService = sumHistoryService;
    }

    @GetMapping("/")
    public String homepage(Model model){
        model.addAttribute("numberForm", new NumberForm());
        return "index";
    }

    @PostMapping("/sum")
    public String calculate(NumberForm form, Model model){
        Integer sum = sumHistoryService.sum(form);

        model.addAttribute("sum", sum);
        model.addAttribute("history", sumHistoryService.findHistory());

        return "index";
    }




}
