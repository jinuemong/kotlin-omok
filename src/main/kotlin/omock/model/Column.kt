package omock.model

@JvmInline
value class Column(val comma: String) {
    init {
        require(comma in COLUM_RANGE) {
            ERROR_COLUMN_RANGE
        }
    }

    fun getIndex(): Int {
        return comma[0].code - MIN_COLUMN.code
    }

    companion object {
        const val MIN_COLUMN = 'A'
        const val MAX_COLUMN = 'O'
        const val MIN_COLUMN_INDEX = 0
        const val MAX_COLUMN_INDEX = MAX_COLUMN.code - MIN_COLUMN.code
        val COLUM_RANGE = (MIN_COLUMN..MAX_COLUMN).map { it.toString() }
        private const val ERROR_COLUMN_RANGE = "Column은 ${MIN_COLUMN}~${MAX_COLUMN} 사이여야 합니다."
    }
}