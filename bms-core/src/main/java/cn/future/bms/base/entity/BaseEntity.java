package cn.future.bms.base.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author： ygl
 * @date： 2018/3/16
 * @Description：
 */
@Data
@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
public class BaseEntity implements Serializable {

    @Id
    @GeneratedValue(generator = "myIdGenerator")
    @GenericGenerator(name = "myIdGenerator", strategy = "cn.future.bms.id.MyIdGenerator")
    @Column(name = "id", length = 64)
    private String id;

    @CreatedDate
    @Column(name = "created_date", nullable = false, columnDefinition = "datetime comment'创建时间'")
    private Date createdDate;

    @CreatedBy
    @Column(name = "created_by", nullable = false, columnDefinition = "varchar(8) comment'创建者'")
    private String createdBy;

    @LastModifiedDate
    @Column(name = "updated_date", nullable = false, columnDefinition = "datetime comment'更新时间'")
    private Date updatedDate;

    @LastModifiedBy
    @Column(name = "updated_by", nullable = false, columnDefinition = "varchar(8) comment'更新者'")
    private String updatedBy;

    @Column(name = "is_deleted", nullable = false, columnDefinition = "tinyint default 0 comment'删除标志'")
    private Integer isDeleted = 0;
}
