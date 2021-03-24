package com.example.demo.jpa.entiy;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


//一对多

@Entity
@Table(name = "tbl_b_1")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class B1 {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "ID", unique = true, nullable = false, length = 32)
    private Long id;


    @OneToMany(mappedBy = "b", cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    //级联保存、更新、删除、刷新;延迟加载。当删除B1，会级联删除对应的B2
    //拥有mappedBy注解的实体类为关系被维护端
    //mappedBy="b"中的b是B2中的b属性
    private List<B2> b2List = new ArrayList();
}
