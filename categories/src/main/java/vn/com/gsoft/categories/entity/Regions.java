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
@Table(name = Regions.TABLE_NAME)
public class Regions extends BaseEntity {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "REGIONS";
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = Regions.TABLE_NAME + "_SEQ")
    @SequenceGenerator(sequenceName = Regions.TABLE_NAME + "_SEQ", allocationSize = 1, name = Regions.TABLE_NAME + "_SEQ")
    @Id
    @Column(name = "ID")
    private Long id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "CODE")
    private String code;
}
