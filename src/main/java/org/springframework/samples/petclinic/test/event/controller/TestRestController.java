package org.springframework.samples.petclinic.test.event.controller;


import net.minidev.json.JSONObject;
import org.springframework.samples.petclinic.owner.Owner;
import org.springframework.samples.petclinic.owner.OwnerRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class TestRestController {

    OwnerRepository ownerRepository;

    public TestRestController(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @GetMapping("overheadtest")
    public @ResponseBody  JSONObject overheadtest(){
        Map<String, String> dog = new HashMap<>();
        dog.put("age", "3");
        dog.put("name", "또또");
        dog.put("addres","중구");
        dog.put("owner","함호식");
        JSONObject jsonObject = new JSONObject();
        for(Map.Entry<String, String> entry : dog.entrySet()){
            jsonObject.put(entry.getKey(), entry.getValue());
        }
        List<Owner> ownerList = ownerRepository.findListByLastName("");
        System.out.println(ownerList);
        return jsonObject;
    }
}
