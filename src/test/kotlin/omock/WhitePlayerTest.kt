package omock

import omock.model.board.Board
import omock.model.player.BlackPlayer
import omock.model.position.Column
import omock.model.position.Row
import omock.model.stone.Stone
import omock.model.player.WhitePlayer
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class WhitePlayerTest {
    @Test
    fun `플레이어가 돌을 놓을 때, Board는 오목인 경우 true를 반환한다`() {
        val player = BlackPlayer()
        val board = Board.from()
        board.makeStones(
            player = player,
            coordinates = arrayOf("2B", "1B", "2A", "3A", "4A", "5A"),
        )
        val stone = Stone.from(Row("1"), Column("A"))
        board.setStoneState(player, stone)
        val visited = board.loadMap(stone)
        Assertions.assertThat(player.judgementResult(visited)).isTrue()
    }

    @Test
    fun `플레이어가 돌을 놓을 때, Board는 오목이 아닌 경우 false 반환한다`() {
        val player = WhitePlayer()
        val board = Board.from()
        board.makeStones(
            player = player,
            coordinates = arrayOf("2B", "1B", "2A", "3A", "5A"),
        )

        val stone =
            Stone.from(Row("1"), Column("A"))
        val visited = board.loadMap(stone)
        Assertions.assertThat(player.judgementResult(visited)).isFalse()
    }
}
