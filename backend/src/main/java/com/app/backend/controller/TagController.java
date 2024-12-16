package com.app.backend.controller;

import com.app.backend.Service.TagService;
import com.app.backend.entity.Result;
import com.app.backend.entity.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tag")
public class TagController {

    @Autowired
    private TagService tagService;

    @PostMapping("/add")
    public Result addTag(@RequestBody @Validated(Tag.Add.class)Tag tag) {
        tagService.add(tag);
        return Result.success();
    }

    @GetMapping("/list")
    public Result<List<Tag>> tagList() {
        List<Tag> ts = tagService.list();
        return  Result.success(ts);
    }

    @GetMapping("/detail")
    public Result<Tag> detail(Integer tagId) {
        Tag t = tagService.findById(tagId);
        return Result.success(t);
    }

    @PutMapping("/update")
    public Result updateTag(@RequestBody @Validated(Tag.Update.class) Tag tag) {
        tagService.update(tag);
        return Result.success();
    }
}
