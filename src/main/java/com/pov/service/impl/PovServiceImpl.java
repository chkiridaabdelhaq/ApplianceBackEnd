package com.pov.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pov.dtos.PovDto;
import com.pov.entities.Appliance;
import com.pov.entities.Pov;
import com.pov.mappers.PovMapper;
import com.pov.repository.IPovRepository;
import com.pov.service.interfaces.IPovService;

@Service
@Transactional
public class PovServiceImpl  implements IPovService{
	@Autowired
	private IPovRepository povRepository;

	@Autowired
	private PovMapper povMapper;

	@Override
	public List<PovDto> allPov() {
		List<Pov> list=povRepository.findAll();
		List<PovDto> listPovDtos= new ArrayList<>(1);
		for(Pov pov: list) {
			listPovDtos.add(povMapper.toDto(pov, new PovDto()));
		}
		return listPovDtos;
	}

	@Override
	public PovDto getOnePov(Long id) {
		Pov pov=povRepository.getById(id);
		PovDto povDto=povMapper.toDto(pov, new PovDto());
		return povDto;
	}

	@Override
	public boolean addPov(PovDto povDto) {
		Pov pov=povMapper.toDomain(new Pov(), povDto);
		povRepository.save(pov);
		return true;
	}

	@Override
	public boolean editPov(PovDto povDto) {
		Pov pov=povMapper.toDomain(new Pov(), povDto);
		povRepository.save(pov);
		return true;
	}

	@Override
	public void deletePov(Long id) {
		povRepository.deleteById(id);
		
	}

	@Override
	public List<PovDto> detailPovAppliance(Long idApplaince) {
		Appliance appliance=new Appliance();
		appliance.setId_appliance(idApplaince);
		List<Pov> list=povRepository.findByAppliance(appliance);
		List<PovDto> listDto= new ArrayList<>();
		for(Pov pov:list) {
			listDto.add(povMapper.toDto(pov, new PovDto()));
		}
		return listDto;
	}

	@Override
	public PovDto getSceancePovEncoure(Long id) {
		Pov pov=povRepository.getById(id);
		PovDto povDto= new PovDto();
		povDto.setId_pov(pov.getId_pov());
		povDto.setDateDebut(pov.getDateDebut());
		povDto.setDateFin(pov.getDateFin());
		if(pov.getSceances() != null) {
			povDto.setNbrSeance(pov.getSceances().size());
		}else {
			povDto.setNbrSeance(0);
		}
		return povDto;
	}
	
}
