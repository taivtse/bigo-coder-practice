import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static final int MAX = 10000 + 5;

    static class Car {
        int id, arriveTime;

        public Car(int _id, int _arriveTime) {
            this.id = _id;
            this.arriveTime = _arriveTime;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int Q = sc.nextInt();
        int res[] = new int[MAX];

        while (Q-- > 0) {
            Queue<Car> left = new LinkedList<>();
            Queue<Car> right = new LinkedList<>();

            int n = sc.nextInt();
            int t = sc.nextInt();
            int m = sc.nextInt();

            for (int i = 1; i <= m; i++) {
                int arrived = sc.nextInt();
                String bank = sc.next();

                if (bank.equals("left")) {
                    left.add(new Car(i, arrived));
                } else {
                    right.add(new Car(i, arrived));
                }
            }

            int curTime = 0, nextTime;
            int waiting = (!left.isEmpty() ? 1 : 0) + (!right.isEmpty() ? 1 : 0);
            Queue<Car> curBank = left;
            while (!left.isEmpty() || !right.isEmpty()) {
                if (waiting == 1) {
                    nextTime = (left.isEmpty() ? right.peek().arriveTime : left.peek().arriveTime);
                } else {
                    nextTime = Math.min(left.peek().arriveTime, right.peek().arriveTime);
                }

                curTime = Math.max(curTime, nextTime);
                int loadedCar = 0;
                while (!curBank.isEmpty()) {
                    Car car = curBank.peek();
                    if (car.arriveTime <= curTime && loadedCar < n) {
                        res[car.id] = curTime + t;
                        loadedCar++;
                        curBank.remove();
                    } else {
                        break;
                    }
                }

                curTime += t;
                curBank = curBank == left ? right : left;
                waiting = (!left.isEmpty() ? 1 : 0) + (!right.isEmpty() ? 1 : 0);
            }

            for (int i = 1; i <= m; i++) {
                System.out.println(res[i]);
            }

            if (Q > 0) {
                System.out.println();
            }
        }
    }
}