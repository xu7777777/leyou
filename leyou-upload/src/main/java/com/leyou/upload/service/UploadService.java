package com.leyou.upload.service;

import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * @Author XuQiaoYang
 * @Date 2020/2/14 12:26
 */
@Service
public class UploadService {

    private static final List<String> CONTENT_TYPES = Arrays.asList("image/gif", "image/jpeg", "image/png");

    private static final Logger LOGGER = LoggerFactory.getLogger(UploadService.class);

    @Resource
    private FastFileStorageClient storageClient;
    /**
     * 添加图片
     *
     * @param file
     * @return
     */
    public String uploadImage(MultipartFile file) {

        //校验文件类型
        String originalFilename = file.getOriginalFilename();
//        StringUtils.substringAfterLast(originalFilename, ".");
        String contentType = file.getContentType();
        if (!CONTENT_TYPES.contains(contentType)) {
            LOGGER.info("================文件类型不合法============: {}", originalFilename);
            return null;
        }
        try {
            //校验文件的内容，避免出现脚本文件伪装成图片文件的危险情况。
            BufferedImage bufferedImage = ImageIO.read(file.getInputStream());
            if (bufferedImage == null) {
                LOGGER.info("================文件内容不合法============: {}", originalFilename);
            }

            //保存到服务器
//            file.transferTo(new File("E:\\JavaProgram\\131\\resource\\image\\" + originalFilename));
            String ext = StringUtils.substringAfterLast(originalFilename, ".");
            StorePath storePath = this.storageClient.uploadFile(file.getInputStream(), file.getSize(), ext, null);

            //对url进行回显
            return "http://image.leyou.com/" + storePath.getFullPath();
        } catch (IOException e) {
            LOGGER.info("===============服务器内部错误===========: {}", originalFilename);
            e.printStackTrace();
        }
        return null;
    }

}
