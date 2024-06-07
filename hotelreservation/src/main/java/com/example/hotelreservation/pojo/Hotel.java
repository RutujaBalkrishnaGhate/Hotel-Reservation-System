package com.example.hotelreservation.pojo;

import org.springframework.stereotype.Component;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="hoteltable")
@Component
public class Hotel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="hotelid")
	private int hotelid;
	private String hotelname;
	private String hotelemail;
	private long hotelcontact;
	private String hotelcity;
	private String hoteladdress;
	
	
	public Hotel() {
		
	}
	
	public int getHotelid() {
		return hotelid;
	}
	public void setHotelid(int hotelid) {
		this.hotelid = hotelid;
	}
	public String getHotelname() {
		return hotelname;
	}
	public void setHotelname(String hotelname) {
		this.hotelname = hotelname;
	}
	public String getHotelemail() {
		return hotelemail;
	}
	public void setHotelemail(String hotelemail) {
		this.hotelemail = hotelemail;
	}
	public long getHotelcontact() {
		return hotelcontact;
	}
	public void setHotelcontact(long hotelcontact) {
		this.hotelcontact = hotelcontact;
	}
	public String getHotelcity() {
		return hotelcity;
	}
	public void setHotelcity(String hotelcity) {
		this.hotelcity = hotelcity;
	}
	public String getHoteladdress() {
		return hoteladdress;
	}
	public void setHoteladdress(String hoteladdress) {
		this.hoteladdress = hoteladdress;
	}
	
	

}

