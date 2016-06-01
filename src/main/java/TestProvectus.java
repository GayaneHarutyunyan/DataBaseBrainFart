    import java.io.Serializable;

    /**
     * 3)Напишите программу, которая выводит на экран числа от 1 до 100. При этом вместо чисел,
     * кратных трем, программа должна выводить слово Fizz, а вместо чисел, кратных пяти — слово Buzz.
     * Если число кратно пятнадцати, то программа должна выводить слово FizzBuzz.
     * Задача может показаться очевидной, но нужно получить наиболее простое и красивое решение.
     */
  public class TestProvectus {

        public static void main(String[] args) {

            for (int i = 1; i <= 100; i++) {
                if (i % 15 == 0) {
                    System.out.println("FizzBuzz ");
                } else {
                    Serializable a = i % 5 == 0 ? "Buzz " : i % 3 == 0 ? "Fizz " : i;
                    System.out.println(a);

                }
            }
        }
    }
/**
 * 1. Мастеру дали восемь цепей по 6 звеньев в каждой.
 * Его попросили соединить их в одну непрерывную цепь.
 * Он выполнил просьбу, при этом он разъединил и обратно соединил всего 6 звеньев.
 * Как ему это удалось?
 * <p>
 * Ответ
 * Для соединения 8 цепей нужно делать 7 ходов, то есть 7 раз разъединить и соединить звено.
 * Но наш мастер хитрый и место 7 шагов он на это потратил 6.
 * Мастер взял один обрывок цепи разъединил и получил 6 звена.
 * Этими 6 звеньями он соединил затем 7 оставшихся обрывки в одну цепь
 * _1_2_3_4_5_6_     _
 */

/**
 * Какое число в шестнадцатеричной системе идет после F?
 * 0-9, A,B,C,D,E,F  F последняя цифра (1111) имеет значение 15d.

 */

