package cn.future.bms;

import cn.future.bms.fdfs.FastDFSClientWrapper;
import com.github.tobato.fastdfs.domain.FileInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author： ygl
 * @date： 2018/3/25
 * @Description：
 */
@RestController
@RequestMapping("/file")
public class FileController {

    @Autowired
    private FastDFSClientWrapper dfsClient;
    
    @PostMapping
    public String upload2(MultipartFile file) throws IOException {

        String s = dfsClient.uploadFile(file);
        return s;
    }
    @GetMapping
    public FileInfo queryFileInfo(String fileUrl) throws IOException {
        FileInfo fileInfo = dfsClient.queryFileInfo(fileUrl);
        return fileInfo;
    }
    @DeleteMapping
    public String delete(String fileUrl) throws IOException {
        dfsClient.deleteFile(fileUrl);
        return "删除成功";
    }
}
