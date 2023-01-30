package project7.clonecoding.game.controller;

import project7.clonecoding.game.dto.*;
import project7.clonecoding.game.service.GameService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Api(tags = {"Game"})
@RestController
@RequiredArgsConstructor
@Slf4j
public class GameController {

    private final GameService gameService;
    @ApiOperation(value = "평점순 조회", notes = "등록된 게시글 목록 전체를 평점 순으로 조회한다.")
    @GetMapping("/games/star")
    public List<GameResponseDto> getGamesStar() {
        return gameService.getGamesStar();
    }
    @ApiOperation(value = "최신순 조회", notes = "등록된 게시글 목록 전체를 최신 순으로 조회한다.")
    @GetMapping("/games/recent")
    public List<GameResponseDto> getGamesRecent() {
        return gameService.getGamesRecent();
    }
    @ApiOperation(value = "무료게임 조회", notes = "등록된 게시글 목록 중 무료게임을 조회한다.")
    @GetMapping("/games/free")
    public List<GameResponseDto> getFreeGames() {
        return gameService.getFreeGames();
    }
    @ApiOperation(value = "유료게임 조회", notes = "등록된 게시글 목록 중 무료게임을 조회한다.")
    @GetMapping("/games/pay")
    public List<GameResponseDto> getPayGames() {
        return gameService.getPayGames();
    }
    //게임 id로 단건 조회
    @ApiOperation(value = "게임 단일 상세 조회", notes = "게임 id로 목록을 상세 조회한다.")
    @GetMapping("/games/sc/{gameId}")
    public GameResponseDto getGameScreenShot(@PathVariable Long gameId) {
        return gameService.getGameScreenShot(gameId);
    }
    //게임 id로 단건 조회
    @ApiOperation(value = "게임 단일 상세 조회", notes = "게임 id로 목록을 상세 조회한다.")
    @GetMapping("/games/info/{gameId}")
    public GameResponseDto getGameInfo(@PathVariable Long gameId) {
        return gameService.getGameInfo(gameId);
    }
}
