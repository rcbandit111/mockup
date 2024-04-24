package com.mockup.mockup.endpoint;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/admin")
public class Endpoint {

    @GetMapping("/greeting")
    public @ResponseBody String greeting()
    {
        return "test response";
    }

}
