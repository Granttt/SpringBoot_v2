package com.fc.test.fileTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.stream.Collectors;

/**
 * @auther : 高希阳
 * @Date: 2018/10/11 11:03
 * @Description: https://blog.csdn.net/forezp/article/details/71023752
 * https://blog.csdn.net/kenight/article/details/77053804
 * https://www.jb51.net/article/120098.htm
 */
@Controller
@RequestMapping(value = "hello")
public class FileUploadController {

    private final StorageService storageService;

    @Autowired
    public FileUploadController(StorageService storageService) {
        this.storageService = storageService;
    }

    /**
     * 功能描述：GET /abc 获取已经上传的文件列表
     * @author gxy
     * @date 2018/10/11 12:03
     * @param
     * @return
     */
    @GetMapping("/abc")
    public String listUploadedFiles(Model model,RedirectAttributes redirectAttributes) throws IOException {



        model.addAttribute("files", storageService
                .loadAll()
                .map(path ->
                        MvcUriComponentsBuilder
                                .fromMethodName(FileUploadController.class, "serveFile", path.getFileName().toString())
                                .build().toString())
                .collect(Collectors.toList()));
        redirectAttributes.addFlashAttribute("message",null);
        return "uploadForm";
    }

    /**
     * 功能描述：GET /files/{filename} 下载已经存在于服务器的文件
     * @author gxy
     * @date 2018/10/11 12:03
     * @param
     * @return
     */
    @GetMapping("/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable String filename) {

        Resource file = storageService.loadAsResource(filename);
        return ResponseEntity
                .ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\""+file.getFilename()+"\"")
                .body(file);
    }

    /**
     * 功能描述：POST /post 上传文件给服务器
     * @author gxy
     * @date 2018/10/11 12:03
     * @param
     * @return
     */
    @PostMapping("/post")
    public String handleFileUpload(@RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes) {

        storageService.store(file);
        redirectAttributes.addFlashAttribute("message",
                "You successfully uploaded " + file.getOriginalFilename() + "!");

        return "redirect:/hello/abc";
    }

    @ExceptionHandler(StorageFileNotFoundException.class)
    public ResponseEntity handleStorageFileNotFound(StorageFileNotFoundException exc) {
        return ResponseEntity.notFound().build();
    }

}

