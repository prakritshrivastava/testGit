public class testBrowser {

    public static void main(String[] args)  {

        //Below is a functional interface
        Runnable task=()->{
            browser.getInstance().display();
        };

        //Trying multithreading
        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);
        Thread thread3 = new Thread(task);

        thread1.start();
        thread2.start();
        thread3.start();

        try{
            thread1.join();
            thread2.join();
            thread3.join();

        }
        catch (InterruptedException intExp){
            System.out.println(intExp.getMessage());
        }

    }

}
