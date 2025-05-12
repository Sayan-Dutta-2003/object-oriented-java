package NativeMethod;

public class NativeExample {
    // Declare a native method
    public native void printMessage();
    // Static block to load native library
    static {
        System.loadLibrary("NativeExample");
    }
    public static void main(String[] args) {
        new NativeExample().printMessage();
    }
}
