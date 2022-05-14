package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();//database 커넥션 하나 받았다 생각하면됨.

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

//            Member member = new Member(); //추가
//            member.setId(2L);
//            member.setName("HelloB");
//            em.persist(member);
//            Member findMember = em.find(Member.class, 1L);
////            System.out.println("findMember.id = " + findMember.getId()); //조회
////            System.out.println("findMember.name = " + findMember.getName());
//            findMember.setName("HelloJPA");
//            /**
//             * 멤버를 모두 조회해라.
//             * setFirstResult
//             * setMaxResults 페이징처리하는거
//             */
//            List<Member> result = em.createQuery("select m from Member as m", Member.class)
//                    .setFirstResult(0)
//                    .setMaxResults(1)
//                    .getResultList();
//
//            for (Member member : result) {
//                System.out.println("member.name = " + member.getName());
//            }

            //비영속
//            Member member = new Member();
//            member.setId(101L);
//            member.setName("HelloJPA");

            //영속
//            System.out.println("=== BEFORE ===");
//            em.persist(member);
//            System.out.println("=== AFTER ===");

//            Member findMember1 = em.find(Member.class, 101L);
//            Member findMember2 = em.find(Member.class, 101L);
//
//            System.out.println("result = " + (findMember1 == findMember2));

//            Member member1 = new Member(150L, "A");
//            Member member2 = new Member(160L, "B");
//
//            em.persist(member1);
//            em.persist(member2);

//            Member member = em.find(Member.class, 150L);
//            member.setName("AAAA");
//
//            em.detach(member);//JPA 영속성을 없앤다. 커밋시에 아무일도 일어 나지 않는다.
//            em.clear(); //em안에있는 모든 것들을 영속성 제거한다.

            Team team = new Team();
            team.setName("TeamA");

            em.persist(team);

            Member member = new Member();
            member.setUsername("member1");
            member.changeTeam(team);
            em.persist(member);

//            team.getMembers().add(member);
            Member m = em.find(Member.class, member.getId());
            System.out.println("m = " + m.getTeam().getClass());

            em.flush();
            em.clear();

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();

    }
}
