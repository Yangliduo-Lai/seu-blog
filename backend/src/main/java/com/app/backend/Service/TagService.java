package com.app.backend.Service;

import com.app.backend.entity.Tag;

import java.util.List;

public interface TagService {
    // 新增标签
    public void add(Tag tag);

    // 列表查询
    List<Tag> list();

    // 根据id查询tag信息
    Tag findById(Integer tagId);

    // 更新tag信息
    void update(Tag tag);
}
