package com.pov.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pov.dtos.SceanceDto;
import com.pov.service.interfaces.ISceanceService;

@RestController
@RequestMapping("/api/v1")
public class SceanceController {

	@Autowired
	private ISceanceService sceanceService;
	
	
	@GetMapping("/sceance")
	public List<SceanceDto> allSceance(){
		return sceanceService.allSceance();
	}
	@PostMapping("/sceance/add")
	public boolean createSceance(@RequestBody SceanceDto sceanceDto) {
		return sceanceService.addSceance(sceanceDto);
	}
	@GetMapping("/sceance/{id}")
	public SceanceDto getOneSceance(@PathVariable Long id) {
		return sceanceService.getOneSceance(id);
	}
	@PutMapping("/sceance/update")
	public boolean updateSceance(@RequestBody SceanceDto sceanceDto) {
		return sceanceService.editSceance(sceanceDto);
	}
	@DeleteMapping("/sceance/{id}")
	public boolean deleteSceance(@PathVariable Long id) {
		sceanceService.deleteSceance(id);
		return true ;
	}
	@GetMapping("/sceance/pov/{id}")
	public List<SceanceDto> findSceanceByPov(@PathVariable("id") Long idPov){
		return sceanceService.findSceanceByPov(idPov);
	}
}
