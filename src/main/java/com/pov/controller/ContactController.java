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

import com.pov.dtos.ContactDto;
import com.pov.service.interfaces.IContactService;

@RestController
@RequestMapping("/api/v1/")
public class ContactController {

	@Autowired
	private IContactService contactService;
	
	@GetMapping("/contact")
	public List<ContactDto> listContact(){
		return contactService.allContact();
	}
	@PostMapping("/contact/add")
	public boolean createContact(@RequestBody ContactDto contactDto) {
		return contactService.addContact(contactDto);
		
	}
	@GetMapping("/contact/{id}")
	public ContactDto getOneContact(@PathVariable Long id) {
		return contactService.getOneContact(id);
	}
	@PutMapping("/contact/update")
	public boolean updateContact(@RequestBody ContactDto contactDto) {
	  return contactService.editContact(contactDto);
	}
	@DeleteMapping("/contact/{id}")
	public boolean deleteContact(@PathVariable Long id) {
		contactService.deleteContact(id);
		return true ;
	}
	@GetMapping("/contact/client/{id}")
	public List<ContactDto> findContactbyClient(@PathVariable("id") Long idClient){
		return contactService.findContactbyClient(idClient);
	}
}
