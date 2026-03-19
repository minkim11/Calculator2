import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in); // 사용자 입력을 받기 위해 Scanner 객체 생성

        System.out.println("===== 자바 계산기 =====");

        // 입력 받을 변수 선언
        int num1;
        char op;
        int num2;
        // 연산자 확인을 위한 리스트 생성
        List<Character> opList = List.of('+', '-', '*', '/');

        // 사용자 입력 후 계산 기능 반복
        while (true) {
            double result = 0; // 결과값 초기화
            // 사용자 입력 및 예외 처리
            try {
                System.out.print("첫 번째 숫자를 입력하세요.: ");
                num1 = sc.nextInt();
                System.out.print("사칙연산 기호를 입력하세요.: ");
                op = sc.next().charAt(0);
                System.out.print("두 번째 숫자를 입력하세요.: ");
                num2 = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("숫자를 입력하세요!");
                sc.nextLine(); // 잘못된 입력값 제거
                continue;
            }
            // 양의 정수 확인
            if (num1 < 0 || num2 < 0) {
                System.out.println("양의 정수를 입력하세요!");
                continue;
            }

            // 연산자 확인 및 계산 기능
            if (opList.contains(op)) {
                switch (op) {
                    case '+':
                        result = num1 + num2;
                        break;
                    case '-':
                        result = num1 - num2;
                        break;
                    case '*':
                        result = num1 * num2;
                        break;
                    case '/': // 나눗셈 오류 방지
                        if (num2 == 0) {
                            System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
                            continue;
                        }
                        result = num1 / (double)num2;
                        break;
                }
            } else {
                System.out.println("올바른 연산자를 입력하세요! " + opList);
                continue;
            }


            //결과값 출력
            System.out.println("결과 = " + result);

            //반복문 종료 분기점
            System.out.print("더 계산하시겠습니까? (exit 입력 시 종료): ");
            String exitCheck = sc.next();
            if (exitCheck.equals("exit")) {
                System.out.println("계산기를 종료합니다.");
                break;
            }
        }

    }
}
