import java.util.Iterator;
import java.util.Stack;

public class Freezer {
    Stack<IceCreamTub> tubStack;

    public Freezer() {
        tubStack = new Stack<>(); // Creating a new stack
    }
    
    public void pushIceCreamTub(IceCreamTub tub) {
        tubStack.push(tub);
    }

    public void showContents() {
        System.out.println("\n\tContents of the stack");	
        System.out.println("\t======================");	
        Iterator<IceCreamTub> iter = tubStack.iterator();
        
        while(iter.hasNext()) {
            IceCreamTub tub = (IceCreamTub) iter.next();
            System.out.println("\t" + tub.getFlavor() + " ; " + tub.getExpiryDate().toString());  	  
        }
    }
    
    /*
     * Sort stack using temporary stack
     * Source code: https://www.geeksforgeeks.org/dsa/sort-stack-using-temporary-stack/ 
    */
    public Stack<IceCreamTub> sortStack(Stack<IceCreamTub> input) {
        Stack<IceCreamTub> tmpStack = new Stack<IceCreamTub>(); // Temporary ice cream tub stack
        
        // Run over the inputStack while the bottom hasn't been reached
        while(!input.isEmpty())
        {
            IceCreamTub tmp = input.pop(); // Pop out first tub
        
            // Run over tmpStack while bottom hasn't been reached AND expiry date of [tmpStack's top tub] is earlier than [tmp's] expiry date
            while(!tmpStack.isEmpty() && tmpStack.peek().getExpiryDate().compareTo(tmp.getExpiryDate()) > 0)
            {
                input.push(tmpStack.pop()); // Pop from tmpStack, push to inputStack
            }
            
            // Push tmp in temporary stack only after tmpStack loop
            tmpStack.push(tmp);
        }
        return tmpStack;
    }

    public void sortTubStack() {
        tubStack = sortStack(tubStack);
        showContents();
    }
}

