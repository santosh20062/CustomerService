package com.customer.CustomerService.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private RestTemplate restTemplate;
    @GetMapping("/hello")
    public String getHello(){

        return "Hello Customer ....";
    }

    @GetMapping("/getProduct/{productId}")
    public String getProductDetails(@PathVariable("productId") String productId){
       // String result = "test1";


      //  Department department =
        //        restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/" + user.getDepartmentId()
          //              ,Department.class);

        String result = restTemplate.getForObject("http://localhost:9002/product/getProduct/" + productId
                              ,String.class);

        //restTemplate.exchange("http://localhost:9002/product/hello","GET",)
        return result;
    }


    /*@Bean RestTemplate getTemplate(){
        return  new RestTemplate();
    }*/
}
