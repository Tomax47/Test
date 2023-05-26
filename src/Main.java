import java.io.*;

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList<Child> children = new DoublyLinkedList<>();

        Child child1 = new Child("Alice", 120.0, 30.0, 5);
        Child child2 = new Child("Bob", 110.0, 25.0, 6);
        Child child3 = new Child("Charlie", 130.0, 35.0, 4);

        children.add(child1);
        children.add(child2);
        children.add(child3);

        //Display the children
        children.display();
        System.out.println("\nAdding a new child after another : ");

        Child newChild = new Child("Dave", 115.0, 28.0, 7);
        children.insertAfter(child2, newChild);

        children.display();

        System.out.println("\nRemoving the child1 : ");
        children.remove(child1);

        children.display();

        System.out.println("\nSorting the children : ");
        children.sort();

        children.display();


        System.out.println("\n\n{{ The second required part }}");
        DoublyLinkedList<Child> children2 = new DoublyLinkedList<>();

        Child[] ch = {
                new Child("Вася", 1.20, 19, 6),
                new Child("Петя", 1.15, 17, 5),
                new Child("Коля", 1.27, 25, 7),
                new Child("Толя", 1.30, 29, 8)
        };

        children2.fromArray(ch);

        //Reading data from a file
        System.out.println("\nReading the file's children's data : ");
        String inputFilename = "D:\\Java Projects\\Kontrolnaya\\src\\input.txt";
        readFromFile(children2, inputFilename);

        //Sorting the list
        children2.sort();
        children2.display();

        System.out.println("\nRemoving every second child : ");
        removeEverySecondElement(children2);
        children2.display();

        System.out.println("\nWriting the list to the file output.txt => ");
        String outputFilename = "D:\\Java Projects\\Kontrolnaya\\src\\output.txt";
        writeToFile(children2, outputFilename);
    }

    private static void readFromFile(DoublyLinkedList<Child> children, String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                if (data.length == 4) {
                    String name = data[0].trim();
                    double height = Double.parseDouble(data[1].trim());
                    double weight = Double.parseDouble(data[2].trim());
                    int age = Integer.parseInt(data[3].trim());

                    Child child = new Child(name, height, weight, age);
                    children.add(child);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //Remove each 2nd element
    private static void removeEverySecondElement(DoublyLinkedList<Child> children) {
        DoublyLinkedList.Node<Child> currentNode = children.getHead();

        while (currentNode != null) {
            DoublyLinkedList.Node<Child> nextNode = currentNode.next;

            if (nextNode != null) {
                children.remove(nextNode.data);
            }

            currentNode = currentNode.next;
        }
    }

    //Outputting to a file
    private static void writeToFile(DoublyLinkedList<Child> children, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            DoublyLinkedList.Node<Child> currentNode = children.getHead();

            while (currentNode != null) {
                writer.write(currentNode.data.getName() + "," +
                        currentNode.data.getHeight() + "," +
                        currentNode.data.getWeight() + "," +
                        currentNode.data.getAge());
                writer.newLine();

                currentNode = currentNode.next;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
