package hellojpa;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity // JPA가 관리하는 객체
@Table(name="MBR") // 테이블 명을 바꾸고 싶을 때
public class Member {
//    @Id
//    private Long id;
//    @Column(unique = true, length = 10)
//    private String name;
    @Id
    private Long id;
    @Column(name = "name", nullable = false)
    private String username;
    private Integer age;
    @Enumerated(EnumType.STRING)
    private RoleType roleType;
    @Temporal(TemporalType.TIMESTAMP) // 과거 버전
    private Date createdDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    private LocalDate createDate2; // 최신 버전 - 알아서 매핑 해줌
    private LocalDateTime testLocalDateTime;
    @Lob // 큰 콘텐츠를 넣고 싶으면
    private String description;


    public Member() {

    }
}
