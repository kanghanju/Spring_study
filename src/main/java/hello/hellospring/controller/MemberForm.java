package hello.hellospring.controller;

public class MemberForm {
    private String name; //createMemberForm.html의 name과 매칭이 된다

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }
}
