package vn.com.gsoft.categories.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {
    @CreatedDate
    @Column(name = "Created")
    private Date created;

    @CreatedBy
    @Column(name = "Created_By_User_Id")
    private Long createdByUserId;

    @LastModifiedDate
    @Column(name = "Modified")
    private Date modified;

    @LastModifiedBy
    @Column(name = "Modified_By_User_Id")
    private Long modifiedByUserId;

    @Column(name = "Record_Status_Id")
    private Long recordStatusId;
}