//Здесь будут отрабатываться циклы

void main() {

    int i;
    int j = 5;
    int count = 1;
    String[] daysOfWeek = {"Понедельник", "Вторник", "Среда", "Четверг", "Пятница", "Суббота", "Воскресенье"};

    for (i = 0; i <= 5; i++) {
        System.out.println("Переменная i = " + i);
    }
    System.out.println("\n");

    while (j >= 0) {
        System.out.println("Переменная j =  " + j);
        j--;
    }
    System.out.println("\n");

    for (String dw : daysOfWeek) {
        System.out.println("Дни недели: " + dw);
    }
    System.out.println("\n");

    do {
        System.out.println("Переменная count =  " + count);
        count++;
    } while (count <= 5);
}