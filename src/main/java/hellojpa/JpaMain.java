package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        // JPA는 EntityManagerFactory가 필요
        // DB가 하나씩 묶여서 돌아간다.
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello"); // persistence.xml의 unit을 불러온다.

        // 고객의 요청이 들어오면 DB작업을 할때마다 EM을 통해 작업
        EntityManager em = emf.createEntityManager();

        // 데이터베이스 커넥션을 하나 받는다고 생각
        // JPA의 모든 DATA 작업은 트랜잭션에서 이뤄진다.
        EntityTransaction tx = em.getTransaction();

        // 트랜잭션 시작
        tx.begin();

        // try-catch문으로 로직 구성하는 것이 정석이다.
        try {

            Member member = new Member();

            member.setId("ID_A");
            member.setUsername("CCCC");

            em.persist(member);

            //commit
            tx.commit();
            //commit을 안하면 작업이 안바뀐다.
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }

        //애플리케이션 사용 후 닫아줘야 한다.
        emf.close();
    }
}
