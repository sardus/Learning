//Здесь будут отрабатываться условия

void main() {
    Scanner sc = new Scanner(System.in);

    int age = sc.nextInt();


    if(age < 14){
        System.out.println("Вы еще ребенок и вам без родителей нельзя!");
    } else if(age < 18){
        System.out.println("Вам от 14 до 18, вам уже не нужно идти с родителями, но еще желательно.");
    } else {
        System.out.println("Вам уже 18 или более - выможете спокойно проходить!");
    }




    switch (age) {
        case 23:
            System.out.println("Вам уже 18 или более - выможете спокойно проходить!");
            break;
        case 15:
            System.out.println("Вам от 14 до 18, вам уже не нужно идти с родителями, но еще желательно.");
            break;
        case 10:
            System.out.println("Вы еще ребенок и вам без родителей нельзя!");
            break;
        default:
            System.out.println("just another variant...");
    }
}
