package org.springframework.samples.petclinic.test.event;

public class RegistOwnerEvent {
	
	private String name;
	
	public RegistOwnerEvent(String name) {
		this.name = name;
	}
	
	public String getName(){
		return this.name;
	}

}
