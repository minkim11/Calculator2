import java.util.ArrayList;

public class Calculator {
    // 연산 결과 저장하는 리스트
    private ArrayList<Double> resultList = new ArrayList<>();

    // 계산 메서드 (결과값 반환, 결과값 리스트에 추가)
    public <N extends Number>double calculate(N num1, N num2, char op) {
        // 산술연산을 위해 형변환
        double firstNum = num1.doubleValue();
        double secondNum = num2.doubleValue();
        // OperatorType (Enum) 메서드 사용
        double result = OperatorType.findOperator(op).cal(firstNum, secondNum);
        // 결과리스트에 추가 후 결과값 반환
        this.resultList.add(result);
        return result;
    }

    //Getter 메서드
    public ArrayList<Double> getResultList() {
        return this.resultList;
    }

    // Setter 메서드
    public void setResultList(int index, double changeResult) {
        this.resultList.set(index, changeResult);
    }

    // 가장 먼저 저장된 데이터 삭제 메서드
    public void removeResult() {
        this.resultList.remove(0);
    }

}
