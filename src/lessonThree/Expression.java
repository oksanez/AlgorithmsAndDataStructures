package lessonThree;

public class Expression {
    private String expr;

    public Expression(String expr) { this.expr = expr; }

    public boolean checkBrackets() {
        MyArrayStack<Character> stack = new MyArrayStack<>();
        for (int i = 0; i < expr.length(); i++) {
            Character c = expr.charAt(i);
            if (c.equals('(') || c.equals('[') || c.equals('{')) {
                stack.push(c);
            }
            else if (c.equals(')') || c.equals(']') || c.equals('}')) {
                if (stack.isEmpty()) {
                    System.out.println("Error: in " + i + " position. Too many closed brackets.");
                    return false;
                }

                Character top = stack.pop();
                if (top.equals('(') && !c.equals(')') ||
                        top.equals('[') && !c.equals(']') ||
                        top.equals('{') && !c.equals('}')) {
                    System.out.println("Error: in " + i + " position. Brackets doesn't match.");
                    return false;
                }
            }
        }
        if (!stack.isEmpty()) {
            System.out.println("Error: too many opening brackets.");
        }
        return stack.isEmpty();
    }
}
