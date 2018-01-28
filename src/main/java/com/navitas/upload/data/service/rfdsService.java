package com.navitas.upload.data.service;


import com.navitas.upload.data.entity.*;
import com.navitas.upload.data.repository.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class rfdsService {
	
	@Autowired
	rfdsRepository  rfdsrepository;
	
	public void save(rfds_Images image){
		rfdsrepository.save(image);
		rfdsrepository.flush();
	}
	
}