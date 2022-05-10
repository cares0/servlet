package hello.servlet.web.springmvc.v3;

import hello.servlet.basic.domain.member.Member;
import hello.servlet.basic.domain.member.MemberRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/springmvc/v3/members")
public class SpringMemberControllerV3 {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    // 뷰 이름만 반환하는 방식
    @RequestMapping(value = "/new-form", method = RequestMethod.GET)
    // @GetMapping("/new-form") 이것도 가능
    public String newForm() {
        return "new-form";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    // @PostMapping("/save")
    public String save(
            @RequestParam("username") String username, // 직접 매개변수로 파라미터 받기 가능
            @RequestParam("age") int age, // 동시에 자동 형변환도 가능
            Model model) {

        Member member = new Member(username, age);
        memberRepository.save(member);

        model.addAttribute("member", member);

        return "save-result";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    // @GetMapping("/")
    public String members(Model model) {
        List<Member> members = memberRepository.findAll();


        model.addAttribute("members", members);

        return "members";
    }
}
