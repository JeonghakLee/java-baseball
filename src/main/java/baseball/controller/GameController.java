package baseball.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class GameController {

  private static final int RANDOM_NUMBER_SIZE = 3;
  private static final int BEGIN = 1;
  private static final int END = 9;
  private final List<Integer> computerNumbers;

  public GameController() {
    this.computerNumbers = getRandomNumbers();
  }

  private List<Integer> getRandomNumbers() {
    List<Integer> randomNumbers = new ArrayList<>();
    while (randomNumbers.size() < RANDOM_NUMBER_SIZE) {
      int randomNumber = Randoms.pickNumberInRange(BEGIN, END);
      if (!randomNumbers.contains(randomNumber)) {
        randomNumbers.add(randomNumber);
      }
    }
    return randomNumbers;
  }

}