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

//            Member member = em.find(Member.class, 150L);
//            member.setName("AAAAAA");

            // em.detach(member);   //준영속 상태
//            em.clear(); //em 안에 영속성 컨텍스트와 1차 캐시를 통째로 다 지운다.
//            Member member2 = em.find(Member.class, 150L);   // 다시 조회
//            System.out.println("===================");

//            Member member = new Member(200L, "member200");
//            em.persist(member);
//
//            // 미리 db를 보고 싶거나 쿼리를 보고 싶으면
//            em.flush(); // 강제 호출

//            Member member = em.find(Member.class, 150L);
//            member.setName("MemberZ");

//             컬렉션 다루듯이 객체를 조작한다. 즉, 다시 저장해서 할 필요가 없다.
//             em.persist(member);


//            Member member1 = new Member(150L, "MemberA");
//            Member member2 = new Member(160L, "MemberB");
//
//            em.persist(member1);
//            em.persist(member2);
//            System.out.println("--------------------------");

//            Member findMember1 = em.find(Member.class, 101L);
//            Member findMember2 = em.find(Member.class, 101L);


            //code
//            // 비영속
//            Member member = new Member();
//            member.setId(101L);
//            member.setName("HelloJPA");
//
//            // 영속
//            // em 안에 있는 영속성 컨텍스트안에 관리가 된다.
//            System.out.println(" ---- Before ----");
//            em.persist(member);
//            System.out.println(" ---- After ----");
//
//            //select 쿼리가 안 나감
//            Member findMember = em.find(Member.class, 101L);
//
//            System.out.println("findMember.getId() = " + findMember.getId());
//            System.out.println("findMember.getName() = " + findMember.getName());
            //find
//            Member findMember = em.find(Member.class, 1L);

            //전체 회원 조회
//            List<Member> result = em.createQuery("select m from Member as m", Member.class)
//                    .setFirstResult(5)  //1번부터
//                    .setMaxResults(8)  //10번까지
//                    .getResultList();

//            for (Member member : result) {
//                System.out.println("member.getName() = " + member.getName());
//            }

            //remove
            //em.remove(findMember);

            //update
//            findMember.setName("HelloJPA");
//
//            System.out.println("findMember.id = " + findMember.getId());
//            System.out.println("findMember.name = " + findMember.getName());

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
