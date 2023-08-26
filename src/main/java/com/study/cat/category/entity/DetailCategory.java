package com.study.cat.category.entity;

import com.study.cat.audit.AuditTable;
import com.study.cat.cat.entity.Cat;
import com.study.cat.image.entity.CatImage;
import com.study.cat.user.entity.User;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "detail_category")
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Getter
@EqualsAndHashCode(callSuper = true)
public class DetailCategory extends AuditTable {

    @Column(length = 50, nullable = false)
    private String detailCategoryName;

    @ToString.Exclude
    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    private MainCategory mainCategory;

    @ToString.Exclude
    @OneToMany(mappedBy = "detailCategory", cascade = CascadeType.ALL, orphanRemoval = true)
    @Setter
    private Set<Cat> cats;

    public void addCat(Cat cat) {
        this.cats.add(cat);
    }

    public void addMainCategory(MainCategory mainCategory) {
        this.mainCategory = mainCategory;
        mainCategory.addDetailCategory(this);
    }

}
