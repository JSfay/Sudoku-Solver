
public class Main {

	public static void main(String[] args) {
		
		 Constraint constraint = new Constraint();

	        Input input = new Input(constraint);
	        input.scanner();

	        Run run = new Run(constraint);

	        System.out.println();
	        System.out.println();
	        System.out.println("Finished: ");

	        run.recur(0, 0);
		
	}
	
	
	
}
