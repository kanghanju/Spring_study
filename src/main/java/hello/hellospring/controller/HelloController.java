package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller //직접 적어줘야 한다.
public class HelloController {

    @GetMapping("hello")  //웹 어플리케이션에서 /hello가 입력이 되면 아래 메서드가 호출
    public String hello(Model model){
        model.addAttribute("data","hanju!"); //key는 data,value는 hanju!
        return "hello"; //find hello.html and rendering
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model){//파라미터 정보 확인:ctrl+P
        model.addAttribute("name",name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody  //html의 body 태그가 아니라 http의 body부에 직접 데이터를 넣어주겠다는 의미
    public String helloString(@RequestParam("name") String name){
        return "hello  "+name; //템플릿엔진과의 차이라면 얘는 view가 없다. 이 문자가 그대로 보인다
    }

    @GetMapping("hello-api")
    @ResponseBody // 아 ! http 응답 body에 그대로 내 데이터를 넘겨야겠다
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello(); //Code Completion: Ctrl+Shift+Enter
        hello.setName(name);
        return hello; //객체를 넘김, Spring에서 객체를 반환하고 ResponseBody라고 해놓으면 기본으로 JSON으로 반환한다
    }

    static class Hello{
        private String name;

        public String getName(){
            return name;
        }

        public void setName(String name){
            this.name = name;
        }
    }
}