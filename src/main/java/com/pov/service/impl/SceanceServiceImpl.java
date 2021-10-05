package com.pov.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pov.dtos.PovDto;
import com.pov.dtos.SceanceDto;
import com.pov.entities.Pov;
import com.pov.entities.Sceance;
import com.pov.mappers.SceanceMapper;
import com.pov.repository.ISceanceRepository;
import com.pov.service.interfaces.ISceanceService;

@Service
@Transactional
public class SceanceServiceImpl implements ISceanceService {
	@Autowired
	private ISceanceRepository sceanceRepository;
	@Autowired
	private SceanceMapper sceanceMapper;

	@Override
	public List<SceanceDto> allSceance() {
		List<Sceance> list=sceanceRepository.findAll();
		List<SceanceDto> listSceanceDtos=new ArrayList<>(1);
		for(Sceance sceance: list) {
			listSceanceDtos.add(sceanceMapper.toDto(sceance, new SceanceDto()));
		}
		return listSceanceDtos;
	}

	@Override
	public SceanceDto getOneSceance(Long id) {
		Sceance sceance=sceanceRepository.getById(id);
		SceanceDto sceanceDto=sceanceMapper.toDto(sceance, new SceanceDto());
		return sceanceDto;
	}

	@Override
	public boolean addSceance(SceanceDto sceanceDto) {
		Sceance sceance=sceanceMapper.toDomain(new Sceance(), sceanceDto);
		sceanceRepository.save(sceance);
		return true;
	}

	@Override
	public boolean editSceance(SceanceDto sceanceDto) {
		Sceance sceance=sceanceMapper.toDomain(new Sceance(), sceanceDto);
		sceanceRepository.save(sceance);
		return true ;
	}

	@Override
	public void deleteSceance(Long id) {
		sceanceRepository.deleteById(id);
	}

	@Override
	public List<SceanceDto> findSceanceByPov(Long idPov) {
		Pov pov=new Pov();
		pov.setId_pov(idPov);
		List<Sceance> list=sceanceRepository.findByPov(pov);
		List<SceanceDto> listDtos=new ArrayList<>();
		for(Sceance sceance:list) {
			listDtos.add(sceanceMapper.toDto(sceance,new SceanceDto()));
		}
		return listDtos;
	}

}
