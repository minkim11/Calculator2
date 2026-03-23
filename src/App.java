import java.util.List;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in); // 사용자 입력을 받기 위해 Scanner 객체 생성
        Calculator calculator = new Calculator(); // 계산기 클래스 객체화

        System.out.println("===== 자바 계산기 =====");
        // 사용자 입력 후 계산 기능 반복
        while (true) {
            // 입력 받을 변수 선언
            double num1;
            char op;
            double num2;
            // 사용자 입력 및 숫자 이외의 값 입력 시 예외 처리
            try {
                System.out.print("첫 번째 숫자를 입력하세요.: ");
                num1 = sc.nextDouble();
                System.out.print("사칙연산 기호를 입력하세요.: ");
                String tempOp = sc.next();
                if (tempOp.length() == 1) {
                    op = tempOp.charAt(0);
                } else {
                    System.out.println("연산자를 한글자만 입력하세요!");
                    continue;
                }
                System.out.print("두 번째 숫자를 입력하세요.: ");
                num2 = sc.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("숫자를 입력하세요!");
                sc.nextLine(); // 잘못된 입력값 제거(다음 입력 받기 위해)
                continue;
            }
            // 양의 정수 확인
            if (num1 < 0 || num2 < 0) {
                System.out.println("양의 정수를 입력하세요!");
                continue;
            }
            // 연산자 확인 NPE 방지
            if (OperatorType.findOperator(op) == null) {
                System.out.println("올바른 연산자를 입력하세요!");
                continue;
            }
            // 나눗셈 오류 방지 0나누기 방지
            if (("➗".equals(op + "") || op == '/') && num2 == 0) {
                System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
                continue;
            }

            // 계산기 클래스의 메서드 사용
            double result = calculator.calculate(num1, num2, op);

            // 결과값 출력
            System.out.println("결과 = " + result);

            // 결과 목록 조회(getter 활용)
            List<Double> resultList = calculator.getResultList();
            System.out.println("결과 목록 = " + resultList);

            // 결과 목록 수정(setter 활용)
            try {
                System.out.print("결과 목록을 수정하시겠습니까? (yes 입력 시 진행): ");
                String changeYes = sc.next();
                if (changeYes.equals("yes")) {
                    System.out.print("목록 중 변경할 값의 번호를 입력하세요. (0부터 시작): ");
                    int index = sc.nextInt();
                    System.out.print("원하는 변경값을 입력하세요: ");
                    double changeResult = sc.nextDouble();
                    calculator.setResultList(index, changeResult);
                    System.out.println("변경 완료!");
                }
            } catch (InputMismatchException e) {
                System.out.println("변경 실패! (번호와 값을 제대로 입력하세요.)");
                sc.nextLine();
            } catch (IndexOutOfBoundsException e) {
                System.out.println("변경 실패! (목록에 없는 번호입니다.)");
            }

            // 결과값 삭제
            System.out.print("첫번째 결과값을 삭제하시겠습니까? (yes 입력 시 진행): ");
            String removeCheck = sc.next();
            if (removeCheck.equals("yes")) {
                calculator.removeResult();
                System.out.println("삭제 완료!");
            }

            // 입력값보다 큰 결과값 조회
            System.out.println("큰 결과값 조회");
            double wantNum = sc.nextDouble();
            List<Double> greaterList = calculator.getGreaterResult(wantNum);
            System.out.println(greaterList);

            // 반복문 종료 분기점
            System.out.print("더 계산하시겠습니까? (exit 입력 시 종료): ");
            String exitCheck = sc.next();
            if (exitCheck.equals("exit")) {
                System.out.println("계산기를 종료합니다.");
                break;
            }
        }

    }
}
