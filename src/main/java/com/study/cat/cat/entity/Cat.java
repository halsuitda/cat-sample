package com.study.cat.cat.entity;

import com.study.cat.audit.AuditTable;
import com.study.cat.user.entity.User;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "cats")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class Cat extends AuditTable {

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false, unique = true)
    private String species;

    @Column(nullable = false, unique = true)
    private String birth;

    @Column(nullable = false, unique = true)
    private String loveSnack;

    @Column(nullable = false, unique = true, columnDefinition = "LONGTEXT")
    private String info;

    @Column(nullable = false, unique = true, columnDefinition = "LONGTEXT")
    private String etc;

    @ToString.Exclude
    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    private User user;

}
