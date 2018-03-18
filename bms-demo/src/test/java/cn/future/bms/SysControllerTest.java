package cn.future.bms;

import cn.future.bms.entity.SysUser;
import cn.future.bms.service.SysUserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

/**
 * @author： ygl
 * @date： 2018/3/17
 * @Description：
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class SysControllerTest {

    @Autowired
    private SysUserService sysUserService;

    @Test
    public void save() throws Exception{
        SysUser user = new SysUser();
        sysUserService.save(user);
    }
}
