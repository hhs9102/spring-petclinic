package org.springframework.samples.petclinic.test.event;

import org.springframework.context.event.EventListener;
import org.springframework.samples.petclinic.owner.Owner;
import org.springframework.stereotype.Component;

@Component
public class RegistOwnerEventHandler {
	
	@EventListener
	public void handle(RegistOwnerEvent event){
		System.out.println("이벤트 발생 ::::::"+event.getName());
	}

}
