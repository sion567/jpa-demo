package com.example.demo.jpa.entiy;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

//多对多

@Entity
@Table(name = "tbl_c_1")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class C1 {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "ID", unique = true, nullable = false, length = 32)
    private Long id;

    @ManyToMany(cascade = { CascadeType.MERGE })
    @JoinTable(name = "T__C", joinColumns = { @JoinColumn(name = "c_1_id") }, inverseJoinColumns = {
            @JoinColumn(name = "c_2_id") })
    @Fetch(FetchMode.SUBSELECT)
    @OrderBy("id ASC")
    //1、关系维护端，负责多对多关系的绑定和解除
    //2、@JoinTable注解的name属性指定关联表的名字，joinColumns指定外键的名字，关联到关系维护端(C1)
    //3、inverseJoinColumns指定外键的名字，要关联的关系被维护端(C2)
    //4、其实可以不使用@JoinTable注解，默认生成的关联表名称为主表表名+下划线+从表表名，即T__C
    //关联到主表的外键名：主表名+下划线+主表中的主键列名,即c_1_id
    //关联到从表的外键名：主表中用于关联的属性名+下划线+从表的主键列名,即c_2_id
    //主表就是关系维护端对应的表，从表就是关系被维护端对应的表
    private List<C2> c2List = new ArrayList();
}
