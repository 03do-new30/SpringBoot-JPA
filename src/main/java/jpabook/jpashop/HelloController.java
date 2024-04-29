package jpabook.jpashop;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
    @GetMapping("hello")
    // model에 data를 실어서 view에 넘길 수 있다!
    public String hello(Model model) {
        model.addAttribute("data", "hello!!!");
        return "hello"; // 화면 이름
    }
}
