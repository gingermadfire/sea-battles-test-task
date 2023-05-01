package ru.redsoft.seabattles.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
@RequiredArgsConstructor
public class BattleMemberController {

    @GetMapping("main-page")
    public String getMainPage() {
        return "battle-members/main-page";
    }

    @GetMapping("new-battle")
    public String getCreatePage() {
        return "battle-members/create-battle";
    }

    @GetMapping("edit-battle")
    public String getEditPage() {
        return "battle-members/edit-battle";
    }
}
