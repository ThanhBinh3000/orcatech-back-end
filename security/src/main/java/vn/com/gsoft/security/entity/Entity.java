package vn.com.gsoft.security.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Data
@jakarta.persistence.Entity
@Table(name = Entity.TABLE_NAME)
@EntityListeners(AuditingEntityListener.class)

public class Entity extends BaseEntity {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "ENTITY";
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = Entity.TABLE_NAME + "_SEQ")
    @SequenceGenerator(sequenceName = Entity.TABLE_NAME + "_SEQ", allocationSize = 1, name = Entity.TABLE_NAME + "_SEQ")
    @Id
    @Column(name = "ID")
    private Long id;
    @Column(name = "CODE")
    private String code;
    @Column(name = "NAME")
    private String name;
    @Column(name = "TYPE")
    private Integer type;
}