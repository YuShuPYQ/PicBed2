package Com.XiHongShi;

public class FZtest {

    public static void main(String[] args) {
        FenZhuang fenZhuang= new FenZhuang();

        fenZhuang.setAge(18);
        fenZhuang.setName("张国荣");


        System.out.println("他"+fenZhuang.getAge()+"叫" +fenZhuang.getName());
    }
}
