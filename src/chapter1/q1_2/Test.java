package chapter1.q1_2;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * description:
 * 1_2、有三个线程ID分别是A、B、C,请用多线编程实现，在屏幕上循环打印10次ABCABC
 * 请补充以下代码
 * public class Test {
 *     public static void main(String[] args) {
 *         MajusculeABC maj = new MajusculeABC();
 *         Thread t_a = new Thread(new Thread_ABC(maj , 'A'));
 *         Thread t_b = new Thread(new Thread_ABC(maj , 'B'));
 *         Thread t_c = new Thread(new Thread_ABC(maj , 'C'));
 *         t_a.start();
 *         t_b.start();
 *         t_c.start();
 *     }
 * }
 */
public class Test {


    public static void main(String[] args) {
        MajusculeABC maj = new MajusculeABC();
        Thread t_a = new Thread(new Thread_ABC(maj , 'A'));
        Thread t_b = new Thread(new Thread_ABC(maj , 'B'));
        Thread t_c = new Thread(new Thread_ABC(maj , 'C'));
        t_a.start();
        t_b.start();
        t_c.start();
    }
}

class MajusculeABC {
    //原子变量0,1,2
    private AtomicInteger num = new AtomicInteger(0);

    public void numIncrease(){
        //num递增函数，如果当前是2，num递增之后变成0；
        if(num.get() != 2){
            //原子函数，线程安全自加操作
            num.incrementAndGet();
        }else{
            num.set(0);
        }
    }

    public int get(){
        return num.intValue();
    }
}


class Thread_ABC implements Runnable {

    private MajusculeABC maj = null;
    private final char param;
    Thread_ABC(MajusculeABC maj,char param){
        this.maj = maj;
        this.param = param;
    }

    public void run(){
        for(int i = 1;i<10;i++){
            //阻塞，等待自己的数字出现之后输出
            while(true){
                //用char与0,1,2作比较，'A'-65 == 0;
                if((param - 65) == maj.get()){
                    System.out.print(param);
                    maj.numIncrease();
                    break;
                }

            }

        }
    }


}