package cn.future.bms.entity;
import cn.future.bms.support.BaseEntity;
import lombok.Data;
import javax.persistence.Column;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author： ygl
 * @date： 2018/03/31-15:10
 * @Description：
*/
@Data
@Table(name="sys_user")
public class SysUser extends BaseEntity{

    /**
     * 用户名
     */
    @Column(name = "username")
    private String username;
    /**
     * 密码
     */
    @Column(name = "password")
    private String password;
    /**
     * 姓名
     */
    @Column(name = "name")
    private String name;
    /**
     * 性别0:男,1:女，默认男
     */
    @Column(name = "sex")
    private Byte sex;
    /**
     * 电话
     */
    @Column(name = "phone")
    private String phone;
    /**
     * 生日
     */
    @Column(name = "birthday")
    private Date birthday;
    /**
     * 邮箱
     */
    @Column(name = "email")
    private String email;
    /**
     * 头像
     */
    @Column(name = "avatar")
    private String avatar;
}