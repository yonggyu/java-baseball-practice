package baseball;

public class Controller {
    private final Model model;
    private final View view;

    public Controller() {
        this.model = new Model();
        this.view = new View();
    }

    public void playGame() {
        view.printGameStart();
        while (true) {
            String playerNum = view.setNumber();
            if (playerNum == null) {
                continue;
            }
            try {
                model.validNumLength(playerNum);
                model.strToIntPlayerNum(playerNum);
                model.isSameNum(playerNum);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }

            int[] ballStrikeCount = model.getBallStrikeCount(model.getComputerNum(), playerNum);
            printBallStrike(ballStrikeCount[0], ballStrikeCount[1]);

            if (model.is3Strike()) {
                view.printGameWin();
                if ("2".equals(view.setRetry())) {
                    break;
                }
                model.setClearNum();
            }
        }
    }

    private void printBallStrike(int ball, int strike) {
        if (ball > 0) {
            view.printCount(ball);
            view.printBall();
        }
        if (strike > 0) {
            view.printCount(strike);
            view.printStrike();
        }
        if (ball == 0 && strike == 0) {
            view.printNothing();
        }
    }
}
