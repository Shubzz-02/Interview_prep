import java.math.BigInteger;

class MultiplyStrings {
    public static void main(String[] args) {
        System.out.println(new SolutionMS().multiply("46451865345555556666666666666666666666622222222222222222222222222222211111111111111111111111111111111416489451", "741852963741852963741"));
    }
}

class SolutionMS {
    public String multiply(String num1, String num2) {
        return new BigInteger(num1).multiply(new BigInteger(num2)).toString();
    }
}
