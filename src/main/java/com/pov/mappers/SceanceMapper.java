package com.pov.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pov.dtos.PovDto;
import com.pov.dtos.SceanceDto;
import com.pov.entities.Pov;
import com.pov.entities.Sceance;

@Component
public class SceanceMapper {
	
	@Autowired
	private PovMapper povMapper;
	
	public SceanceDto toDto(Sceance sceance, SceanceDto sceanceDto) {
		if(sceanceDto == null)
			sceanceDto = new SceanceDto();
		sceanceDto.setId_sceance(sceance.getId_sceance());
		sceanceDto.setParticipants(sceance.getParticipants());
		sceanceDto.setResumer(sceance.getResumer());
		sceanceDto.setDateSceance(sceance.getDateSceance());
		if(sceance.getPov() != null) {
			sceanceDto.setId_pov(sceance.getPov().getId_pov());
			sceanceDto.setLibellePov(sceance.getPov().getLibellePov());
		}
		return sceanceDto ;
	}
	
	public Sceance toDomain(Sceance sceance,SceanceDto sceanceDto) {
		if(sceance ==null)
			sceance = new Sceance();
		sceance.setId_sceance(sceanceDto.getId_sceance());
		sceance.setParticipants(sceanceDto.getParticipants());
		sceance.setResumer(sceanceDto.getResumer());
		sceance.setDateSceance(sceanceDto.getDateSceance());
		if(sceanceDto.getId_pov() != null) {
			Pov pov=new Pov();
			pov.setId_pov(sceanceDto.getId_pov());
			sceance.setPov(pov);
		}
		return sceance ;
	}
}
