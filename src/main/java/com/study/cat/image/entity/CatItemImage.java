package com.study.cat.image.entity;

import com.study.cat.audit.AuditTable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "cat_item_images")
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Getter
@EqualsAndHashCode(callSuper = true)
public class CatItemImage extends AuditTable {

    @Column(length = 200, nullable = false)
    private String url;

    @Column(length = 50, nullable = false)
    private String name;

    @Column(nullable = false)
    private Long size;
}
