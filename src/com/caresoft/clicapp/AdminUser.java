package com.caresoft.clicapp;
import java.util.ArrayList;
import java.util.Date;

public class AdminUser extends User implements HIPAACompliantAdmin, HIPAACompliantUser{
    
    private Integer employeeID;
    private String role;
    private ArrayList<String> securityIncidents;
    
    
    public AdminUser(Integer employeeID, String role) {
    	super();
		this.employeeID = employeeID;
		this.role = role;
		this.securityIncidents = new ArrayList<>();
	}
    
    public boolean assignPin(int pin) {
    	if (pin <= 999999 & pin >= 100000) {
    		this.pin = pin;
    		return true;
    	}
    	return false;
    }
    
    public boolean accessAuthorized(Integer confirmedAuthID) {
    	if (this.employeeID == confirmedAuthID) {
    		return true;
    	}
    	return false;
    }
    
    public ArrayList<String>reportSecurityIncidents(){
    	for(String incident : securityIncidents) {
    		System.out.println(incident);
    	}
    	return securityIncidents;
    }
    
	public void newIncident(String notes) {
        String report = String.format(
            "Datetime Submitted: %s \n,  Reported By ID: %s\n Notes: %s \n", 
            new Date(), this.id, notes
        );
        securityIncidents.add(report);
    }
    public void authIncident() {
        String report = String.format(
            "Datetime Submitted: %s \n,  ID: %s\n Notes: %s \n", 
            new Date(), this.id, "AUTHORIZATION ATTEMPT FAILED FOR THIS USER"
        );
        securityIncidents.add(report);
    }
	public Integer getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(Integer employeeID) {
		this.employeeID = employeeID;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public ArrayList<String> getSecurityIncidents() {
		return securityIncidents;
	}
	public void setSecurityIncidents(ArrayList<String> securityIncidents) {
		this.securityIncidents = securityIncidents;
	}
    
}
