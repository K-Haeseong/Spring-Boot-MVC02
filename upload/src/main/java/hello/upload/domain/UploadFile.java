package hello.upload.domain;

import lombok.Data;

@Data
public class UploadFile {

    private String uploadFile; // 사용자가 저장한 파일 이름
    private String storeFileName; // 서버에 저장 되는 파일 이름

    public UploadFile(String uploadFile, String storeFileName) {
        this.uploadFile = uploadFile;
        this.storeFileName = storeFileName;
    }
}
