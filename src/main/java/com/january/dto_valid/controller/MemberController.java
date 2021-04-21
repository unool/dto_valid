package com.january.dto_valid.controller;
import com.january.dto_valid.dto.MemberDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RequestMapping("/member")
@Controller
public class MemberController {

    @GetMapping("/register")
    public String register(@ModelAttribute("memberDTO") MemberDTO memberDTO)
    {
        return "/member/register";
    }


    @PostMapping("/register")
    public String register(@Valid MemberDTO memberDTO,
                           Errors errors, RedirectAttributes redirectAttributes, Model model){

        if(errors.hasErrors())
        {
            //기존 데이터 그대로
            model.addAttribute("memberDTO", memberDTO);

            // 유효성 통과 못한 필드와 메시지를 핸들링
            Map<String, String> validatorResult = validateHandling(errors);
            for (String key : validatorResult.keySet()) {
                model.addAttribute(key, validatorResult.get(key));
            }

            return "/member/register";
        }

        redirectAttributes.addAttribute("result", "valid value!");
        return "redirect:/";
    }

    public Map<String, String> validateHandling(Errors errors) {

        Map<String, String> validatorResult = new HashMap<>();

        for(FieldError error : errors.getFieldErrors())
        {
            String fieldName = String.format("valid_%s",error.getField());
            validatorResult.put(fieldName,error.getDefaultMessage());
        }

        return validatorResult;
    }

}
