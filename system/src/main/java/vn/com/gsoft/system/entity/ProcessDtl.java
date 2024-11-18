package vn.com.gsoft.system.entity;

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
@Table(name = ProcessDtl.TABLE_NAME)
public class ProcessDtl {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "PROCESS_DTL";
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = ProcessDtl.TABLE_NAME + "_SEQ")
    @SequenceGenerator(sequenceName = ProcessDtl.TABLE_NAME + "_SEQ", allocationSize = 1, name = ProcessDtl.TABLE_NAME + "_SEQ")
    @Id
    @Column(name = "ID")
    private Long id;
    @Column(name = "PROCESS_ID")
    private Long processId;
    @Column(name = "INDEX_DATA")
    private Integer index;
    @Column(name = "DATA_ROW")
    private String data;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    @Column(name = "STAR_DATE")
    private Date startDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    @Column(name = "END_DATE")
    private Date endDate;
    @Column(name = "STATUS")
    private Integer status; // 0: khởi tạo, 1: running , 2:done
    @Column(name = "RETURN_CODE")
    private Integer returnCode; // 0: Thành công, 1:Chạy thành công có lỗi 1 phần, 2: Chạy không thành công
    @Column(name = "MESSAGE")
    private String message;
}