package day4and5;

class A extends Object {
	A() {
		System.out.println("From Zero Arg cons of A"); }
	A(int num) {
		System.out.println("From param cons of A " + num); }
	A(String X) {
		System.out.println("From param cons of A " + X); }
}
class B extends A {
	B() {
		this(50);
		System.out.println("From Zero Arg cons of B"); }
	B(int num) {
		super("Alliance");
		System.out.println("From param cons of B " + num); }
}
class C extends B {
	C() {
		super();
		System.out.println("From Zero Arg cons of C"); }
	C(int num) {
		super();
		System.out.println("From param cons of C " + num); }
}
public class Demo {
	public static void main(String[] args) {
		C c = new C(100);
	}
}