import java.util.*;

public class Practice6 {

    static class Car {
        int arrival;
        int finishAt;

        public Car(int arrival) {
            this.arrival = arrival;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCaseCnt = sc.nextInt();
        for (int i = 0; i < testCaseCnt; i++) {
            Queue<Car> left = new LinkedList<>();
            Queue<Car> right = new LinkedList<>();

            int n = sc.nextInt();
            int t = sc.nextInt();
            int m = sc.nextInt();
            List<Car> cars = new ArrayList<>(m);
            for (int j = 1; j <= m; j++) {
                int arrived = sc.nextInt();
                String bank = sc.next();

                Car car = new Car(arrived);
                cars.add(car);
                if (bank.equals("left")) {
                    left.add(car);
                } else {
                    right.add(car);
                }
            }

            int curTime = 0;
            Queue<Car> curBank = left;
            while (!left.isEmpty() || !right.isEmpty()) {
                int nextTime;
                if (!left.isEmpty() && !right.isEmpty()) {
                    nextTime = Math.min(left.peek().arrival, right.peek().arrival);
                } else {
                    nextTime = (left.isEmpty() ? right.peek().arrival : left.peek().arrival);
                }

                curTime = Math.max(curTime, nextTime);
                int loadedCar = 0;
                while (!curBank.isEmpty()) {
                    Car car = curBank.peek();
                    if (car.arrival <= curTime && loadedCar < n) {
                        car.finishAt = curTime + t;
                        loadedCar++;
                        curBank.remove();
                    } else {
                        break;
                    }
                }

                curTime += t;
                curBank = curBank == left ? right : left;
            }

            for (Car car : cars) {
                System.out.println(car.finishAt);
            }

            if (i < testCaseCnt - 1) {
                System.out.println();
            }
        }
    }
}