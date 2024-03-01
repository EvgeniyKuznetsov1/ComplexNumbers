import java.util.*;
import static java.lang.Math.*;

class ComplexNumber {
    public double realNumber;
    public double imaginaryNumber;
    public double fi;
    public double r;
    ComplexNumber(double realNumber, double imaginaryNumber){
        this.realNumber = realNumber;
        this.imaginaryNumber = imaginaryNumber;

        r = sqrt( pow(realNumber, 2) + pow(imaginaryNumber, 2) );

        if(realNumber != 0)
            fi = atan(imaginaryNumber / realNumber);
        else
            fi = asin(imaginaryNumber / r);
    }
}

class Program{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Ввод 1-го комплексного числа\n    Действительная часть: ");
        double realNumber = input.nextDouble();
        System.out.print("    Мнимая часть: ");
        double imaginaryNumber = input.nextDouble();
        ComplexNumber number1 = new ComplexNumber(realNumber, imaginaryNumber);

        System.out.print("Ввод 2-го комплексного числа\n    Действительная часть: ");
        realNumber = input.nextDouble();
        System.out.print("    Мнимая часть: ");
        imaginaryNumber = input.nextDouble();
        ComplexNumber number2 = new ComplexNumber(realNumber, imaginaryNumber);

        System.out.println();
        sumComplexNumber(number1, number2);
        subComplexNumber(number1, number2);
        divComplexNumber(number1, number2);
        mulComplexNumber(number1, number2);
        powComplexNumber(number1, number2);
    }

    public static void sumComplexNumber(ComplexNumber number1, ComplexNumber number2){
        double realPart = number1.realNumber + number2.realNumber;
        double imaginaryPart = number1.imaginaryNumber + number2.imaginaryNumber;

        if(imaginaryPart > 0)
            System.out.printf("Сумма комлексных чисел: %.2f+%.2fi", realPart, imaginaryPart);
        else
            System.out.printf("Сумма комлексных чисел: %.2f%.2fi", realPart, imaginaryPart);

        System.out.println();
        System.out.println();
    }

    public static void subComplexNumber(ComplexNumber number1, ComplexNumber number2){
        double realPart = number1.realNumber - number2.realNumber;
        double imaginaryPart = number1.imaginaryNumber - number2.imaginaryNumber;

        if(imaginaryPart > 0)
            System.out.printf("Вычитание комлексных чисел: %.2f+%.2fi", realPart, imaginaryPart);
        else
            System.out.printf("Вычитание комлексных чисел: %.2f%.2fi", realPart, imaginaryPart);

        System.out.println();
        System.out.println();
    }

    public static void divComplexNumber(ComplexNumber number1, ComplexNumber number2){
        double r1 = number1.r;
        double r2 = number2.r;
        double fi1 = number1.fi;
        double fi2 = number2.fi;

        double result = r1/r2 * (cos(fi1 - fi2) + sin(fi1 - fi2) );
        if(sin(fi1 - fi2) == 0)
            System.out.printf("Деление комплексных чисел: %.2f", result);
        else
            System.out.printf("Деление комплексных чисел: %.2fi", result);

        System.out.printf("\n    Тригонометрическая форма: %.2f(cos(%.2f) + isin(%.2f))",
                r1 / r2, fi1 - fi2, fi1 - fi2);

        System.out.println();
        System.out.println();
    }

    public static void mulComplexNumber(ComplexNumber number1, ComplexNumber number2){
        double r1 = number1.r;
        double r2 = number2.r;
        double fi1 = number1.fi;
        double fi2 = number2.fi;

        double result = r1*r2 * (cos(fi1 + fi2) + sin(fi1 + fi2) );

        if(sin(fi1 + fi2) == 0)
            System.out.printf("Умножение комплексных чисел: %.2f", result);
        else
            System.out.printf("Умножение комплексных чисел: %.2fi", result);

        System.out.printf("\n    Тригонометрическая форма: %.2f(cos(%.2f) + isin(%.2f))",
                r1 * r2, fi1 + fi2, fi1 + fi2);

        System.out.println();
        System.out.println();
    }
    
    public static void powComplexNumber(ComplexNumber number1, ComplexNumber number2){
        double r1 = number1.r;
        double r2 = number2.r;
        double fi1 = number1.fi;
        double fi2 = number2.fi;

        Scanner input = new Scanner(System.in);
        System.out.print("Введите степень: ");
        int n = input.nextInt();
        
        double result1 = pow(r1, n) * (cos(n * fi1) + sin(n * fi1) );
        double result2 = pow(r2, n) * (cos(n * fi2) + sin(n * fi2) );

        System.out.printf("1-е комплексное число в степени %d: %.2fi", n, result1);
        System.out.printf("\n    Тригонометрическая форма: %.2f(cos(%.2f) + isin(%.2f))",
                pow(r1, n), n * fi1, n * fi1);
        System.out.println();

        System.out.printf("2-е комплексное число в степени %d: %.2fi", n, result2);
        System.out.printf("\n    Тригонометрическая форма: %.2f(cos(%.2f) + isin(%.2f))",
                pow(r2, n), n * fi2, n * fi2);

        System.out.println();
        System.out.println();

        
    }
}