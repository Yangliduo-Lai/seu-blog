package com.app.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

import java.util.ArrayList;
import java.util.List;

/**
 * Type 实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Alias("Type")  // 为 MyBatis 指定别名
public class Type {
    @typeId
    private Long typeId;
    private List<Blog> blogs = new ArrayList<Blog>();

    private String name;
}
