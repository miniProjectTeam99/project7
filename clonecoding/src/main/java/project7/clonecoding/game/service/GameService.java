package project7.clonecoding.game.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import project7.clonecoding.game.dto.*;
import project7.clonecoding.game.entity.Game;
import project7.clonecoding.game.repository.GameRepository;
import project7.clonecoding.user.UserRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class GameService {
    private final GameRepository gameRepository;
    private final UserRepository userRepository;

    //게임 정보 단건으로 보내기 (추가한 내용)
    public GameResponseDto getGame(@PathVariable Long id) {

        Game game = gameRepository.findById(id).orElseThrow(
                ()-> new IllegalArgumentException("해당 게시물은 존재하지 않습니다.")
        );

        return new GameResponseDto(game);
    }

    //게임 정보 단건으로 보내기 (추가한 내용)
    public GameResponseDto getGames() {

        List<Game> game = gameRepository.findAll();

        return new GameResponseDto(game);
    }

    //게시물 수정
    @Transactional
    public ResponseDto updateGame(Long id, GameRequestDto request) {
        //id로 게시물 찾기
        Game game = findGameById(id);
        //게시물 수정
//        game.update(request);
        return new ResponseDto("수정 완료.");
    }
    //게시물 수정
    @Transactional
    public ResponseDto rateStar(Long id, StarRequestDto request) {
        //id로 게시물 찾기
        Game game = findGameById(id);
        //게시물 수정
//        game.update(request);
        return new ResponseDto("평점 매기기 완료.");
    }
    //게시물 delete
    @Transactional
    public ResponseDto DeleteGame(Long id) {
        gameRepository.findById(id).orElseThrow(
                ()-> new IllegalArgumentException("해당 게시물은 존재하지 않습니다.")
        );
        //게시글 삭제
        gameRepository.deleteById(id);
        return new ResponseDto("삭제 완료.");
    }
    //게시물 단건 조회할 때 사용
    public Game findGameById(Long id){  //살아있는 게시글만 찾기
        return gameRepository.findById(id).orElseThrow(
                ()-> new IllegalArgumentException("해당 게시물은 존재하지 않습니다.")
        );
    }

}