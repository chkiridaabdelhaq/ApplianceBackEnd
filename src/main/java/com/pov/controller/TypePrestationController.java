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

import com.pov.dtos.TypePrestationDto;
import com.pov.service.interfaces.ITypePrestationService;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*")
public class TypePrestationController {

	@Autowired
	private ITypePrestationService prestationService;
	
	@GetMapping("/prestation")
	public List<TypePrestationDto> allTypePrestation(){
		return prestationService.allTypePrestations();
	}
	@PostMapping("/prestation/add")
	public boolean createTypePrestation(@RequestBody TypePrestationDto prestationDto) {
		return prestationService.addTypePrestation(prestationDto);
	}
	@GetMapping("/prestation/{id}")
	public TypePrestationDto getOneTypePrestation(@PathVariable Long id) {
		return prestationService.getOneTypePrestation(id);
	}
	@PutMapping("/prestation/update")
	public boolean updateTypePrestation(@RequestBody TypePrestationDto prestationDto) {
		return prestationService.editTypePrestation(prestationDto);
	}
	@DeleteMapping("/prestation/{id}")
	public boolean deleteTypePrestation(@PathVariable Long id) {
		prestationService.deleteTypePrestation(id);
		return true;
	}
}
