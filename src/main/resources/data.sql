-- 1. 미니게임 데이터
INSERT INTO mini_game (id, name, url) VALUES
                                          (1, '초성게임', 'https://example.com/images/chosung.png'),
                                          (2, '기억력게임', 'https://example.com/images/memory.png');

-- 2. 게임 상세 정보 (ID 생략: auto increment 사용)
INSERT INTO game_detail (
    name, min_player_count, max_player_count,
    description, intro, game_rule, difficulty, image_url
) VALUES
      ('바니바니', 2, 6, '리듬을 타며 외치는 게임', '빠르게 말해요!', '1. 바니 바니 바니 바니 2. 틀리면 탈락!', 2, 'https://example.com/images/bunny.png'),
      ('몸으로 말해요', 3, 10, '제스처로 단어를 설명하는 게임', '몸으로 표현해요!', '1. 출제자는 단어를 보고 2. 나머지는 맞힙니다.', 3, 'https://example.com/images/body.png');

-- 3. 초성게임 자음쌍 (InitialGame 테이블의 mini_game_id는 FK → 먼저 미니게임 삽입 필요)
INSERT INTO initial_game (two_initial_words, mini_game_id) VALUES
                                                               ('ㄱㄱ', 1),
                                                               ('ㅅㄱ', 1),
                                                               ('ㅂㅅ', 1),
                                                               ('ㅈㅈ', 1),
                                                               ('ㄴㅈ', 1),
                                                               ('ㅇㅈ', 1),
                                                               ('ㅊㅅ', 1),
                                                               ('ㅋㅍ', 1),
                                                               ('ㅎㄷ', 1),
                                                               ('ㄷㅂ', 1);
