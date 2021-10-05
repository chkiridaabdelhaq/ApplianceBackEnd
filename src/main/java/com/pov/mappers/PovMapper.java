package com.pov.mappers;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pov.dtos.ApplianceDto;
import com.pov.dtos.ClientDto;
import com.pov.dtos.PovDto;
import com.pov.entities.Appliance;
import com.pov.entities.Client;
import com.pov.entities.Pov;

@Component
public class PovMapper {

	@Autowired
	private ApplianceMapper applianceMapper;
	
	@Autowired
	private ClientMapper clientMapper;
	
	public PovDto toDto(Pov pov,PovDto povDto) {
		
		Date date= new Date();
		
		if(povDto == null)
			povDto = new PovDto();
		povDto.setId_pov(pov.getId_pov());
		povDto.setLibellePov(pov.getLibellePov());
		povDto.setAnalyseCyber(pov.getAnalyseCyber());
		povDto.setIngenieurCyber(pov.getIngenieurCyber());
		povDto.setDescription(pov.getDescription());
		povDto.setDateDebut(pov.getDateDebut());
		povDto.setDateFin(pov.getDateFin());
		povDto.setCompteManager(pov.getCompteManager());
		if(povDto.getDateFin() != null && povDto.getDateFin().before(date)) {
			povDto.setStatut(true);
		}else {
			povDto.setStatut(false);
		}
		if(pov.getClient() != null) {
			povDto.setId_client(pov.getClient().getId_client());
			povDto.setLibelleClient(pov.getClient().getLibelleClient());
		}
		if(pov.getAppliance() != null){
			povDto.setId_appliance(pov.getAppliance().getId_appliance());
			povDto.setLibelleApplliance(pov.getAppliance().getLibelleApplliance());
		 }
			return povDto ;
	}
	public Pov toDomain(Pov pov,PovDto povDto) {
		if(pov == null)
			pov = new Pov();
		pov.setId_pov(povDto.getId_pov());
		pov.setLibellePov(povDto.getLibellePov());
		pov.setAnalyseCyber(povDto.getAnalyseCyber());
		pov.setIngenieurCyber(povDto.getIngenieurCyber());
		pov.setDescription(povDto.getDescription());
		pov.setDateDebut(povDto.getDateDebut());
		pov.setDateFin(povDto.getDateFin());
		pov.setCompteManager(povDto.getCompteManager());
		if(povDto.getId_client() != null){
			Client client=new Client();
			client.setId_client(povDto.getId_client());
			pov.setClient(client);
		}
		if(povDto.getId_appliance() != null){
			Appliance appliance= new Appliance();
			appliance.setId_appliance(povDto.getId_appliance());
			pov.setAppliance(appliance);
		}
			return pov ;
	}
}
