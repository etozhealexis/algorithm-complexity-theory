package ru.etozhealexis.algorithmcomplexitytheory.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.view.RedirectView;
import ru.etozhealexis.algorithmcomplexitytheory.constant.LabEndpoint;

@Controller
public class ViewController {

    @GetMapping(LabEndpoint.REDIRECT)
    public RedirectView redirectToMainPage() {
        return new RedirectView(LabEndpoint.MAIN);
    }

    @GetMapping(LabEndpoint.MAIN)
    public String getMainPage() {
        return "main";
    }

    @GetMapping(LabEndpoint.LAB_1)
    public String getLab1() {
        return "lab1";
    }

    @GetMapping(LabEndpoint.LAB_2)
    public String getLab2() {
        return "lab2";
    }

    @GetMapping(LabEndpoint.LAB_3)
    public String getLab3() {
        return "lab3";
    }

    @GetMapping(LabEndpoint.LAB_4)
    public String getLab4() {
        return "lab4";
    }

    @GetMapping(LabEndpoint.LAB_5)
    public String getLab5() {
        return "lab5";
    }

    @GetMapping(LabEndpoint.LAB_6)
    public String getLab6() {
        return "lab6";
    }
}
