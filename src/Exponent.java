public class Exponent {
    public class Main {
        public static void main(String[] args) {
            System.out.println(exp(2, -2));
        }

        static String exp(int a, int b)    // Метод возвращает результат возведения "a" в степень "b"
        {
            if(b == 0 && a == 0)
            {
                return "Не определено!";
            }
            else if (a != 0 && b == 0)
            {
                return "1";
            }
            else if (a > 0 && b > 0)
            {
                for (int i = 1; i < b; i++) {
                    a *= a;
                }
            }
            else if (a != 0 && b < 0)
            {
                return Double.toString(Math.pow(a, b));
            }
            return Integer.toString(a);
        }

        
    }

}
