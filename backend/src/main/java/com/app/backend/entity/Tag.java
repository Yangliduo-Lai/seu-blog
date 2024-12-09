package com.app.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

import javax.persistence.Id;
import java.time.LocalDateTime;

/**
 * Tag 实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Alias("Tag")  // 为 MyBatis 指定别名
public class Tag {
    @Id
    private Integer tagId;
    private String tagName;
    private LocalDateTime createTime;
    private Integer blogId;
    private Integer userId;
}
