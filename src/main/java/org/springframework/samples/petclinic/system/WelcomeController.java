package org.springframework.samples.petclinic.system;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
class WelcomeController {
    @Autowired
    Environment env;


    @Value("#{systemEnvironment['APP_NAMESPACE']?:'default'}")
    private String APP_NAMESPACE;

    @GetMapping("/")
    public String welcome(ModelMap map) {
        String environment = APP_NAMESPACE;
        /*if(env.getActiveProfiles().length > 0){
            environment = env.getActiveProfiles()[0];
        }*/
        map.addAttribute("env", environment);
        return "welcome";
    }

}