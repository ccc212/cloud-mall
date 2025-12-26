package cn.ccc212.controller;

import cn.ccc212.mall.util.RespResult;
import cn.ccc212.service.FileUpLoadService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/file")
@RequiredArgsConstructor
public class FileUploadController {

    private final FileUpLoadService fileService;

    @PostMapping("/upload")
    public RespResult<?> upload(MultipartFile file) {
        return RespResult.ok(fileService.upload(file));
    }


    /** 配置文件中获取minio各项值 */
//    @Value("${minio.url}")
//    private String url;
//    @Value("${minio.accessKey}")
//    private String accessKey;
//    @Value("${minio.secretKey}")
//    private String secretKey;

    /**
     * minio文件上传
     * @param file
     * @return
     * @throws Exception
     */
//    @RequestMapping("/uploadFile")
//    public RespResult upload(@RequestParam("file") MultipartFile file) throws Exception {
//        //初始化
//        MinioClient minioClient = new MinioClient(url, accessKey, secretKey);
//        //得到文件流
//        InputStream is= file.getInputStream();
//        //使用uuid生成新的唯一文件名
//        String fileName = UUID.randomUUID().toString().replace("-","")+file.getOriginalFilename();
//        //获取文件类型
//        String contentType = file.getContentType();
//        //把文件放置Minio桶
//        minioClient.putObject("minio-test",fileName,is,contentType);
//        //获取访问路径
//        String url = minioClient.presignedGetObject("minio-test", fileName);
//        if(url != null){
//            //返回路径不为空，即上传文件成功
//         //   return new RespResult(RespResult.SUCCESS,"文件上传成功",url.split("\\?")[0]);
//            return RespResult.ok("上传文件成功");
//        }else{
//            //上传失败
//          //  return new ResultBean(RespResult.FAIL,"文件上传失败",null);
//            return RespResult.error("上传文件失败");
//        }
//    }
//    @RequestMapping("/download/{filename}")
//    public RespResult getPreviewFileUrl(@PathVariable String fileName) throws InvalidPortException, InvalidEndpointException, InvalidBucketNameException, InsufficientDataException, XmlPullParserException, ErrorResponseException, NoSuchAlgorithmException, IOException, NoResponseException, InvalidExpiresRangeException, InvalidKeyException, InternalException {
//        MinioClient minioClient = new MinioClient(url, accessKey, secretKey);
//        String s = minioClient.presignedGetObject("minio-test", fileName);
//        return RespResult.ok(s);
//     }
}