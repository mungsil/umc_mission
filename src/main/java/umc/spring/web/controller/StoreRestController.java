package umc.spring.web.controller;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/stores")
public class StoreRestController {
    @PostMapping("/region") // "stores?region="인천"
    public void addStore() {

    }
}
