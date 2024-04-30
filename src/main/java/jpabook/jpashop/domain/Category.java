package jpabook.jpashop.domain;

import jakarta.persistence.*;
import jpabook.jpashop.domain.item.Item;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.FetchType.*;

@Entity
@Getter @Setter
public class Category {

    @Id @GeneratedValue
    @Column(name = "category_id")
    private Long id;

    private String name;

    @ManyToMany // 실무 권장 X
    @JoinTable(name = "category_item",
        joinColumns = @JoinColumn(name = "category_id"), // 중간테이블에 있는 category_id
            inverseJoinColumns = @JoinColumn(name = "item_id") // 아이템쪽으로 들어가는 id
    ) // JoinColumn이 아닌 JoinTable이 필요하다 (중간테이블)
    private List<Item> items = new ArrayList<>();

    // [START] 셀프로 건 양방향 연관관계
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "parent_id")
    private Category parent; // 상위 카테고리. 매니 투 원이겠지?

    @OneToMany(mappedBy = "parent") // 헉 parent가 들어가네
    private List<Category> child = new ArrayList<>(); // 하위 카테고리
    // [END] 셀프로 건 양방향 연관관계

    // ===== 연관관계 편의 메서드 ===== //
    public void addChildCategory(Category child) {
        this.child.add(child);
        this.setParent(this);
    }
}
