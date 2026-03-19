import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in); // 사용자 입력을 받기 위해 Scanner 객체 생성

        System.out.println("=== 자바 계산기 ===");

        // 입력 받을 변수 선언
        int num1;
        char op;
        int num2;
        // 사용자 입력 후 계산 기능 반복
        while (true) {
            int result = 0; // 결과값 초기화
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
                sc.nextLine();
                continue;
            }

            // 연산자에 따른 계산 기능
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
                    result = num1 / num2;
                    break;
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
