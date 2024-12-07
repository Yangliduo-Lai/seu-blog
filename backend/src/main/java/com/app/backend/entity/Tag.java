package com.app.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Tag 实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Alias("Tag")  // 为 MyBatis 指定别名
public class Tag {
    @tagId
    private Long tagId;
    private String name;
    private List<Blog> blogs = new ArrayList<>();
    private Date createTime;
}
