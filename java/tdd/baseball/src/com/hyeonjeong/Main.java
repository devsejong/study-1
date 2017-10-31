package com.hyeonjeong;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static int[] userANumber = makeUserANumber();

    public static void main(String[] args) {
        System.out.println("사용자A : " + userANumber[0] + userANumber[1] + userANumber[2]);

        boolean isThreeStrike = true;

        while (isThreeStrike) {
            Scanner scan = new Scanner(System.in);
            String userBInput = scan.next();
            String[] userB = userBInput.split("");

            if(userB.length != 3) {
                System.out.println("세자리 수를 입력하세요!");
                continue;
            }

            if(Arrays.asList(userB).contains("0")) {
                System.out.println("입력한 숫자 중에 0이 포함되어 있습니다. 다시 입력하세요");
                continue;
            }

            int[] userBNumber = new int[3];
            userBNumber[0] = Integer.parseInt(userB[0]);
            userBNumber[1] = Integer.parseInt(userB[1]);
            userBNumber[2] = Integer.parseInt(userB[2]);

            int strikeNumber = countStrikes(userANumber, userBNumber);
            int ballNumber = countBall(userANumber, userBNumber);

            //메세지를 출력한다.
            printMsg(strikeNumber, ballNumber);

            if(strikeNumber == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료!");
                break;
            }
        }
    }

    //결과 메세지 만든다.
    public static void printMsg(int strikeNumber, int ballNumber) {
        String message = "";

        if(strikeNumber != 0) {
            if(ballNumber != 0) {
                message = strikeNumber + "스트라이크 " + ballNumber + "볼";
            } else {
                message = strikeNumber + "스트라이크";
            }
        } else {
            message = "Nothing!!";
        }

        System.out.println(message);
    }

    //사용자A(컴퓨터) 세자리 수를 생성한다.
    public static int[] makeUserANumber() {
        int[] numbers = new int[3];
        numbers[0] = new Random().nextInt(9) + 1;
        numbers[1] = new Random().nextInt(9) + 1;
        numbers[2] = new Random().nextInt(9) + 1;
        return numbers;
    }

    //볼 개수를 구한다.
    public static int countBall(int[] userANumber, int[] userBNumber) {
        int count = 0;

        for(int i=0 ; i < userANumber.length ; i++) {
            for(int j=0 ; j < userBNumber.length ; j++) {
                if(userANumber[i] == userBNumber[j] && i != j) {
                    count++;
                }
            }
        }

        return count;
    }

    //스트라이크 개수를 구한다.
    public static int countStrikes(int[] userANumber, int[] userBNumber) {
        int count = 0;

        for(int i=0 ; i < userANumber.length ; i++) {
            if(userANumber[i] == userBNumber[i]) {
                count++;
            }
        }

        return count;
    }
}