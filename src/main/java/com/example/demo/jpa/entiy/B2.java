package com.example.demo.jpa.entiy;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "tbl_b_2")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class B2 {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "ID", unique = true, nullable = false, length = 32)
    private Long id;

    @ManyToOne(cascade = { CascadeType.MERGE,CascadeType.REFRESH}, optional=false)
    //可选属性optional=false,表示b1不能为空。删除B2，不影响B1
    @JoinColumn(name = "b_1_id")
    //设置在B2表中的关联字段(外键)
    private B1 b;
}
