/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject5;

import java.util.Random;

/**
 *
 * @author Rümeysa
 */
public class TombolaCard {
        public static void main(String[] args) {
        TombolaCard tombolaCard = new TombolaCard();
        
        LinkedList<Integer> randomNumbers = tombolaCard.generateRandom();
        System.out.println("Random Numbers:");
        randomNumbers.print();
        LinkedList<Integer> sortedCard = tombolaCard.sortCard(randomNumbers);
        System.out.println("\nSorted Card:");
        sortedCard.print();
        
        }
    
    

    public static LinkedList<Integer> sortCard(LinkedList<Integer> list) {
        LinkedList<Integer> sorted = new LinkedList<>();

        for (int i = 8; i >= 0; i--) {
            LinkedList<Integer> triple = getApron(list, i);
            if (triple.size() == 3) {
                for (int j = 0; j < 3; j++) {
                    list.removeWithData(triple.get(j));
                    list.addFirst(triple.get(j));
                }
            }
        }

        System.out.println("List:");
        list.print();

        int listIndex = 0;
        int columnIndex = 0;
        int row = 0;
        while (sorted.size() < 15) {
            System.out.println("\nList:");
            list.print();
            System.out.println("List index: " + listIndex);
            System.out.println("Column index: " + columnIndex);
            System.out.println("Sorted:");
            for (int i = 0; i < sorted.size(); i++) {
                System.out.print(sorted.getFromChild(i) + ", ");
            }
            System.out.println("");

            if (columnIndex == 0) {
                sorted.addToIndex(row * 5, list.get(listIndex));
                list.removeWithData(list.get(listIndex));
                columnIndex++;
                continue;
            }

            int listNumApron = list.get(listIndex) / 10;
            boolean skip = false;
            for (int i = row * 5; i < columnIndex + (row * 5); i++) {
                if (listNumApron == sorted.getFromChild(i) / 10) {
                    skip = true;
                    listIndex++;
                    break;
                } else if (listNumApron < sorted.getFromChild(i) / 10) {
                    sorted.addToIndex(i, list.get(listIndex));
                    list.removeWithData(list.get(listIndex));
                    columnIndex++;
                    skip = true;
                    break;
                }
            }

            if (!skip) {
                sorted.addToIndex(columnIndex + (row * 5), list.get(listIndex));
                list.removeWithData(list.get(listIndex));
                columnIndex++;
            }

            if (columnIndex == 5) {
                columnIndex = 0;
                listIndex = 0;
                row++;
            }
        }

        System.out.println("\nList:");
        list.print();
        System.out.println("List index: " + listIndex);
        System.out.println("Column index: " + columnIndex);
        System.out.println("Sorted:");
        for (int i = 0; i < sorted.size(); i++) {
            System.out.print(sorted.getFromChild(i) + ", ");
        }
        System.out.println("");

        return sorted;
    }

    public static LinkedList<Integer> generateRandom() {
        LinkedList<Integer> result = new LinkedList<>();

        Random random = new Random();
        
        int generatedNumberCount = 0;
        while (generatedNumberCount < 15) {
            int randomNum = random.nextInt(1, 90);
            if (isExists(result, randomNum)) {
                continue;
            }
            if (isTriple(result, randomNum)) {
                continue;
            }

            result.addLast(randomNum);
            generatedNumberCount++;
        }

        return result;
    }
    
    public static LinkedList<Integer> takenRandomNumbers() {
        LinkedList<Integer> numbers = new LinkedList<>();
        
        Random random = new Random();
        
        int count=0;
        while(count<90){
            int randomNumber = random.nextInt(1, 90);
            if (isExists(numbers, randomNumber)) {
                continue;
            }
            numbers.addFirst(randomNumber);
            count++;
        }
        
        return numbers;
        
    }

    public static boolean isTriple(LinkedList<Integer> list, int checkNum) {
        Node<Integer> temp = list.head;
        int apron = checkNum / 10;
        int counter = 0;
        while (temp != null) {

            int tempApron = temp.data / 10;
            if (tempApron == apron) {
                counter++;
            }

            if (temp.next == null) {
                temp = temp.child;
            } else if (temp.child == null) {
                temp = temp.next;
            }

            //temp = (temp.next == null) ? temp.child: temp.next;
        }

        return (counter >= 3);
    }

    public static  LinkedList<Integer> getApron(LinkedList<Integer> list, int apron) {
        LinkedList<Integer> triple = new LinkedList<>();

        Node<Integer> temp = list.head;
        int counter = 0;
        while (temp != null) {

            int tempApron = temp.data / 10;
            if (tempApron == apron) {
                counter++;
                triple.addFirst(temp.data);
            }

            if (temp.next == null) {
                temp = temp.child;
            } else if (temp.child == null) {
                temp = temp.next;
            }

            //temp = (temp.next == null) ? temp.child: temp.next;
        }

        return triple;
    }

    public static boolean isExists(LinkedList<Integer> list, int checkNum) {

        Node<Integer> temp = list.head;
        while (temp != null) {
            if (temp.data == checkNum) {
                return true;
            }

            if (temp.next == null) {
                temp = temp.child;
            } else if (temp.child == null) {
                temp = temp.next;
            }

            //temp = (temp.next == null) ? temp.child: temp.next;
        }

        return false;
    }
    
    public static boolean check(LinkedList<Integer> list, int checkNum) {

        Node<Integer> temp = list.head;
        while (temp != null) {
            if (temp.data == checkNum) {
                return false;
            }else{
                temp=temp.next;
            }
        }
        return true;
    }
    
    
}


