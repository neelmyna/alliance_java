public static void main(String[] args) {
		for(int i = 0; i < args.length; i++) {
			System.out.print(args[i] + "   ");
		}
		System.out.println(args[0] instanceof String);
		// System.out.println(Integer.parseInt(args[1]) instanceof String); We cannot compare unrelated Types
	}
}