package vttp.groupb.ssf.Day18.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import vttp.groupb.ssf.Day18.models.CarPark;
import vttp.groupb.ssf.Day18.services.CarParkService;

import java.util.List;

@Controller
public class CarParkController {

    @Autowired
    private CarParkService carParkService;

    @GetMapping("/search")
    public String search(Model model) {
        List<CarPark> carparkData = carParkService.getCarParks();
        model.addAttribute("carparkData", carparkData);
        return "carparks";
    }

}
