import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Calculator {
    // 연산 결과 저장하는 리스트
    private List<Double> resultList = new ArrayList<>();

    // 계산 메서드 (결과값 반환, 결과값 리스트에 추가)
    // 제네릭 사용, 문제 의도에 맞게 한건지 잘 모르겠습니다ㅠ
    public <N extends Number>double calculate(N num1, N num2, char op) {
        // 산술연산을 위해 Number 메서드 사용하여 형변환
        double firstNum = num1.doubleValue();
        double secondNum = num2.doubleValue();
        // OperatorType (Enum) 메서드 사용
        double result = OperatorType.findOperator(op).cal(firstNum, secondNum);
        // 결과리스트에 추가 후 결과값 반환
        this.resultList.add(result);
        return result;
    }

    //Getter 메서드
    public List<Double> getResultList() {
        return this.resultList;
    }

    // Setter 메서드 (인덱스 번호 입력받고 해당 인덱스 연산결과 수정)
    public void setResultList(int index, double changeResult) {
        // 인덱스 예외 방지
        if (index < 0 || resultList.size() - 1 < index) {
            System.out.println("변경실패! (목록에 없는 번호! 범위 : 0 ~ " + (resultList.size() - 1) + ")");
        } else {
            this.resultList.set(index, changeResult);
            System.out.println("변경완료!");
        }
    }

    // 가장 먼저 저장된 데이터 삭제 메서드
    public void removeResult() {
        this.resultList.remove(0);
    }

    // 입력값보다 큰 결과값 조회 메서드, 람다 스트림 사용
    public void getGreaterResult(double num) {
        List<Double> greaterList = this.resultList.stream()
                .filter(result -> result > num)
                .collect(Collectors.toList());
        System.out.println(greaterList);
    }

}
