package baseball.service.hint;

import java.util.List;

public class HintService {

  public Hint getHint(List<Integer> computerNumbers, List<Integer> playerNumbers) {
    int strikeCount = getStrikeCount(computerNumbers, playerNumbers);
    int ballCount = getBallCount(computerNumbers, playerNumbers);
    return new Hint(strikeCount, ballCount);
  }

  int getStrikeCount(List<Integer> computerNumbers, List<Integer> playerNumbers) {
    int strikeCount = 0;
    for (int i = 0; i < computerNumbers.size(); i++) {
      if (computerNumbers.get(i).equals(playerNumbers.get(i))) {
        strikeCount++;
      }
    }
    return strikeCount;
  }

  private int getBallCount(List<Integer> computerNumbers, List<Integer> playerNumbers) {
    int ballCount = 0;
    for (int i = 0; i < computerNumbers.size(); i++) {
      if (hasBall(computerNumbers, playerNumbers, i)) {
        ballCount += 1;
      }
    }
    return ballCount;
  }

  private boolean hasBall(List<Integer> computerNumbers, List<Integer> playerNumbers,
      int i) {
    for (int j = 0; j < playerNumbers.size(); j++) {
      if (i != j && computerNumbers.get(i).equals(playerNumbers.get(j))) {
        return true;
      }
    }
    return false;
  }

  public boolean isNotEnd(Hint hint) {
    return hint.getStrikeCount() != 3;
  }

  public void printHint(Hint hint) {
    int strikeCount = hint.getStrikeCount();
    int ballCount = hint.getBallCount();

    if (strikeCount == 0 && ballCount == 0) {
      System.out.println("낫싱");
    }
    if (ballCount != 0) {
      System.out.print(ballCount + "볼 ");
    }
    if (strikeCount != 0) {
      System.out.println(strikeCount + "스트라이크");
    }
    if (strikeCount == 3) {
      System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
  }
}
