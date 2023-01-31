package project7.clonecoding.game.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.PathVariable;
import project7.clonecoding.game.dto.*;
import project7.clonecoding.game.entity.Game;
import project7.clonecoding.game.repository.GameRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class GameService {
    private final GameRepository gameRepository;

    //게임 정보 단건으로 보내기 (추가한 내용)
//    public GameResponseDto getGame(@PathVariable Long id) {
//        Game game = gameRepository.findById(id).orElseThrow(
//                ()-> new IllegalArgumentException("해당 게시물은 존재하지 않습니다.")
//        );
//        return new GameResponseDto(game, id);
//    }
    //게임 정보 단건으로 보내기 (추가한 내용)
    public GameResponseDto getGame(@PathVariable Long id) {
        Game game = gameRepository.findById(id).orElseThrow(
                ()-> new IllegalArgumentException("해당 게시물은 존재하지 않습니다.")
        );
        return new GameResponseDto(game);
    }

    //게임 정보 전체 조회
    public GameResponseDto getGames() {
        List<Game> game = gameRepository.findAll();
        return new GameResponseDto(game);
    }

    //전체 게시글 조회하기(평점 순으로)
    public List<GameResponseDto> getGamesStar() {
        List<GameResponseDto> list = new ArrayList<>();
        List<Game> gameList;
        gameList = gameRepository.findAllByOrderByStarDesc();
        for (int i=0;i<10;i++) {list.add(new GameResponseDto(gameList.get(i),0));}
        return list;
    }
    //전체 게시글 조회하기(최신순으로)
    public List<GameResponseDto> getGamesRecent() {
        List<GameResponseDto> list = new ArrayList<>();
        List<Game> gameList;
        gameList = gameRepository.findAllByOrderByIdDesc();
        for (int i=0;i<10;i++) {list.add(new GameResponseDto(gameList.get(i),""));}
        return list;
    }
    public List<GameResponseDto> getFreeGames() { //무료게임
        List<GameResponseDto> list = new ArrayList<>();
        List<Game> gameList;
        gameList = gameRepository.findAllByGamePriceEqualsOrderByIdDesc(0);
        for (int i=0;i<6;i++) {list.add(new GameResponseDto(gameList.get(i),""));}
        return list;
    }
    public List<GameResponseDto> getPayGames() { //유료게임(연습용으로 한 거)
        List<GameResponseDto> list = new ArrayList<>();
        List<Game> gameList;
        gameList = gameRepository.findAllByGamePriceGreaterThanOrderByGamePriceDesc(0);
        for (int i=0;i<6;i++) {list.add(new GameResponseDto(gameList.get(i),""));}
        return list;
    }
    public GameResponseDto getGameScreenShot(@PathVariable Long id) {
        Game game = gameRepository.findById(id).orElseThrow(
                ()-> new IllegalArgumentException("해당 게시물은 존재하지 않습니다.")
        );
        return new GameResponseDto(game, id,0);
    }
    public GameResponseDto getGameInfo(@PathVariable Long id) {
        Game game = gameRepository.findById(id).orElseThrow(
                ()-> new IllegalArgumentException("해당 게시물은 존재하지 않습니다.")
        );
        return new GameResponseDto(game, id,"");
    }
}