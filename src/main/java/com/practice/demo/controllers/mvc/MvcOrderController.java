package com.practice.demo.controllers.mvc;

import com.practice.demo.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("orders")
public class MvcOrderController {

    @Autowired
    private OrderService orderService;
}
