import java.util.*;

public class Practice6FerryLoadingIII {
    private static class Car {
        public Integer arrival;
        public Integer finishAt;

        public Car(Integer arrival) {
            this.arrival = arrival;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCount = scanner.nextInt();
        for (int i = 0; i < testCount; i++) {
            handleTestCase(scanner);
            if (i < testCount - 1) {
                System.out.println();
            }
        }
    }

    private static void handleTestCase(Scanner scanner) {
        int n = scanner.nextInt();
        int t = scanner.nextInt();
        int m = scanner.nextInt();
        List<Car> cars = new ArrayList<>();
        Queue<Car> left = new LinkedList<>();
        Queue<Car> right = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            int time = scanner.nextInt();
            String bank = scanner.next();
            Car car = new Car(time);
            if (bank.equals("left")) {
                left.add(car);
            } else {
                right.add(car);
            }
            cars.add(car);
        }

        transport(left, right, n, t, 0);

        for (Car car : cars) {
            System.out.println(car.finishAt);
        }
    }

    private static int transport(Queue<Car> currentBank, Queue<Car> oppositeBank, int n, int t, int now) {
        if (currentBank.isEmpty()) {
            if (oppositeBank.isEmpty()) {
                return 0;
            }
            return transport(oppositeBank, currentBank, n, t, now + t);
        }

        int loadedCar = 0;
        Car curCar = currentBank.peek();
        while (curCar.arrival <= now && loadedCar < n) {
            currentBank.poll();
            loadedCar++;
            curCar.finishAt = now + t;
            if (currentBank.isEmpty()) {
                break;
            }
            curCar = currentBank.peek();
        }
        if (loadedCar != 0) {
            return transport(oppositeBank, currentBank, n, t, now + t);
        }

        Car opsCar = null;
        if (!oppositeBank.isEmpty()) {
            opsCar = oppositeBank.peek();
        }

        if (opsCar == null || curCar.arrival <= opsCar.arrival) {
            return transport(currentBank, oppositeBank, n, t, curCar.arrival);
        } else {
            return transport(oppositeBank, currentBank, n, t, opsCar.arrival + t);
        }
    }
}
