package cn.ccc212.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileUpLoadService {


    String upload(MultipartFile file);
}