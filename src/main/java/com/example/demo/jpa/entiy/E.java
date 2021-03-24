@Entity  
@Table(name = "tbl_e")
@Getter
@Setter
public class E {
  
    @Id  
    @GeneratedValue(strategy = GenerationType.IDENTITY)  
    private Integer id;  
  
    @ManyToOne  
    @JoinColumn(name = "e_id")
    private E parent; // 父类别
  
    @OneToMany(mappedBy = "parent", targetEntity = E.class, cascade = CascadeType.ALL)  
    private Set<E> childs = new HashSet<>(); // 子类别
  
    //getter and setter  

    /** 添加子类别 */
    public void addChild(E e) {
        if (e == null) {
            throw new IllegalArgumentException("Can't add a null Obj as child.");  
        }  
        // 删除旧的父类别
        if (e.getParent() != null) {
            e.getParent().getchilds().remove(e);
        }  
        // 设置新的父类别
        e.setParent(this);
        // 向当前对象中加入子类别
        this.getchilds().add(e);
    }
}