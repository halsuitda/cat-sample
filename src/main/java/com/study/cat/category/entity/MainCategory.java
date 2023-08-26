package com.study.cat.category.entity;

import com.study.cat.audit.AuditTable;
import com.study.cat.image.entity.CatImage;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "main_category")
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Getter
@EqualsAndHashCode(callSuper = true)
public class MainCategory extends AuditTable {

    @Column(length = 50, nullable = false)
    private String mainCategoryName;

    @ToString.Exclude
    @OneToMany(mappedBy = "mainCategory", cascade = CascadeType.ALL, orphanRemoval = true)
    @Setter
    private Set<DetailCategory> detailCategories;

    public void addDetailCategory(DetailCategory detailCategory) {
        this.detailCategories.add(detailCategory);
    }
}
