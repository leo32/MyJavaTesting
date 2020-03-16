import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class TestCoreCPU {
    private long count = 0;
    private void add10K() {
        int idx = 0;
        while(idx++ < 10000) {
            set(get()+1);
        }
    }
    synchronized long get(){
        return count;
    }
    synchronized void set(long v){
        count = v;
    }

    @Test
    public  void calc() {
        try{
            // 创建两个线程，执行 add() 操作
            TestCoreCPU t=new TestCoreCPU();
            Thread th1 = new Thread(()->{
                t.add10K();

            });
            Thread th2 = new Thread(()->{
                t.add10K();
            });
            // 启动两个线程
            th1.start();
            th2.start();
            // 等待两个线程执行结束
            th1.join();
            th2.join();
            System.out.print(t.count);
        }
        catch(Exception e){

        }
    }
}
