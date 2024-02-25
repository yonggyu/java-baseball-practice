package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class Model {
    private String computerNum;
    private String playerNum;

    private int ball;
    private int strike;

    public Model(){
        setClearNum();
        validNumLength(playerNum);
        strToIntPlayerNum(playerNum);
        isSameNum(playerNum);
    }

    public String getComputerNum() {
        return computerNum;
    }

    public String getPlayerNum() {
        return playerNum;
    }

    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }

    public int[] getBallStrikeCount(String playerNum, String inputNum) {
        ball = 0;
        strike = 0;

        for(int i = 0; i < playerNum.length(); i++) {
            //ball count
            if(inputNum.contains(Character.toString(playerNum.charAt(i)))) {
                ball++;
            }

            //strike count
            if(inputNum.charAt(i) == playerNum.charAt(i)) {
                strike++;
            }
        }

        ball = ball - strike;

        return new int[] {ball, strike};
    }

    public boolean is3Strike() {
        if(getStrike() == 3) {
            return true;
        }
        return false;
    }

    public void setClearNum() {
        LinkedHashSet<String> generateNumString = new LinkedHashSet<String>();
        while(generateNumString.size() < 3) {
            generateNumString.add(generateNum());
        }
        this.playerNum = String.join("", generateNumString);
    }

    public static String generateNum() {
        return Integer.toString(Randoms.pickNumberInRange(1, 9));
    }

    public void validNumLength(String num) throws IllegalArgumentException {
        if(num.length() != 3) {
            throw new IllegalArgumentException("잘못된 값을 입력하셨습니다. (입력값 3자리수)");
        }
    }

    public void strToIntPlayerNum(String num) {
        for(int i = 0; i < num.length(); i++) {
            isOverMaxLength(num, i);
        }
    }

    public void isSameNum(String num) throws IllegalArgumentException {
        Set<Character> set = new HashSet<>();

        for(int i = 0; i < num.length(); i++) {
            set.add(num.charAt(i));
        }
        if(set.size() != num.length()) {
            throw new IllegalArgumentException("잘못된 값을 입력하셨습니다. (중복된 숫자)");
        }
    }

    private void isOverMaxLength(String num, int idx) throws IllegalArgumentException {
        if(!Character.isDigit(num.charAt(idx))) {
            throw new IllegalArgumentException("잘못된 값을 입력하셨습니다. (3자리 자연수가 아닙니다)");
        }
    }
}
