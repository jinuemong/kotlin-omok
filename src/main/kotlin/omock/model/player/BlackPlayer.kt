package omock.model.player

import omock.model.rule.OMockRule
import omock.model.search.Direction
import omock.model.search.VisitedDirectionResult
import omock.model.stone.Stone

data class BlackPlayer(
    override val stoneHistory: ArrayDeque<Stone> = ArrayDeque(),
) : Player() {
    override fun judgementResult(visitedDirectionResult: VisitedDirectionResult): Boolean {
        visitedDirectionResult.visited.entries.forEach { (key, result) ->
            val reverseResultCount: Int =
                visitedDirectionResult.visited[Direction.reverse(key)]?.count ?: OMockRule.MIN_REVERSE_COUNT
            if (isOverMinOMockCount(reverseResultCount + result.count)) return true
        }
        return false
    }

    private fun isOverMinOMockCount(count: Int): Boolean {
        return count >= OMockRule.MIN_O_MOCK_COUNT
    }
}
