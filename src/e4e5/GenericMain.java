package e4e5;

public class GenericMain {

    public static void main(String[] args) {
        GenericLinkedQueue<String> durr = new GenericLinkedQueue<String>();

        durr.enqueue("asd");
        System.out.println(durr.toString());

        System.out.println(durr.last());
        System.out.println(durr.first());
        durr.enqueue("dsa");

        System.out.println(durr.last());
        durr.enqueue("sa");

        System.out.println(durr.toString());
        durr.enqueue("ds");

        System.out.println(durr.toString());
        System.out.println(durr.dequeue());
        System.out.println(durr.dequeue());
        System.out.println(durr.dequeue());
        System.out.println(durr.dequeue());
        System.out.println(durr.dequeue());

    }

}
