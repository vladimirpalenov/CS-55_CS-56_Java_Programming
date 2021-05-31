/public class Main
{
	 public static void main(String[] args) {
	    Sequence mySec = new Sequence();
        Thread thread1 = new Thread(new Runnable(){
            @Override
            public void run(){
                mySec.o();
            }
        });
        Thread thread2 = new Thread(new Runnable(){
            @Override
            public void run(){
                mySec.x();
            }
        });
        Thread thread3 = new Thread(new Runnable(){
            @Override
            public void run(){
                mySec.o();
            }
        });
        Thread thread4 = new Thread(new Runnable(){
            @Override
            public void run(){
                mySec.x();
            }
        });
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
		
	}


  public static class Sequence {
    private boolean isPrintX = true;
    public synchronized void x() {
        while (!isPrintX) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        isPrintX = false;
        System.out.println("X");
        notify();
    }
   public synchronized void o() {
        while (isPrintX) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        isPrintX = true;
        System.out.println("O");
        notify();
    }
}

}
