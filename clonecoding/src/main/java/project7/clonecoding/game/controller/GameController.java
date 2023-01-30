package project7.clonecoding.game.controller;

import project7.clonecoding.game.dto.*;
import project7.clonecoding.game.service.GameService;
import project7.clonecoding.security.UserDetailsImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Api(tags = {"Game"})
@RestController
@RequiredArgsConstructor
@Slf4j
public class GameController {

    private final GameService gameService;

    //게임 목록 전체 조회
    @ApiOperation(value = "게임 전체 조회", notes = "게임 목록의 전체정보를 조회한다.")
    @GetMapping("/games")
    public GameResponseDto getGame() {
        return gameService.getGames();
    }

    //게임 id로 단건 조회
    @ApiOperation(value = "게임 단일 상세 조회", notes = "게임 id로 목록을 상세 조회한다.")
    @GetMapping("/games/{gameId}")
    public GameResponseDto getGame(@PathVariable Long gameId) {
        return gameService.getGame(gameId);
    }

}
