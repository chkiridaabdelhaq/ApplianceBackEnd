package com.pov.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pov.dtos.PovDto;
import com.pov.service.interfaces.IPovService;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "*")
public class PovController {
	
	@Autowired
	private IPovService povService;
	
	@GetMapping("/povs")
	public List<PovDto> listPov(){
	 return	 povService.allPov();
	}
	
	@PostMapping("/povs/add")
	public boolean createPov(@RequestBody PovDto povDto) {
	 return  povService.addPov(povDto);
	}
	@GetMapping("/povs/{id}")
	public PovDto getOnePov(@PathVariable Long id) {
		return povService.getOnePov(id);
	}
	@PutMapping("/povs/update")
	public boolean updatePov(@RequestBody PovDto povDto) {
		return povService.editPov(povDto);
	}
	@DeleteMapping("/povs/{id}")
		public boolean deletePov(@PathVariable Long id) {
			povService.deletePov(id);
			return true;
		}
	@GetMapping("/povs/detail/{id}")
	public List<PovDto> detailPovAppliance(@PathVariable("id") Long idAppliance){
		return povService.detailPovAppliance(idAppliance);
	}
	@GetMapping("/povs/nbSeance/{id}")
	public PovDto getSceancePovEncoure(@PathVariable Long id) {
		return povService.getSceancePovEncoure(id);
	}
}
