package cn.ccc212.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "minio")
@Data
@Primary
public class MinioProperties {

    private String endpoint;

    private String accessKey;

    private String secretKey;
    
    private String bucketName;
}