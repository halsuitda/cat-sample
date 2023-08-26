package com.study.cat.cart.entity;

import com.study.cat.audit.AuditTable;
import com.study.cat.catitem.entity.CatItem;
import com.study.cat.user.entity.User;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Entity
@Table(name = "carts")
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Getter
@EqualsAndHashCode(callSuper = true)
public class Cart extends AuditTable {

    @ToString.Exclude
    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    private User user;

    @ToString.Exclude
    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    private CatItem catItem;

    public void addUser(User user) {
        this.user = user;
        user.addCart(this);
    }

    public void addCatItem(CatItem catItem) {
        this.catItem = catItem;
        catItem.addCart(this);
    }

}
