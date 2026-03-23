public enum OperatorType implements Cal{
    // 인터페이스 오버라이딩하여 상수마다 계산 메서드
    ADD('+', "➕") {
        @Override
        public double cal(double num1, double num2) {
            return num1 + num2;
        }
    },
    SUB('-', "➖") {
        @Override
        public double cal(double num1, double num2) {
            return num1 - num2;
        }
    },
    MUL('*', "✖") {
        @Override
        public double cal(double num1, double num2) {
            return num1 * num2;
        }
    },
    DIV('/', "➗") {
        @Override
        public double cal(double num1, double num2) {
            return num1 / num2;
        }
    };

    // 속성
    private final char op;
    private final String op2;

    // 생성자
    OperatorType(char op, String op2) {
        this.op = op;
        this.op2 = op2;
    }

    // 연산자 반환 메서드
    public static OperatorType findOperator(char operator) {
        // values로 상수 배열 생성 후 반복문
        for (OperatorType op : OperatorType.values()) {
            // 입력된 연산자가 상수의 값과 같은지 확인 후 반환
            // char + "" = String
            if (op.getOp() == operator || op.getOp2().equals(operator + "")) {
                return op;
            }
        }
        return null;
    }

    // Getter 메서드
    public char getOp() {
        return op;
    }
    public String getOp2() {
        return op2;
    }
}
