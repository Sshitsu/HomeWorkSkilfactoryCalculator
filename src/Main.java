import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
            calculateWelcomeString();

            Scanner input = new Scanner(System.in);

            long result = getFirstNumber(input);

            while(true) {
                char operation = getOperation(input);

                if(operation == 's' || operation == 's') {
                    System.exit(0);
                }

                if(operation == 'c' || operation == 'c') {
                    result = 0;
                    System.out.println("Result is reset to 0");
                    result = getFirstNumber(input);
                    continue;
                }

                long nextNumber = getNumber(input);
                switch(operation) {
                    case '+' -> result += nextNumber;
                    case '-' -> result -= nextNumber;
                    case '*' -> result *= nextNumber;
                    case '/' -> {
                        if(nextNumber == 0){
                            invalidOperationWithZero();
                            nextNumber = getNumber(input);
                        }
                        result /= nextNumber;
                    }
                    default -> invalidOperation();
                }
                System.out.println("Result: " + result);
            }
        }


    private static long getNumber(Scanner input) {
        System.out.print("Enter number: ");
        while (true) {
            if (input.hasNextLong()) {
                return input.nextLong();
            } else {
                invalidOperation();
                input.next();
            }
        }
    }

    private static char getOperation(Scanner input){
        System.out.print("Enter operation: ");
        while (true) {
            String operation = input.next();
            if(operation.trim().length() > 1){
                invalidOperation();
                continue;
            }
            switch (operation.charAt(0)) {
                case '+', '/', '*', '-', 'c', 'C', 's', 'S' : return operation.charAt(0);
                default: {
                    invalidOperation();
                    input.next();
                }

            }

        }
    }

    private static long getFirstNumber(Scanner input) {
        long result;
        while (true) {
            System.out.println("Enter first number (or S to exit): ");
            String s = input.next().trim();
            if(s.equalsIgnoreCase("s")) {
                System.exit(0);
            }
            try {
                result = Long.parseLong(s);
                break;
            }catch(NumberFormatException e) {
                invalidOperation();
            }
        }
        return result;
    }

    private static void invalidOperation() {
        System.out.println("Invalid operation, please try again");
    }
    private static void invalidOperationWithZero() {
        System.out.println("Invalid operation with zero");
    }
    private static void calculateWelcomeString(){
        System.out.println("Welcome to the calculator console application");
        System.out.println("To reset calculator write: C or c ");
        System.out.println("To close calculator write: S or s");
    }

}




