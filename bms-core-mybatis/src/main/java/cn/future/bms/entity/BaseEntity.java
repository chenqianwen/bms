package cn.future.bms.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author： ygl
 * @date： 2018/3/20
 * @Description：
 */
@Data
public class BaseEntity implements Serializable {

        private String id;

        private Date createdDate;

        private String createdBy;

        private Date updatedDate;

        private String updatedBy;

        private Integer isDeleted = 0;
}
