package vn.com.gsoft.categories.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = Process.TABLE_NAME)
public class Process {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "PROCESS";
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = Process.TABLE_NAME + "_SEQ")
    @SequenceGenerator(sequenceName = Process.TABLE_NAME + "_SEQ", allocationSize = 1, name = Process.TABLE_NAME + "_SEQ")
    @Id
    @Column(name = "ID")
    private Long id;
    @Column(name = "BATCHKEY")
    private String batchKey;
    @Column(name = "COMPANY_ID")
    private String companyId;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    @Column(name = "STAR_DATE")
    private Date startDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    @Column(name = "END_DATE")
    private Date endDate;
    @Column(name = "TOTAL")
    private Integer total;
    @Column(name = "STATUS")
    private Integer status; // 0: khởi tạo, 1: running , 2:done
    @Column(name = "RETURN_CODE")
    private Integer returnCode; // 0: Thành công, 1:Chạy thành công có lỗi 1 phần, 2: Chạy không thành công
    @Column(name = "MESSAGE")
    private String message;
    @Column(name = "CREATE_BY")
    private Long createBy;
}