public class Card {

    private CardSuits cardSuits;
    private CardRanks cardRanks;

    public Card(CardSuits cardSuits, CardRanks cardRanks) {
        this.cardSuits = cardSuits;
        this.cardRanks = cardRanks;
    }

    public CardSuits getCardSuits() {
        return cardSuits;
    }

    public CardRanks getCardRanks() {
        return cardRanks;
    }

    public int getPowerOfCard() {
        return cardSuits.getSuitPower() + cardRanks.getRankPower();
    }
}
