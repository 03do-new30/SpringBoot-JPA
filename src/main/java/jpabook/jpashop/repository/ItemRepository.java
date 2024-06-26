package jpabook.jpashop.repository;

import jakarta.persistence.EntityManager;
import jpabook.jpashop.domain.item.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ItemRepository {

    private final EntityManager em;

    public void save(Item item) {
        if (item.getId() == null) { // JPA에 저장하기 전까지는 id가 없음
            em.persist(item); // 신규 등록
        } else {    // [준영속 엔티티를 수정하는 방법] 2. 병합 사용: 준영속 상태의 엔티티를 영속 상태로 변경
            // item이 영속성 컨텍스트에서 관리되는 게 아니라
            // 찾아온 merge가 영속성 아이템에서 관리되게 된다
            Item merge = em.merge(item);// update와 '비슷'
        }
    }

    public Item findOne(Long id) {
        return em.find(Item.class, id);
    }

    public List<Item> findAll() {
        return em.createQuery("select i from Item i", Item.class)
                .getResultList();
    }

}
