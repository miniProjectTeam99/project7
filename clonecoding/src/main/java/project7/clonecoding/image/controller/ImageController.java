package project7.clonecoding.image.controller;

import project7.clonecoding.image.dto.ImageResponseDto;
import project7.clonecoding.image.service.ImageService ;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Api(tags = "image")
@RequiredArgsConstructor
@RestController
@Slf4j
public class ImageController {

    private final ImageService imageService;

    //프로필 사진 업로드
    @ApiOperation(value = "타이틀 이미지 업로드", notes = "타이틀 이미지를 s3에 저장한다.")
    @PostMapping("/files/title")
    public ImageResponseDto uploadTitle(@RequestParam(value = "file") MultipartFile multipartFile) throws IOException {
        log.info(multipartFile.getName());
        return imageService.uploadTitle(multipartFile);
    }

    //상품 이미지 업로드
    @ApiOperation(value = "게임 이미지 업로드", notes = "게임 이미지를 s3에 저장한다.")
    @PostMapping("/files/image")
    public ImageResponseDto uploadImage(@RequestParam(value= "file") MultipartFile multipartFile) throws IOException {
        return imageService.uploadImage(multipartFile);
    }
}
