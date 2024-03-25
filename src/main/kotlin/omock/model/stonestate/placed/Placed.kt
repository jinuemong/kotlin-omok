package omock.model.stonestate.placed

import omock.model.stone.Stone
import omock.model.player.Player
import omock.model.stonestate.StoneState
import omock.model.stonestate.unplaced.Clear

abstract class Placed(private val stone: Stone) : StoneState {
    override fun put(player: Player): StoneState {
        throw IllegalArgumentException(ERROR_STONE_DUPLICATION)
    }

    override fun rollback(): StoneState {
        return Clear(stone)
    }

    companion object {
        private const val ERROR_STONE_DUPLICATION = "이미 돌이 있습니다."
    }
}