package workshop.exercises;

import workshop.StreamSources;

public class Exercise1 {
    public static void main(String[] args) {

        // Use StreamSources.intNumbersStream() and StreamSources.userStream()

        // Print all numbers in the intNumbersStream stream
        //TODO: Write code here
        StreamSources.intNumbersStream().forEach(System.out::println);
        System.out.println("---------------------------------------");


        // Print numbers from intNumbersStream that are less than 5
        //TODO: Write code here
        StreamSources.intNumbersStream().filter(integer -> integer < 5).forEach(System.out::println);
        System.out.println("---------------------------------------");


        //Print the second and third numbers in intNumbersStream that's greater than 5
        //TODO: Write code here
        StreamSources.intNumbersStream().filter(integer -> integer > 5)
                //we skip the 0 from 0, 2,4
                .skip(1)
                //and we take last two elements after first element so those will be the second and the third
                .limit(2).forEach(System.out::println);
        System.out.println("---------------------------------------");


        // Print the first number in intNumbersStream that's greater than 5
        // If nothing is found, print -1
        //TODO: Write code here
        Integer result = StreamSources.intNumbersStream()
                .filter(integer -> integer > 5)
                .findFirst()
                .orElse(-1);
        System.out.println(result);
        System.out.println("---------------------------------------");


        // Print firstNames of all users in userStream
        //TODO: Write code here
        StreamSources.userStream()
                .map(user -> user.getName())
                .forEach(firstName -> System.out.println(firstName));
        System.out.println("---------------------------------------");


        //Combining 2 streams
        //Print surnames in userStream for all the users those have IDs from the numberSteam
        //TODO: Write code here

        //Bad way
        StreamSources.intNumbersStream()
                .flatMap(id -> StreamSources.userStream().filter(user -> user.getId() == id))
                .map(user -> user.getSurname())
                .forEach(surname -> System.out.println(surname));

        System.out.println("---------------------------------------");

        //Better way
        StreamSources.userStream()
                .filter(user -> StreamSources.intNumbersStream().anyMatch(id -> user.getId() == id))
                .map(user -> user.getSurname())
                .forEach(System.out::println);

    }
}
