package com.zhengjiadi.pointer.model;


import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

/**
 * Created by rajeevkumarsingh on 27/06/17.
 */
@Entity
@Table(name = "image")
@EntityListeners(AuditingEntityListener.class)
public class Image {

    // 主键这么写就完事了，使用数据库默认的增长策略
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // @NotNull和@NotEmpty和@NotBlank区别： 分别不能为 null， 长度必须大于0， 不能全是 space
    // url 保存图片的七牛云路径
    private String url;

    // 图片本地路径
    // todo 在配置中加上 prefix
    private String localPath;

    // 精度和纬度
    private double longitude;

    private double latitude;

    // 获取方向传感器的数据
    // 参考：http://www.voidcn.com/article/p-skhxieyc-pg.html  http://www.voidcn.com/article/p-ehgvfhgo-gm.html
    // values[0]记录手机围绕Z轴的旋转角度。 可以判断方向
    // values[1]记录手机围绕x轴旋转的角度。 可以判断前后倾斜的角度。
    // values[2]记录手机围绕y轴的旋转角度。 可以判断左右倾斜的角度。
    // 空间坐标系以头朝正北，水平放置的手机为参考。
    private double value0;
    private double value1;
    private double value2;



}
