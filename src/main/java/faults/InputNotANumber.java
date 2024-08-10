package faults;

public class InputNotANumber extends Exception {
    public InputNotANumber() {}
    @Override
    public String toString() {return "The ID is illegal.";}
}
