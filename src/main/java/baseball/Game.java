package baseball;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Game {
    private int strike;
    private int ball;
    private int success = 0;

    public Computer computer;

    public Game(Computer computer) {
        this.computer = computer;
        this.strike = 0;
        this.ball = 0;
    }

    public void init() {
        computer.init();
        strike = 0;
        ball = 0;
    }

    public void start() {
        List<Integer> userNumbers = new ArrayList<>();
        String userInput;

        System.out.println("숫자 야구 게임을 시작합니다.");
        while (strike < 3) {
            System.out.print("숫자를 입력해 주세요 : ");
            userInput = readLine();
            validateUserInput(userInput);
            userNumbers = stringToIntegerList(userInput);
        }
    }

    private List<Integer> stringToIntegerList(String userInput) {
        String[] userInputSplit = userInput.split("");
        ArrayList<Integer> result = new ArrayList<>();

        for (String u : userInputSplit) {
            result.add(Integer.parseInt(u));
        }

        return result;
    }

    public void validateUserInput(String userInput) {
        try {
            Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Input is wrong.");
        }
    }

    public void isValidateRange(List<Integer> userInput) {
        if(userInput.size() != 3) {
            throw new IllegalArgumentException("Input size is too long.");
        }
    }
}
