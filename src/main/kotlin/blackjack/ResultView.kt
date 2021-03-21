package blackjack

fun Player.cardText(): String {
    val cardTexts = cardDeck.cards.map { it.cardNumber.text() + it.type.text() }
    return "${name}카드: ${cardTexts.joinToString(", ")}"
}

fun CardType.text(): String {
    return when (this) {
        CardType.SPADE -> "스페이드"
        CardType.CLOVER -> "클로버"
        CardType.HEART -> "하트"
        CardType.DIAMOND -> "다이아"
    }
}

fun CardNumber.text(): String {
    return when (this) {
        CardNumber.ACE -> "A"
        CardNumber.TWO -> "2"
        CardNumber.THREE -> "3"
        CardNumber.FOUR -> "4"
        CardNumber.FIVE -> "5"
        CardNumber.SIX -> "6"
        CardNumber.SEVEN -> "7"
        CardNumber.EIGHT -> "8"
        CardNumber.NINE -> "9"
        CardNumber.TEN -> "10"
        CardNumber.JACK -> "J"
        CardNumber.QUEEN -> "Q"
        CardNumber.KING -> "K"
    }
}
