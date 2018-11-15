package com.engine.templateengine.cars;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("")
public class CarController {

	@GetMapping("/form")
	public String getResult(@ModelAttribute Car car, Model model) {
		model.addAttribute("value1", "value1");
		model.addAttribute("value2", "value2");
		return "carForm";
	}

	@PostMapping("/form")
	public String getForm(Model model, Car car) {
		model.addAttribute(car);
		model.addAttribute("name", car.getName());
		Map<String, Car> mapa = new HashMap<>();
		mapa.put("Kubica", car);
		mapa.put("Raikonnen", car);
		model.addAttribute("f1", mapa);
		model.addAttribute("title", "car-result");
		return "carResult";
	}

	@GetMapping("/{value}")
	public void redirect(HttpServletResponse response) throws IOException {
		response.sendRedirect("/form");
	}

	@GetMapping("/form/ferrari")
	@ResponseBody
	public String goToNamePath() {
		return "path is your name";
	}


}
