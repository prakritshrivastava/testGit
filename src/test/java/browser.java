//Practice for singleton pattern
public class browser {

    //Create private variable, marked as volatile to ensure that each thread recieves its copy systematically
    private volatile static browser brow;

    //Create private constructor
    private browser()
    {

    }

    //Create getter method, but specify synchronized internally as we want the getInstance method to be accessible to all threads, but only the instance value to be accessible in stynchronized manner and hence the synchronized block is created below
    public static browser getInstance(){

        //Only if browser instance is null, which it would be in the first run, then only in synchronized manner threads would be able to access the insytance
        if(brow==null){
            synchronized(browser.class){
                brow=new browser();
            }
        }
        return brow;
    }

    public void display(){
        System.out.println("browser info");
    }
}
