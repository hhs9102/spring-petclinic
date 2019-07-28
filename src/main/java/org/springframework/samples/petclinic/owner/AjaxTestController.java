package org.springframework.samples.petclinic.owner;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class AjaxTestController {

    @GetMapping("/hamtest")
    public String hamtest(Map<String, Object> ham){

        Map<String, String> obj = new HashMap<String, String>();
        obj.put("name", "HOSIK HAM");
        obj.put("company", "COMPANY");
        ham.put("obj", obj);
        return "ham/hamtest";
    }

    @GetMapping("/age")
    public @ResponseBody String age(){
        return "30";
    }
}
