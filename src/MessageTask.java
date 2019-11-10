//package lesson11.task;

//import sun.plugin2.message.Message;

import java.lang.reflect.Array;
import java.util.*;

public class MessageTask {
    public static void countEachPriority(List<Message> messageList) {

        int counterLOW = 0;
        int counterMEDIUM = 0;
        int counterHIGH = 0;
        int counterURGENT = 0;

        for (int i = 0; i < messageList.size(); i++) {
        if (messageList.get(i).getPriority() == MessagePriority.LOW) {
            counterLOW++;
        } else if (messageList.get(i).getPriority() == MessagePriority.MEDIUM) {
            counterMEDIUM++;
        } else if (messageList.get(i).getPriority() == MessagePriority.HIGH) {
            counterHIGH++;
        } else {counterURGENT++;}
        }

        System.out.println("\n");
        System.out.printf(  "The number of Messages with LOW priority:    %d\n" +
                            "The number of Messages with MEDIUM priority: %d\n" +
                            "The number of Messages with HIGH priority:   %d\n" +
                            "The number of Messages with URGENT priority: %d\n", counterLOW, counterMEDIUM, counterHIGH, counterURGENT );

        // TODO:  Подсчитать количество сообщений для каждого приоритела
        //  Ответ в консоль
    }

    public static void countEachCode(List<Message> messageList) {

        Integer [] maxCode = new Integer [messageList.size()];
        for (int i = 0; i < messageList.size(); i++) {
        maxCode[i] = messageList.get(i).getCode();
        }
        Arrays.sort(maxCode, Collections.reverseOrder());
        int takeCodeFromList = maxCode[0];

        int counterCode = 0;
        for (int j = takeCodeFromList; j >= 0; j--) {

            for (int i = 0; i < messageList.size(); i++) {
                if (j == messageList.get(i).getCode()) {counterCode++;}
            }

            System.out.printf("\nThe number of Messages with code %d: %d", j, counterCode);
            counterCode = 0;
        }

        // TODO: Подсчитать количество сообщений для каждого кода сообщения
        //  Ответ в консоль
    }

    public static void uniqueMessageCount(List<Message> messageList) {
        System.out.println("\n");

        int counterLOW = 0;
        int counterMEDIUM = 0;
        int counterHIGH = 0;
        int counterURGENT = 0;


        Integer [] maxCode = new Integer [messageList.size()];
        for (int i = 0; i < messageList.size(); i++) {
            maxCode[i] = messageList.get(i).getCode();
        }
        Arrays.sort(maxCode, Collections.reverseOrder());
        int takeCodeFromList = maxCode[0];

        for (int j = takeCodeFromList; j >= 0; j--) {

            for (int i = 0; i < messageList.size(); i++) {

                if (j == messageList.get(i).getCode()) {

                    if (messageList.get(i).getPriority() == MessagePriority.LOW) {
                        counterLOW++;
                    } else if (messageList.get(i).getPriority() == MessagePriority.MEDIUM) {
                        counterMEDIUM++;
                    } else if (messageList.get(i).getPriority() == MessagePriority.HIGH) {
                        counterHIGH++;
                    } else {counterURGENT++;}
                }
            }

            System.out.printf(
                    "The number of Messages with code %d and LOW priority:    %d\n" +
                    "The number of Messages with code %d and MEDIUM priority: %d\n" +
                    "The number of Messages with code %d and HIGH priority:   %d\n" +
                    "The number of Messages with code %d and URGENT priority: %d\n", j, counterLOW, j, counterMEDIUM, j, counterHIGH, j, counterURGENT );

            counterLOW = 0;
            counterMEDIUM = 0;
            counterHIGH = 0;
            counterURGENT = 0;
        }

        // TODO: Подсчитать количество уникальных сообщений
        //  Ответ в консоль
    }

    static void uniqueMessagesInOriginalOrder(List<Message> messageList){

        List<Message> uniqueMessagesOnly = new ArrayList<>(messageList.size());
        uniqueMessagesOnly.addAll(messageList);
        int counter = 0;
        int getCurrentCode;
        MessagePriority getCurrentPriority;

        Iterator <Message> messageIterator;
        messageIterator = uniqueMessagesOnly.iterator();

        int i = 0;
        while (i < uniqueMessagesOnly.size()) {

            getCurrentCode = uniqueMessagesOnly.get(i).getCode();
            getCurrentPriority = uniqueMessagesOnly.get(i).getPriority();

            while (messageIterator.hasNext()) {
                if (messageIterator.next().getPriority() == getCurrentPriority && messageIterator.next().getCode() == getCurrentCode) {
                    messageIterator.remove();
                    counter++;
                }

            }

        i++;

        }
        // TODO: вернуть только неповторяющиеся сообщения и в том порядке,
        //  в котором они встретились в первоначальном списке
        //  Например, было: [{URGENT, 4}, {HIGH, 9}, {LOW, 3}, {HIGH, 9}]
        //  на выходе: [{URGENT, 4}, {HIGH, 9}, {LOW, 3}]

        System.out.println("\n\nOnly original Messages from the basic list:");
        System.out.println(uniqueMessagesOnly);
        System.out.printf("%d repeated Messages have been deleted from the basic list\n", counter);
    }

    static void removeEach(List<Message> messageList, MessagePriority priority) {

        List<Message> someMessagesOnly = new ArrayList<>(messageList.size());
        someMessagesOnly.addAll(messageList);
        int counterDel = 0;

        Iterator <Message> messageIterator = someMessagesOnly.iterator();

       while (messageIterator.hasNext()) {
           if (messageIterator.next().getPriority() == priority) {
                messageIterator.remove();
               counterDel++;
           }
       }

        System.out.printf("\nThe list of Messages (except %s priority):\n", priority.toString());
        System.out.println(someMessagesOnly);
        System.out.printf("%d Messages with %s priority have been deleted from the basic list\n", counterDel, priority.toString());
    }

    // TODO: удалить из коллекции каждое сообщение с заданным приоритетом
    //  вывод в консоль до удаления и после удаления

    public static void removeOther(List<Message> messageList, MessagePriority priority){

        List<Message> removeMessages = new ArrayList<>(messageList.size());
        removeMessages.addAll(messageList);
        int counterDel = 0;

        Iterator <Message> messageIterator = removeMessages.iterator();

        while (messageIterator.hasNext()) {
            if (messageIterator.next().getPriority() != priority) {
                messageIterator.remove();
                counterDel++;
            }
        }

        System.out.printf("\nThe list of Messages with only %s priority:\n", priority.toString());
        System.out.println(removeMessages);
        System.out.printf("%d Messages (except %s priority) have been deleted from the basic list\n", counterDel, priority.toString());

        // TODO: удалить из коллекции все сообщения, кроме тех, которые имеют заданный приоритет
        // вывод в консоль до удаления и после удаления
    }

    public static void main(String[] args) {
        // вызов методов
    }


}