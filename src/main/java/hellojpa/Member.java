package hellojpa;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class Member {

    // PK 매핑
    @Id
    private Long id;

    // DB 컬럼명은 name 이다.
    @Column(name = "name")
    private String username;

    private Integer age;

    // 객체에서 enum 타입을 사용하고 싶다? DB에는 존재하지 않지만 Enumerated를 사용하면 된다.
    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    // Date, TIME, TIMESTAMP 타입이 있다.
    // 날짜, 시간이 다 있지만 DB에는 날짜, 시간, (날짜,시간) 3가지를 포함
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    // DB에서 varchar를 넘어선 큰 컨텐츠를 사용하고 싶을 때
    @Lob
    private String description;

    // JPA에서는 기본적으로 내부적 리플렉션이나 사용되기 때문에 동적으로 객체를 생성해야 하므로
    // 기본 생성자가 있어야 한다.

    public Member(){

    }
}
