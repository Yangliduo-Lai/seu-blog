package com.app.backend.Service.impl;

import com.app.backend.Service.TagService;
import com.app.backend.entity.Tag;
import com.app.backend.mapper.TagMapper;
import com.app.backend.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagMapper tagMapper;

    @Override
    public void add(Tag tag) {
        // 补充属性值
        tag.setUpdatedTime(LocalDateTime.now());
        tag.setCreatedTime(LocalDateTime.now());
        Map<String,Object> map = ThreadLocalUtil.get();
        Integer userId = (Integer) map.get("id");
        tag.setUserId(userId);

        tagMapper.add(tag);
    }

    @Override
    public List<Tag> list() {
        Map<String,Object> map = ThreadLocalUtil.get();
        Integer userId = (Integer) map.get("id");
        return tagMapper.list(userId);
    }
}
