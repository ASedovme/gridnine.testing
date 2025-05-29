import com.gridnine.testing.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, Flight!");

        List<Flight> flights = FlightBuilder.createFlights();

        System.out.println("Исходное количество перелётов: " + flights.size());

        // Фильтр по вылету до текущего времени
        System.out.println("\nПерелёты с вылетом до текущего времени:");
        List<Flight> filteredFlights1 = new DepartureBeforeNowFilter().filter(flights);
        printFlights(filteredFlights1);

        // Фильтр по некорректным датам сегментов
        System.out.println("\nПерелёты с некорректными датами сегментов:");
        List<Flight> filteredFlights2 = new SegmentsWithInvalidDatesFilter().filter(flights);
        printFlights(filteredFlights2);

        // Фильтр по времени на земле более двух часов
        System.out.println("\nПерелёты с временем на земле более двух часов:");
        List<Flight> filteredFlights3 = new GroundTimeExceedsTwoHoursFilter().filter(flights);
        printFlights(filteredFlights3);
    }

    private static void printFlights(List<Flight> flights) {
        if (flights.isEmpty()) {
            System.out.println("Нет подходящих перелётов.");
            return;
        }

        for (int i = 0; i < flights.size(); i++) {
            System.out.println("Перелёт " + (i + 1) + ":");
            for (Segment segment : flights.get(i).getSegments()) {
                System.out.println("  Вылет: " + segment.getDepartureDate());
                System.out.println("  Прилет: " + segment.getArrivalDate());
            }
            System.out.println();
        }
    }


}