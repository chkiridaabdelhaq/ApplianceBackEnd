package com.pov.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pov.dtos.TypeDto;
import com.pov.entities.Type;
import com.pov.mappers.TypeMapper;
import com.pov.repository.ITypeRepository;
import com.pov.service.interfaces.ITypeService;
@Service
@Transactional
public class TypeServiceImpl implements ITypeService {
	@Autowired
	private ITypeRepository typeRepository;
	
	@Autowired
	private TypeMapper typeMapper;
	
	@Override
	public List<TypeDto> allTypes() {
		List<Type> list= typeRepository.findAll();
		List<TypeDto> listTypeDtos= new ArrayList<TypeDto>(1);
		for(Type type: list) {
			listTypeDtos.add(typeMapper.toDto(type, new TypeDto()));
		}
		return listTypeDtos ;
	}

	@Override
	public TypeDto oneType(Long id) {
		Type type=typeRepository.getById(id);
		TypeDto typeDto=typeMapper.toDto(type, new TypeDto());
		return typeDto;
	}

	@Override
	public boolean addType(TypeDto typeDto) {
		Type type=typeMapper.toDomain(new Type(), typeDto);
		typeRepository.save(type);
		return true ;
	}

	@Override
	public boolean editType(TypeDto typeDto) {
		Type type=typeMapper.toDomain(new Type(), typeDto);
		typeRepository.save(type);
		return true ;
	}

	@Override
	public void deleteType(Long id) {
		// TODO Auto-generated method stub
		typeRepository.deleteById(id);
		
	}

}
