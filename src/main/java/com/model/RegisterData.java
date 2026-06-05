package com.model;

import java.time.LocalDateTime;

public class RegisterData {
	private int pid;
    private String patient_name;
    private int patient_age;
    private  String patient_contact;
    private String patient_gender;
    private String patient_discript;
    private LocalDateTime registerTime;
    
    public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPatient_name() {
		return patient_name;
	}
	public void setPatient_name(String patient_name) {
		this.patient_name = patient_name;
	}
	public int getPatient_age() {
		return patient_age;
	}
	public void setPatient_age(int patient_age) {
		this.patient_age = patient_age;
	}
	public String getPatient_contact() {
		return patient_contact;
	}
	public void setPatient_contact(String patient_contact) {
		this.patient_contact = patient_contact;
	}
	public String getPatient_gender() {
		return patient_gender;
	}
	public void setPatient_gender(String patient_gender) {
		this.patient_gender = patient_gender;
	}
	public String getPatient_discript() {
		return patient_discript;
	}
	public void setPatient_discript(String patient_discript) {
		this.patient_discript = patient_discript;
	}
	public LocalDateTime getRegisterTime() {
		return registerTime;
	}
	public void setRegisterTime(LocalDateTime registerTime) {
		this.registerTime = registerTime;
	}
}
