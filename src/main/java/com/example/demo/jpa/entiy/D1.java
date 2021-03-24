package com.example.demo.jpa.entiy;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

//一对一关系：一种是通过外键的方式(一个实体通过外键关联到另一个实体的主键)

@Entity
@Table(name = "tbl_d_1")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class D1 {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "ID", unique = true, nullable = false, length = 32)
    private Long id;

    @OneToOne(cascade= CascadeType.ALL)//D1是关系的维护端，当删除 d1，会级联删除 d2
    @JoinColumn(name = "d_2_id", referencedColumnName = "code")
    private D2 d2;
}

//关联的实体的主键一般是用来做外键的。但如果此时不想主键作为外键，则需要设置referencedColumnName属性。