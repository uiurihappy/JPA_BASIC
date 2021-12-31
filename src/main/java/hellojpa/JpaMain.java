package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        //데이터베이스 커넥션을 하나 받는다고 생각
        EntityTransaction tx = em.getTransaction();
        //트랜잭션 시작
        tx.begin();

        try {
            //code

            //find
            Member findMember = em.find(Member.class, 1L);

            //전체 회원 조회
            List<Member> result = em.createQuery("select m from Member as m", Member.class)
                    .setFirstResult(1)  //1번부터
                    .setMaxResults(10)  //10번까지
                    .getResultList();

            for (Member member : result) {
                System.out.println("member.getName() = " + member.getName());
            }

            //remove
            //em.remove(findMember);

            //update
            findMember.setName("HelloJPA");

            System.out.println("findMember.id = " + findMember.getId());
            System.out.println("findMember.name = " + findMember.getName());

            //commit
            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }

        //애플리케이션 사용 후 close를 해줘야 한다.

        emf.close();
    }
}
