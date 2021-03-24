package com.example.demo.jpa.entiy;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

//一对一关系：通过关联表的方式来保存一对一的关系

@Entity
@Table(name = "tbl_f_1")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class F1 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToOne(cascade=CascadeType.ALL)//People是关系的维护端
    @JoinTable(name = "T__f",
            joinColumns = @JoinColumn(name="f_1_id"),
            inverseJoinColumns = @JoinColumn(name = "f_2_id"))//通过关联表保存一对一的关系
    private F2 f2;
}
