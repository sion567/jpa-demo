package com.example.demo.jpa.entiy;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.math.BigDecimal;

//标准使用

@Entity
@Table(name = "tbl_a")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class A {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "ID", unique = true, nullable = false, length = 32)
    private Long id;
    private String name;
    @Column(name = "delete_state")
    private int deleteState = 0;
    @Column(name = "email", nullable = true, length = 128)
    private String email;
    @Column(name = "remark", columnDefinition = "text")
    private String remark;

    @Column(name = "salary1", columnDefinition = "decimal(5,2)")
    private double salary1;
    @Column(name = "salary2", precision = 5, scale = 2)
    private double salary2;
    @Column(name = "salary3", columnDefinition = "decimal(5,2)")
    private BigDecimal salary3;
    @Column(name = "salary4", precision = 5, scale = 2)
    private BigDecimal salary4;
//    oracle 版本
//    @Column(name = "salary", columnDefinition = "decimal(5,2)")  //或columnDefinition = "number(5,2)"
//    private Float salary;

    @Version
    protected Long version;
    @Transient
    public boolean isNew() {
        return null == getId();
    }
}
