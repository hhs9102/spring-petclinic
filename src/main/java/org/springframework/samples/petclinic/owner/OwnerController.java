/*
 * Copyright 2012-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.samples.petclinic.owner;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.samples.petclinic.test.event.RegistOwnerEvent;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Juergen Hoeller
 * @author Ken Krebs
 * @author Arjen Poutsma
 * @author Michael Isvy
 */
@Controller
class OwnerController {

    private static final String VIEWS_OWNER_CREATE_OR_UPDATE_FORM = "owners/createOrUpdateOwnerForm";
    private final OwnerRepository owners;


    public OwnerController(OwnerRepository clinicService) {
        this.owners = clinicService;
    }

    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

    @GetMapping("/owners/serialization")
    public String serializationOwners(Owner owner, Map<String, Object> model) throws IOException {
    	owner.setLastName("");
    	Collection<Owner> results = this.owners.findByLastName(owner.getLastName());

    	FileOutputStream fos = new FileOutputStream("C:\\workspace\\serialization\\ownersSerialization");
    	ObjectOutputStream oos = new ObjectOutputStream(fos);
    	for(Owner o : results) {
    		oos.writeObject(o);
    	}
    	model.put("selections", results);
        return "owners/ownersList";
    }
    
    @GetMapping("/owners/deserialization")
    public String deserializationOwners(Owner owner, Map<String, Object> model) throws IOException, ClassNotFoundException {
    	Collection<Owner> results = new ArrayList<Owner>();
    	FileInputStream fis = new FileInputStream("C:\\workspace\\serialization\\ownersSerialization");
    	ObjectInputStream ois = new ObjectInputStream(fis);
    	for(int i=0 ; i<10; i++) {
    		results.add((Owner) ois.readObject());
    	}
    	model.put("selections", results);
        return "owners/ownersList";
    }
    
    @GetMapping("/owner/json")
    public String json(Owner owner, Map<String, Object> model) throws IOException, ClassNotFoundException {
    	owner.setLastName("");
    	Collection<Owner> results = this.owners.findByLastName(owner.getLastName());
    	Owner o = results.iterator().next();
    	
    	System.out.println(String.format("{\"id\":\"%s\",\"lastName\":\"%s\",\"firstName\":\"%s\"}", o.getId(),o.getLastName(), o.getFirstName()));
    	
        return "owners/ownersList";
    }
    
    @GetMapping("/owners/new")
    public String initCreationForm(Map<String, Object> model) {
        Owner owner = new Owner();
        model.put("owner", owner);
        return VIEWS_OWNER_CREATE_OR_UPDATE_FORM;
    }

    @Autowired
    ApplicationEventPublisher eventPublisher;
    
    @PostMapping("/owners/new")
    public String processCreationForm(@Valid Owner owner, BindingResult result) {
        if (result.hasErrors()) {
        	result.getAllErrors().stream().forEach(System.out::println);
            return VIEWS_OWNER_CREATE_OR_UPDATE_FORM;
        } else {
            this.owners.save(owner);
            eventPublisher.publishEvent(new RegistOwnerEvent(owner.getFirstName()));
            return "redirect:/owners/" + owner.getId();
        }
    }

    @GetMapping("/owners/find")
    public String initFindForm(Map<String, Object> model) {
        model.put("owner", new Owner());
        return "owners/findOwners";
    }

    @GetMapping("/owners")
    public String processFindForm(Owner owner, BindingResult result, Map<String, Object> model) {

        // allow parameterless GET request for /owners to return all records
        if (owner.getLastName() == null) {
            owner.setLastName(""); // empty string signifies broadest possible search
        }

        // find owners by last name
        Collection<Owner> results = this.owners.findByLastName(owner.getLastName());
        if (results.isEmpty()) {
            // no owners found
            result.rejectValue("lastName", "notFound", "not found");
            return "owners/findOwners";
        } else if (results.size() == 1) {
            // 1 owner found
            owner = results.iterator().next();
            return "redirect:/owners/" + owner.getId();
        } else {
            // multiple owners found
            model.put("selections", results);
            return "owners/ownersList";
        }
    }

    @GetMapping("/owners/{ownerId}/edit")
    public String initUpdateOwnerForm(@PathVariable("ownerId") int ownerId, Model model) {
        Owner owner = this.owners.findById(ownerId);
        model.addAttribute(owner);
        return VIEWS_OWNER_CREATE_OR_UPDATE_FORM;
    }

    @PostMapping("/owners/{ownerId}/edit")
    public String processUpdateOwnerForm(@Valid Owner owner, BindingResult result, @PathVariable("ownerId") int ownerId) {
        if (result.hasErrors()) {
            return VIEWS_OWNER_CREATE_OR_UPDATE_FORM;
        } else {
            owner.setId(ownerId);
            this.owners.save(owner);
            return "redirect:/owners/{ownerId}";
        }
    }

    /**
     * Custom handler for displaying an owner.
     *
     * @param ownerId the ID of the owner to display
     * @return a ModelMap with the model attributes for the view
     */
    @GetMapping("/owners/{ownerId}")
    public ModelAndView showOwner(@PathVariable("ownerId") int ownerId) {
        ModelAndView mav = new ModelAndView("owners/ownerDetails");
        mav.addObject(this.owners.findById(ownerId));
        return mav;
    }

}
