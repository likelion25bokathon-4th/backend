package bokathon4th.core.controller;

import bokathon4th.core.domain.MiniGame;
import bokathon4th.core.service.InitialGameService;
import bokathon4th.core.service.MiniGameService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/minigame")

public class MiniGameController {

    private final MiniGameService miniGameService;
    private final InitialGameService initialGameService;

    @GetMapping
    public ResponseEntity<List<MiniGame>> getMiniGameList() {
        List<MiniGame> games = miniGameService.getAllMiniGames();
        return ResponseEntity.ok(games);
    }

    @GetMapping("/{id}/initial")
    public ResponseEntity<Map<String, String>> getInitial(@PathVariable Long id) {
        String initial = initialGameService.getRandomInitial(id);
        return ResponseEntity.ok(Map.of("initials", initial));
    }
}
