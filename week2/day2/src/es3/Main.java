package es3;

public class Main {
    public static void main(String[] args) {
        AddressBook addressBook = new AddressBook();
        addressBook.put("paolo", "3456789100");
        addressBook.put("maria", "3886739101");
        addressBook.put("arianna", "3886739334");
        System.out.println(addressBook);
        System.out.println(addressBook.getName("3456789100"));
        System.out.println(addressBook.getName("3886739101"));
        System.out.println(addressBook.getName("3886739334"));
        System.out.println(addressBook.getName("345789100"));
        System.out.println(addressBook.get("paolo"));
        System.out.println(addressBook.get("maria"));
        System.out.println(addressBook.get("arianna"));
        System.out.println(addressBook.get("miao"));
    }
}
