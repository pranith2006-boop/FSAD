class Bank {
    double getRateOfInterest() {
        return 0.0;
    }
}

class SBI extends Bank {
    @Override
    double getRateOfInterest() {
        return 8.4;
    }
}

class HDFC extends Bank {
    @Override
    double getRateOfInterest() {
        return 7.3;
    }
}

public class Question2 {
    public static void main(String[] args) {
        Bank myBank;

        myBank = new SBI();
        System.out.println("SBI Rate of Interest: " + myBank.getRateOfInterest() + "%");

        myBank = new HDFC();
        System.out.println("HDFC Rate of Interest: " + myBank.getRateOfInterest() + "%");
    }
}