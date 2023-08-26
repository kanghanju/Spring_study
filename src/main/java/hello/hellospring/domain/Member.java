package hello.hellospring.domain;

import javax.persistence.*;

@Entity //jpa가 관리하는 entity
public class Member {

    @Id //pk mapping
    @GeneratedValue(strategy = GenerationType.IDENTITY) //전략 IDENTITY:DB가 id값을 자동으로 생성해 주는 것
    private Long id; //고객이 정하는 id가 아닌 System이 저장하는 id

    @Column(name ="username")//DB에 column name을 username으로 바꾼다
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }
}
