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
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = Provinces.TABLE_NAME)
public class Provinces extends BaseEntity {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "PROVINCES";
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = Provinces.TABLE_NAME + "_SEQ")
    @SequenceGenerator(sequenceName = Provinces.TABLE_NAME + "_SEQ", allocationSize = 1, name = Provinces.TABLE_NAME + "_SEQ")
    @Id
    @Column(name = "ID")
    private Long id;
    @Column(name = "REGION_ID")
    private Long regionId;
    @Column(name = "NAME")
    private String name;
    @Column(name = "CODE")
    private String code;
}
