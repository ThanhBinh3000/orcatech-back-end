package vn.com.gsoft.categories.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = Wards.TABLE_NAME)
public class Wards extends BaseEntity {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "WARDS";
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = Wards.TABLE_NAME + "_SEQ")
    @SequenceGenerator(sequenceName = Wards.TABLE_NAME + "_SEQ", allocationSize = 1, name = Wards.TABLE_NAME + "_SEQ")
    @Id
    @Column(name = "ID")
    private Long id;
    @Column(name = "CITIES_ID")
    private Long citiesId;
    @Column(name = "NAME")
    private String name;
    @Column(name = "CODE")
    private String code;
}
