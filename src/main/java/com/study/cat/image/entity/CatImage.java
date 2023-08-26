package com.study.cat.image.entity;

import com.study.cat.audit.AuditTable;
import com.study.cat.cat.entity.Cat;
import com.study.cat.user.entity.User;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Entity
@Table(name = "cat_image")
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Getter
@EqualsAndHashCode(callSuper = true)
public class CatImage extends AuditTable {

    @Column(length = 200, nullable = false)
    private String url;

    @Column(length = 50, nullable = false)
    private String name;

    @Column(nullable = false)
    private Long size;

    @ToString.Exclude
    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    private Cat cat;

    public void addCat(Cat cat) {
        this.cat = cat;
    }

}
