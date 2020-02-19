package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Arashi;
import com.example.repository.ArashiRepository;

@Service
@Transactional
public class ArashiService {
	
	@Autowired
	private ArashiRepository arashiRepository;
	
	/**
	 * 全件検索.
	 * @return
	 */
	public List<Arashi> findAll(){
		return arashiRepository.findAll();
	}

}
