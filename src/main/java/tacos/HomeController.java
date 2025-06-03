package tacos;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller  // 🔹 반드시 필요
public class HomeController {

    @GetMapping("/")  // 🔹 루트 요청 처리
    public String home() {
        return "home";  // 🔹 templates/home.html 파일을 렌더링
    }
}
