package cn.ccc212;

import io.minio.*;
import io.minio.errors.MinioException;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class App {
    public static void main(String[] args) throws IOException, NoSuchAlgorithmException, InvalidKeyException {

        try {
            //构造MinIO Client
            MinioClient minioClient = MinioClient.builder()
                    .endpoint("http://ccc212:9000")
                    .credentials("ccc212", "rgayysnmydsLS999")
                    .build();

            //创建hello-minio桶
            boolean found = minioClient.bucketExists(BucketExistsArgs.builder().bucket("hello-minio").build());
            if (!found) {
                //创建hello-minio桶
                minioClient.makeBucket(MakeBucketArgs.builder().bucket("hello-minio").build());
                //设置hello-minio桶的访问权限
                String policy = """
                        {
                          "Statement" : [ {
                            "Action" : "s3:GetObject",
                            "Effect" : "Allow",
                            "Principal" : "*",
                            "Resource" : "arn:aws:s3:::hello-minio/*"
                          } ],
                          "Version" : "2012-10-17"
                        }""";
                minioClient.setBucketPolicy(SetBucketPolicyArgs.builder().bucket("hello-minio").config(policy).build());
            } else {
                System.out.println("Bucket 'hello-minio' already exists.");
            }
            //上传图片
            minioClient.uploadObject(
                    UploadObjectArgs.builder()
                            .bucket("hello-minio")
                            .object("公寓-外观.jpg")
                            .filename("C:\\Users\\Administrator\\Desktop\\avatar.jpg")
                            .build());
            System.out.println("上传成功");
        } catch (MinioException e) {
            System.out.println("Error occurred: " + e);
        }
    }
}