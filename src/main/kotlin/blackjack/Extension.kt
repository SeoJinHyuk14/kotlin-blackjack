package blackjack

fun String?.parseInt(): Int {
    require(this != null) { "빈 값을 입력하면 안됩니다." }
    return this.toIntOrNull() ?: throw IllegalArgumentException("자연수로 변환하는데 실패했습니다.")
}
