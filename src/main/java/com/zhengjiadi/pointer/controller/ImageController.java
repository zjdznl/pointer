package com.zhengjiadi.pointer.controller;

import com.zhengjiadi.pointer.utils.BaseJson;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("image")
public class ImageController {

    @PostMapping("/add")
    public BaseJson addImage() {
        return new BaseJson(0, "ok");
    }
}
