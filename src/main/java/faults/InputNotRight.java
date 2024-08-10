package faults;

public class InputNotRight extends Exception {
    public InputNotRight(){}
    @Override
    public String toString() {return "Your data is not as same as the condition, please type again.";}
}
