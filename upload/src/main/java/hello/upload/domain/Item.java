package hello.upload.domain;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
public class Item {

    private Long itemId;
    private String itemName;
    private UploadFile attachFile;
    private List<UploadFile> imageFiles;

}
