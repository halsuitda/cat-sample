package com.study.cat.catitem.entity;

import com.study.cat.audit.AuditTable;
import com.study.cat.cart.entity.Cart;
import com.study.cat.image.entity.CatItemImage;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "cat_items")
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Getter
@EqualsAndHashCode(callSuper = true)
public class CatItem extends AuditTable {

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String price;

    @Column(nullable = false, columnDefinition = "LONGTEXT")
    private String info;

    @Column(nullable = false)
    private boolean waterMark;

    @Column(nullable = false)
    private String authority;

    @ToString.Exclude
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderBy("id")
    private Set<Cart> carts = new LinkedHashSet<>();

    @ToString.Exclude
    @OneToOne
    @Setter
    private CatItemImage image;

    public void addCart(Cart cart) {
        this.carts.add(cart);
    }

    public void addCatItemImage(CatItemImage catItemImage) {
        this.image = catItemImage;
    }

}
