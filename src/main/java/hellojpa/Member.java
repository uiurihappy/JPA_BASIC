package hellojpa;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MBR")    // MBR이라는 테이블과 매핑
public class Member {

    @Id
    private Long id;
    private String name;

    // JPA에서는 기본적으로 내부적 리플렉션이나 사용되기 때문에 동적으로 객체를 생성해야 하므로
    // 기본 생성자가 있어야 한다.

    public Member(){

    }

    public Member(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
