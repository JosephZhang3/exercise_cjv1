package powerful_skills;

public class Normal {

    public static void main(String[] args) {
        // 查看JDK指令位数 32bit/64bit
        String arch = System.getProperty("sun.arch.data.model");
        System.out.println(arch);


    }
}
