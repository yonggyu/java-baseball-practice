package baseball;

import camp.nextstep.edu.missionutils.Console;

public class View {
    public String setNumber() {
        System.out.println("숫자를 입력해주세요 : ");
        return Console.readLine();
    }

    public String setRetry() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return Console.readLine();
    }

    public void printGameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void printBallStrike() {
        System.out.println("볼 ");
    }

    public void printStrike() {
        System.out.println("스트라이크");
    }

    public void printBall() {
        System.out.println("볼");
    }

    public void printNothing() {
        System.out.println("낫싱");
    }

    public void printCount(int count) {
        System.out.println(count);
    }

    public void printGameWin() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}