package hello.upload.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequiredArgsConstructor
@Slf4j
public class ItemController {

    @GetMapping("/items/new")
    public String newItem() {
        return "item-form";
    }

    @PostMapping("/items/new")
     public String saveItem(@ModelAttribute ItemForm itemForm) {
        MultipartFile attachFile = itemForm.getAttachFile();
        itemForm.getImageFiles();
    }


}
