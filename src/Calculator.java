import java.util.ArrayList;

public class Calculator {
    // 연산 결과 저장하는 리스트
    private ArrayList<Double> resultList = new ArrayList<>();

    // 계산 메서드 (결과값 반환, 결과값 리스트에 추가)
    public double calculate(int num1, int num2, char op) {
        // 결과값 담을 변수 선언
        double result = 0;
        // 연산자 별 계산 기능
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
            case '/':
                result = num1 / (double)num2;
                break;
        }
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
