package kr.ac.kopo.webapplication.controller;


import kr.ac.kopo.webapplication.dto.SampleDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller // 웹페이지 실행
@RequestMapping("/sample") // 구동할 웹페이지파일이 있는 디렉토리
public class SampleController {

    @GetMapping("ex1") // 구동할 웹페이지
    public void ex(){


    } // ex}

    @GetMapping({"/ex2","/ex2_1", "/exBlock", "/exLink"}) // 데이터를 주고 받을 객체 생성 ex2.html에 전달
    public void exModel(Model model){

        //20개의 객체 주솟값이 들어가있다.
        List<SampleDTO> list = IntStream.rangeClosed(1, 20).asLongStream().mapToObj(i -> {
            SampleDTO dto = SampleDTO.builder()
                    .sno(i)
                    .first("First.." + i)
                    .last("Last.." + i)
                    .regTime(LocalDateTime.now()) //현재지역의 날짜와 시간정보
                    .build();
            return dto; //현재 지역의 날짜와 시간 정보 return
        }).collect(Collectors.toList());

        model.addAttribute("list", list);

    } // exModel}

    @GetMapping("/exInline")
    public String exInline(RedirectAttributes redirectAttributes){
        SampleDTO dto = SampleDTO.builder()
                .sno(100L)
                .first("first...100")
                .last("last.....100")
                .regTime(LocalDateTime.now())
                .build();
        redirectAttributes.addFlashAttribute("result", "Success");
        redirectAttributes.addFlashAttribute("dto", dto);

        return "redirect:/sample/ex3";

    } // exInline}

    //html 불러옴
    @GetMapping("/ex3")
    public void ex3(){

    } // ex3}
    @GetMapping("/exLayout1")
    public void exLayout1(){

    } // exLayout1}


} //main}
