package com.navitas.upload.data.entity;



import java.io.Serializable;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.PrePersist;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.EmbeddedId;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "rfds_Images", schema = "public")
public class rfds_Images implements Serializable {
	

	public rfds_Images( rfdspk unique_code , String user_name , byte[] image ) {
	  this.unique_code = unique_code;
	  this.user_name = user_name;
	  this.image = image;
	
	}
	
    @EmbeddedId
    private rfdspk unique_code;

    @Column(name = "image", nullable = false)
    private byte[] image;

    @Column(name = "user_name", nullable = false)
    private String user_name;
	
	@Column(name = "notes", nullable = true)
    private String notes;
	
	@Column(name = "approved", nullable = true)
    private Boolean approved = false;
	
	@Column(name = "created_date", nullable = false)
    private Date created_date;
	
	
	@PrePersist
    protected void onCreate() {
      created_date = new Date();
    }

}