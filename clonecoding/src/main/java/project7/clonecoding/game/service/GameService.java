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

    //게임 정보 전체 조회
    public GameResponseDto getGames() {
        List<Game> game = gameRepository.findAll();
        return new GameResponseDto(game);
    }

}