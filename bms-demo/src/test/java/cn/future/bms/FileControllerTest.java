package cn.future.bms;

import com.github.tobato.fastdfs.domain.FileInfo;
import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.proto.storage.DownloadByteArray;
import com.github.tobato.fastdfs.service.AppendFileStorageClient;
import com.github.tobato.fastdfs.service.TrackerClient;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.WebApplicationContext;

import java.io.IOException;

/**
 * @author： ygl
 * @date： 2018/3/25
 * @Description：
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class FileControllerTest {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void setUp(){
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }


    @Test
    public void uploadSuccess() throws Exception{
        String result = mockMvc.perform(MockMvcRequestBuilders.multipart("/file")
                  // 参数名 ， 文件名
                  .file(new MockMultipartFile("file", "test.txt", "multipart/form-data",
                            "hello xxxAdada".getBytes("UTF-8")))
                  .contentType(MediaType.APPLICATION_JSON_UTF8))
                  .andExpect(MockMvcResultMatchers.status().isOk())
                  .andReturn().getResponse().getContentAsString();
        log.info("返回结果-----------------     "+result);
    }
    @Test
    public void upload2Success() throws Exception{
        String result = mockMvc.perform(MockMvcRequestBuilders.multipart("/file/2")
                  // 参数名 ， 文件名
                  .file(new MockMultipartFile("file", "test.txt", "multipart/form-data",
                            "hello xxxAdadaxaa".getBytes("UTF-8")))
                  .contentType(MediaType.APPLICATION_JSON_UTF8))
                  .andExpect(MockMvcResultMatchers.status().isOk())
                  .andReturn().getResponse().getContentAsString();
        log.info("返回结果-----------------     "+result);
    }

    @Test
    public void getSuccess() throws Exception{
        String fileUrl = "http://192.168.200.128:8888/group1/M00/00/00/wKjIgFq3eDuAe2GCAAAADD5iifE748.txt";
        MultiValueMap<String,String> map = new LinkedMultiValueMap<>();
        map.add("fileUrl",fileUrl);
        String result = mockMvc.perform(MockMvcRequestBuilders.get("/file").params(map)
                  .contentType(MediaType.APPLICATION_JSON_UTF8))
                  .andDo(MockMvcResultHandlers.print())
                  .andExpect(MockMvcResultMatchers.status().isOk())
                  .andReturn().getResponse().getContentAsString();
        log.info("返回结果-----------------     "+result);
    }

    @Test
    public void deleteSuccess() throws Exception{
        String fileUrl = "http://192.168.200.128:8888/group1/M00/00/00/wKjIgFq3eDuAe2GCAAAADD5iifE748.txt";
        MultiValueMap<String,String> map = new LinkedMultiValueMap<>();
        map.add("fileUrl",fileUrl);
        String result = mockMvc.perform(MockMvcRequestBuilders.delete("/file").params(map)
                  .contentType(MediaType.APPLICATION_JSON_UTF8))
                  .andDo(MockMvcResultHandlers.print())
                  .andExpect(MockMvcResultMatchers.status().isOk())
                  .andReturn().getResponse().getContentAsString();
        log.info("返回结果-----------------     "+result);
    }


    @Autowired
    private TrackerClient trackerClient;

    @Autowired
    protected AppendFileStorageClient storageClient;

    /**
     * 基本文件上传操作测试
     *
     * @throws IOException
     */
    @Test
    public void testGenerateStorageClient() throws IOException {
        log.debug("##上传文件..##");
        RandomTextFile file = new RandomTextFile();
        StorePath path = storageClient.uploadFile(TestConstants.DEFAULT_GROUP, file.getInputStream(),
                  file.getFileSize(), file.getFileExtName());
        log.debug("上传文件 result={}", path);

        log.debug("##查询文件信息..##");
        FileInfo fileInfo = storageClient.queryFileInfo(path.getGroup(), path.getPath());
        log.debug("查询文件信息 result={}", fileInfo);

        log.debug("##下载文件..##");
        DownloadByteArray callback = new DownloadByteArray();
        byte[] content = storageClient.downloadFile(path.getGroup(), path.getPath(), callback);

        log.debug("##上传从文件..##");
        RandomTextFile slaveFile = new RandomTextFile();
        // TODO 120*120会报错误，看是否可以从客户端截获此错误
        StorePath slavePath = storageClient.uploadSlaveFile(path.getGroup(), path.getPath(), slaveFile.getInputStream(),
                  slaveFile.getFileSize(), "120_120", slaveFile.getFileExtName());
        log.debug("上传从文件 result={}", slavePath);

        log.debug("##删除主文件..##");
        storageClient.deleteFile(path.getGroup(), path.getPath());
        log.debug("##删除从文件..##");
        storageClient.deleteFile(slavePath.getGroup(), slavePath.getPath());
    }

}
