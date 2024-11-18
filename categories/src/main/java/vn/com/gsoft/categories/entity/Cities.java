package vn.com.gsoft.categories.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = Cities.TABLE_NAME)
public class Cities extends BaseEntity {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "CITIES";
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = Cities.TABLE_NAME + "_SEQ")
    @SequenceGenerator(sequenceName = Cities.TABLE_NAME + "_SEQ", allocationSize = 1, name = Cities.TABLE_NAME + "_SEQ")
    @Id
    @Column(name = "ID")
    private Long id;
    @Column(name = "PROVINCE_ID")
    private Long provinceId;
    @Column(name = "NAME")
    private String name;
    @Column(name = "CODE")
    private String code;
}
