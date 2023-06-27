package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller //직접 적어줘야 한다.
public class HelloController {

    @GetMapping("hello")  //웹 어플리케이션에서 /hello가 입력이 되면 아래 메서드가 호출
    public String hello(Model model){
        model.addAttribute("data","hanju!"); //key는 data,value는 hanju!
        return "hello"; //find hello.html and rendering
    }
}