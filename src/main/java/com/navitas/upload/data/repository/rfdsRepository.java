
package com.navitas.upload.data.repository;

import java.util.List;
import com.navitas.upload.data.entity.*;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface rfdsRepository extends JpaRepository<rfds_Images, rfdspk> {
	
	
}