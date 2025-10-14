//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

void main() {

    for (int i = 1; i <= 5; i++)
    {
         IO.println("i = " + i);
    }

    // prints out Hello world
    System.out.println("Hello world");

    Scanner scanner = new Scanner(System.in);
    System.out.println("What is your name?");
    String name = scanner.nextLine();

    System.out.println("Hello " + name);
}
