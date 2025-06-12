package LLD;
//Old legacy code
class OldPrinter {

    public void Oldprint()
    {
        System.out.println("Old printer printing text");
    }
}

interface Printable{
    public void print();
}

//Adapter class
class  PrinterAdapter implements Printable{
    private OldPrinter oldPrinter;
    public PrinterAdapter(OldPrinter printer) {
        this.oldPrinter = printer;
    }

    public void print()
    {
        oldPrinter.Oldprint();
    }
}
class NewPrinter implements Printable {
    @Override
    public void print() {
        System.out.println("New printer printing text");
    }
}
public class AdapterDesignPattern {
    public static void main(String[] args) {
        Printable oldprinter = new PrinterAdapter(new OldPrinter());
        Printable newPrinter = new NewPrinter();
        oldprinter.print();
        newPrinter.print();
    }
}
