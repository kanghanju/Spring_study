package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {

    private final MemberService memberService;

    @Autowired //생성자에 Autowired가 있으면 memberService를 spring이 container에 있는 memberService와 연결시킨다
    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }
}
