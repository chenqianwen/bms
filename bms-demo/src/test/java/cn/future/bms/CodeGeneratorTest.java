package cn.future.bms;

import cn.future.bms.generator.CodeGenerator;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.sql.ResultSet;

/**
 * @author： ygl
 * @date： 2018/3/30
 * @Description：
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class CodeGeneratorTest {

    @Autowired
    private SqlSessionFactory sqlSessionFactory;


    @Test
    public void generate() throws Exception{
    }
}
