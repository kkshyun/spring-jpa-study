package hellojpa;

import jakarta.persistence.*;

import java.util.List;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {
//            // 비영속
//            Member member = new Member();
//            member.setId(101L);
//            member.setName("HelloJPA");
//
//            // 영속 -> db에 저장은 안 됨 // 커밋하는 시점에 db에 날라감
//            System.out.println("=========BEFORE=========");
//            em.persist(member);
//            System.out.println("=========AFTER=========");
//
//            Member findMember = em.find(Member.class, 101L);
//            System.out.println("findMember.id = " + findMember.getId()); // db에서 조회 안 함
//            System.out.println("findMember.getName = " + findMember.getName());

            // 영속
//            Member findMember1 = em.find(Member.class, 101L);
//            Member findMember2 = em.find(Member.class, 101L);
//
//            System.out.println("result = " + (findMember1 == findMember2));

//            Member member1 = new Member(150L, "A");
//            Member member2 = new Member(160L, "B");
//
//            em.persist(member1);
//            em.persist(member2);
//
//            System.out.println("==================="); // 선 이후에 쿼리를 db에 날림, 모았다가 db에 한번에 보냄

//            Member member = em.find(Member.class, 150L);
//            member.setName("ZZZZZ"); // update 안 하고 set 만 해도 update 나감
//
////            em.persist(member); // 값만 바꿔도 update 쿼리가 나감
//            Member member = new Member(200L, "member200");
//            em.persist(member);
//
//            em.flush(); // 미리 쿼리를 날리고 싶을 때, 1차 캐시는 그대로 유지됨

            Member member = em.find(Member.class, 150L);
            member.setName("AAAAA");

            System.out.println("=================");
            tx.commit();
//            Member findMember = em.find(Member.class, 1L);
//            findMember.setName("HelloJPA");
            // JPQL
//            List<Member> result = em.createQuery("select m from Member as m", Member.class)
//                    .setFirstResult(5)
//                    .setMaxResults(8)
//                    .getResultList();
//            for(Member member : result) {
//                System.out.println("member.name = " + member.getName());
//            }
//            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
