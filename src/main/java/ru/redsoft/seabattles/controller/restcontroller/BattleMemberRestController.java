package ru.redsoft.seabattles.controller.restcontroller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.redsoft.seabattles.exchange.request.BattleMemberRequest;
import ru.redsoft.seabattles.exchange.response.BattleMemberFindAllResponse;
import ru.redsoft.seabattles.exchange.response.BattleMemberResponse;
import ru.redsoft.seabattles.service.BattleMemberService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/battle-members")
public class BattleMemberRestController {

    private final BattleMemberService battleMemberService;

    @GetMapping
    public List<BattleMemberFindAllResponse> findAll() {
        return battleMemberService.findAll();
    }

    @PostMapping
    public BattleMemberResponse save(@RequestBody BattleMemberRequest request) {
        return battleMemberService.save(request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        battleMemberService.delete(id);
    }

    @PutMapping
    public BattleMemberResponse update(@RequestBody BattleMemberRequest request) {
        return battleMemberService.update(request);
    }
}
