package project7.clonecoding.game.service;

import lombok.extern.slf4j.Slf4j;
import project7.clonecoding.game.dto.GameRequestDto;
import project7.clonecoding.game.dto.GameResponseDto;
import project7.clonecoding.game.dto.ResponseDto;
import project7.clonecoding.game.dto.StarRequestDto;
import project7.clonecoding.game.entity.Game;
import project7.clonecoding.game.repository.GameRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class GameService {
    private final GameRepository gameRepository;
//    private final UserRepository userRepository;

    //게시글 작성하기
    @Transactional
    public ResponseDto createGame(GameRequestDto gameRequestDto)  {
        log.info("ㄱㄱ");
        // 게시글 객체 생성
        Game game = new Game(gameRequestDto);
        //게시글 객체 db에 저장
        gameRepository.save(game);
        //msg: 게시글 작성완료! 반환
        return new ResponseDto("게시글 작성 완료!");
    }

    //전체 게시글 조회하기
    @Transactional
    public List<GameResponseDto> getGames() {
        List<GameResponseDto> list = new ArrayList<>();
        List<Game> gameList;
        gameList = gameRepository.findAllByOrderByCreatedAtDesc();
        for (Game game : gameList) {
            list.add(new GameResponseDto(game));
        }

        return list;
    }

//    게시물 id로 조회하기
    @Transactional
    public GameResponseDto getGame(Long id) {
        //id로 게시물 조회하기
        Game game = findGameById(id);
//        userRepository.findById(game.getUserId()).orElseThrow(
//                ()-> new IllegalArgumentException("존재하지 않는 게시글입니다.")
//        );
        return new GameResponseDto(game);
    }

    //게시물 수정
    @Transactional
    public ResponseDto updateGame(Long id, GameRequestDto request) {
        //id로 게시물 찾기
        Game game = findGameById(id);
        //게시물 수정
        game.update(request);
        return new ResponseDto("수정 완료.");
    }
    //게시물 수정
    @Transactional
    public ResponseDto rateStar(Long id, StarRequestDto request) {
        //id로 게시물 찾기
        Game game = findGameById(id);
        //게시물 수정
        game.update(request);
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