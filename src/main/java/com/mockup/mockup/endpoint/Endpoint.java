package com.mockup.mockup.endpoint;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/admin")
public class Endpoint {

    @PostMapping("/greeting")
    public @ResponseBody String greeting()
    {
        return "test response";
    }

}
