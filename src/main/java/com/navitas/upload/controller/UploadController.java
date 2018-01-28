package com.navitas.upload.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.beans.factory.annotation.Autowired;

import com.navitas.upload.data.entity.*;
import com.navitas.upload.data.service.*;
import com.navitas.upload.data.repository.rfdsRepository;

@RestController
@RequestMapping("fraud")
public class UploadController
{
	
	@Autowired
	rfdsRepository  rfdsrepository;
	
	@RequestMapping(value = "uploaddata", method = RequestMethod.POST)
	public ResponseEntity<String> uploadDataFile(
	@RequestParam(value = "file", required = true) MultipartFile file , String uniquecode , String username )
	{
	 
	   if ( file != null )
	   {
		try
	     {  
		   rfdspk risk = new rfdspk( uniquecode);
		   rfds_Images img = new rfds_Images( risk , username , file.getBytes() );
		   rfdsrepository.save(img);
		   rfdsrepository.flush();
	     }
	     catch ( FileNotFoundException e )
	     {
	    	 System.out.println( e );
	     }
	     catch ( IOException e )
	     {
	    	 System.out.println( e );
	     }
		 
	     return new ResponseEntity<String>( HttpStatus.OK );
	   }
	   else
	   {
	     return new ResponseEntity<String>( HttpStatus.NOT_FOUND );
	   }
	}
	
	
	
}
