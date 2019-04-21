# Interview
``第一章
1、用java代码实现LinkedList的add()和remove()方法。要求自行设计LinkedList数据结构，不要外部类库和辅助函数来处理。
2、有三个线程ID分别是A、B、C,请用多线编程实现，在屏幕上循环打印10次ABCABC
请补充以下代码
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
  
3、写一段死锁的代码
4、网商银行和X银行联合出资向客户发放了一笔贷款，其中网商银行出资0.09元，X银行出资0.12元；贷款总共12期，客户看到的每期分期信息如下表格：
期号	分期开始时间	分期结束时间	分期本金
1	2017-01-01	2017-02-01	0
2	2017-02-01	2017-03-01	0
3	2017-03-01	2017-04-01	0
4	2017-04-01	2017-05-01	0
5	2017-05-01	2017-06-01	0
6	2017-06-01	2017-07-01	0.03
7	2017-07-01	2017-08-01	0.03
8	2017-08-01	2017-09-01	0.03
9	2017-09-01	2017-10-01	0.03
10	2017-10-01	2017-11-01	0.03
11	2017-11-01	2017-12-01	0.03
12	2017-12-01	2018-01-01	0.03
编写一段代码计算出每个机构的出资金额,要求机构每期出资金额比例约等于总出资比例！
期号	分期开始时间	分期结束时间	分期本金	机构分期出资本金	出资机构
1	2017-01-01	2017-02-01	0		网商
					X银行
2	2017-02-01	2017-03-01	0		网商
					X银行
3	2017-03-01	2017-04-01	0		网商
					X银行
4	2017-04-01	2017-05-01	0		网商
					X银行
5	2017-05-01	2017-06-01	0		网商
					X银行
6	2017-06-01	2017-07-01	0.03		网商
					X银行
7	2017-07-01	2017-08-01	0.03		网商
					X银行
8	2017-08-01	2017-09-01	0.03		网商
					X银行
9	2017-09-01	2017-10-01	0.03		网商
					X银行
10	2017-10-01	2017-11-01	0.03		网商
					X银行
11	2017-11-01	2017-12-01	0.03		网商
					X银行
12	2017-12-01	2018-01-01	0.03		网商
					X银行


//思路：每家公司需要支付的总钱数是固定的，最接近比例最多差1分，解决1分分配问题；
//totalPeriod 总期数，newPayPeriods需要还款期数 7 
public void method(int totalPeriod,int newPayPeriods){
 
 	BigDecimal rate = new Bigdecmial(0.09)/new Bigdecimal(0.12).setScale(2,RoundingMode.Round_down)
	//X银行的最小还款金额
	BigDecimal xBanklittle = new BigDecimal(0.03).abs(rate).setScale(1,RoundingMode.Round_down);
    BigDecimal xBankBig = xBanklittle.add(new Bigdecimal(0.01));
    //网上银行每期最小金额
    BigDecimal wsBanklittle = new BigDecimal(0.03).abs(rate).setScale(1,RoundingMode.Round_down);
    BigDecimal wsBankBig = xBanklittle.add(new Bigdecimal(0.01));
	
    //分配算法：期数/2且总和等于总还款金额；
    //一半最小金额，一半最小金额+0.01，最后一期=总金额-（最小金额+最小金额+0.01）*期数/2
    int center = newPayPeriods/2;
    
    BigDecimal [] xBankNeedPayArray = new Bigdecimal []();
    for (i=0;i<=center;i++){
    	xBankNeedPayArray[i] = xBanklittle;
    }
    for (i=center+1;i<newPayPeriods;i++){
    	xBankNeedPayArray[i] = xBankBig;
    }
    xBankNeedPayArray[newPayPeriods] = new Bigdecmial(0.09).sub(xBanklittle.add(xBankBig).center);
    
    BigDecimal [] wsBankNeedPayArray = new Bigdecimal []();
    for (i=0;i<=center;i++){
    	wsBankNeedPayArray[i] = xBanklittle;
    }
    for (i=center+1;i<newPayPeriods;i++){
    	wsBankNeedPayArray[i] = wsBankBig;
    }
    wsBankNeedPayArray[newPayPeriods] = new Bigdecmial(0.09).sub(wsBanklittle.add(wsBankBig).center)
    
}                    

5、收益分摊算法
/**
     * 假定A和B金融机构联合开展贷款业务，并约定所得利息收益按照2:1分配，总计贷款给了1万个人，
     * 对于每个人利息收益如何分配，才能保证尽可能公平（收益分配单位精确到分）
     *
     * @param amount 需要分摊的金额(单个人)
     * @param rateMap key为机构编码, value为占的比例
     * @return key为机构编码,value为分得的收益
*/
    public static Map<String, Long> allocate(Long amount, Map<String, Long> rateMap) {
        return null;
}
6、红包算法，输入红包金额和领取人数，返回每个人领取的红包金额,金额单位为分
Long[] allocate(Long amount, int nunmber);