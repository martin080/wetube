package com.martin.tube.storage;

import com.google.common.hash.Hashing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.core.io.support.ResourceRegion;
import org.springframework.http.HttpRange;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

@Service
public class VideoStorageService extends FileStorageService {
    private final Path location;
    private final String baseUrl;

    public VideoStorageService(StorageProperties props) {
        location = Paths.get(props.getVideoLocation());
        baseUrl = props.getVideoUrlLocation();
    }

    @Override
    public Path getLocation() {
        return location;
    }

    public String getUrl(String fileName){
        return baseUrl + "/" + fileName;
    }

    public String getBaseUrl(){
        return baseUrl;
    }
}