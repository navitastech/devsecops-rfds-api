package com.navitas.upload.data.entity;



import java.io.Serializable;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.PrePersist;
import javax.persistence.Embeddable;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
public class rfdspk implements Serializable {
	
	public rfdspk() {}
	public rfdspk( String unique_code ) {
	
	  this.unique_code = unique_code;
	}
	
	@Column(name = "unique_code", nullable = false)
    private String unique_code;
}