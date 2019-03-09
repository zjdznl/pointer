package com.zhengjiadi.pointer.controller;

import com.zhengjiadi.pointer.exception.ResourceNotFoundException;
import com.zhengjiadi.pointer.model.Image;
import com.zhengjiadi.pointer.model.Note;
import com.zhengjiadi.pointer.repository.ImageRepository;
import com.zhengjiadi.pointer.utils.BaseJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("image")
public class ImageController {
    private static String UPLOADED_FOLDER = "/Users/guozhen/Desktop/image";

    @Autowired
    private ImageRepository imageRepository;

    static {
        File directory = new File(UPLOADED_FOLDER);
        if (!directory.exists()) {
            directory.mkdirs();
            // If you require it to make the entire directory path including parents,
            // use directory.mkdirs(); here instead.
        }
    }

    @GetMapping("/info/{id}")
    public BaseJson getImage(@PathVariable(value = "id") Long imageId) {
        Image imageInDB = imageRepository.findById(imageId)
                .orElseThrow(() -> new ResourceNotFoundException("Image", "id", imageId));

        return BaseJson.success().setData(imageInDB);
    }

    // 上传一个图片， 然后保存图片的上传地址到数据库中
    @PostMapping("/upload")
    public BaseJson addImage(@RequestParam("image") MultipartFile file) {

        if (file.isEmpty()) {
            return new BaseJson("-1", "please select a file to upload");
        }

        try {
            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER, file.getOriginalFilename());
            Files.write(path, bytes);

            Image image = new Image();
            image.setLocalPath(path.toString());
            image.setUrl(""); // todo 七牛云
            imageRepository.save(image);

            return BaseJson.success(file.getOriginalFilename() + "上传成功").setData(image);
        } catch (IOException e) {
            e.printStackTrace();
        }


        return BaseJson.unknownError(file.getOriginalFilename() + "上传失败。");
    }


    // 上传一张图片后需要上传相关的附加信息
    @PutMapping("/update/{id}")
    public BaseJson updateImage(@PathVariable(value = "id") Long imageId, @Valid @RequestBody Image image) {
        Image imageInDB = imageRepository.findById(imageId)
                .orElseThrow(() -> new ResourceNotFoundException("Image", "id", imageId));

        imageInDB.setUserId(image.getUserId());
        imageInDB.setLongitude(image.getLongitude());
        imageInDB.setLatitude(image.getLatitude());
        imageInDB.setValue0(image.getValue0());
        imageInDB.setValue1(image.getValue1());
        imageInDB.setValue2(image.getValue2());

        Image updatedImage = imageRepository.save(imageInDB);

        return BaseJson.success().setData(updatedImage);
    }
}
