package hello.upload.file;

import hello.upload.domain.UploadFile;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class FileStore {

    @Value("${file.dir}")
    private String fileDir;

    public String getFullFilePath(String filename) {
        return fileDir + filename;
    }

    // 첨부파일 - 저장용 파일로 변경
    public UploadFile storeFile(MultipartFile multipartFile) throws IOException {
        if(multipartFile.isEmpty()) {
           return null;
        }

        String originalFilename = multipartFile.getOriginalFilename();
        String storeFileName =  createStoreFileName(originalFilename);
        multipartFile.transferTo(new File(getFullFilePath(storeFileName)));

        return new UploadFile(originalFilename, storeFileName);
    }

    // 이미지 파일들 - 저장용 파일로 변경
    public List<UploadFile> storeFiles(List<MultipartFile> multipartFiles) throws IOException {
        List<UploadFile> uploadFiles = new ArrayList<>();

        for (MultipartFile multipartFile : multipartFiles) {
            if (!multipartFile.isEmpty()) {
                uploadFiles.add(storeFile(multipartFile));
            }
        }
        return uploadFiles;
    }

    // 서버에 저장 되는 파일 이름 생성
    private String createStoreFileName(String originalFilename) {
        String uuid = UUID.randomUUID().toString();
        String ext = extractExt(originalFilename);
        return uuid + "." + ext;
    }

    // 확장자 추출
    private String extractExt(String originalFilename) {
        int pos = originalFilename.indexOf(".");
        return originalFilename.substring(pos+1);
    }

}
