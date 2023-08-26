package com.study.cat.cat.entity;

import com.study.cat.audit.AuditTable;
import com.study.cat.category.entity.DetailCategory;
import com.study.cat.category.entity.MainCategory;
import com.study.cat.catitem.entity.CatItem;
import com.study.cat.image.entity.CatImage;
import com.study.cat.image.entity.CatItemImage;
import com.study.cat.user.entity.User;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "cats")
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Getter
@EqualsAndHashCode(callSuper = true)
public class Cat extends AuditTable {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String species;

    @Column(nullable = false)
    private String birth;

    @Column(nullable = false)
    private String loveSnack;

    @Column(nullable = false, columnDefinition = "LONGTEXT")
    private String info;

    @Column(nullable = false, columnDefinition = "LONGTEXT")
    private String etc;

    @ToString.Exclude
    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    private User user;

    @ToString.Exclude
    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    private DetailCategory detailCategory;

    @ToString.Exclude
    @OneToMany(mappedBy = "cat", cascade = CascadeType.ALL, orphanRemoval = true)
    @Setter
    private Set<CatImage> images;

    public void addUser(User user) {
        this.user = user;
        user.addCat(this);
    }

    public void addCatImage(CatImage catImage) {
        this.images.add(catImage);
        catImage.addCat(this);
    }

    public void addDetailCategory(DetailCategory detailCategory) {
        this.detailCategory = detailCategory;
        detailCategory.addCat(this);
    }

}
