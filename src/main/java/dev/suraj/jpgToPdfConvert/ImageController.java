package dev.suraj.jpgToPdfConvert;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;

@Controller
public class ImageController {

    @GetMapping("/upload")
    public String showUploadForm() {
        return "upload";
    }

    @PostMapping("/upload")
    public String uploadImage(@RequestParam("image") MultipartFile image, Model model) throws IOException {
        byte[] bytes = image.getBytes();
        String ImageString = "data:image/png;base64," + Base64.getEncoder().encodeToString(bytes);
        model.addAttribute("image", ImageString);
        System.out.println("uploaded image: "+ image.getOriginalFilename());
        return "download";
    }

}