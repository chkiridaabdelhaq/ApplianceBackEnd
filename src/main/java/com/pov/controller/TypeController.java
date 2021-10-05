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

import com.pov.dtos.TypeDto;
import com.pov.service.interfaces.ITypeService;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*")
public class TypeController {

	@Autowired
	private ITypeService typeService;
	
	@GetMapping("/type")
	public List<TypeDto> allType(){
		return typeService.allTypes();
	}
	@PostMapping("/type/add")
	public boolean createType(@RequestBody TypeDto typeDto) {
		return typeService.addType(typeDto);
	}
	@GetMapping("/type/{id}")
	public TypeDto getOneType(@PathVariable Long id) {
		return typeService.oneType(id);
	}
	@PutMapping("/type/update")
	public boolean updateType(@RequestBody TypeDto typeDto) {
		return typeService.editType(typeDto);
	}
	@DeleteMapping("/type/{id}")
	public boolean deleteType(@PathVariable Long id) {
		typeService.deleteType(id);
		return true ;
	}
}
