package cn.nju.example;

/**
 * Author :hyr
 * date : 2020-01-08
 */

public class S02_Singleton{

    /**
     *  立即加载 ： 在类加载初始化的时候就主动创建实例；
     *  延迟加载 ： 等到真正使用的时候才去创建实例，不用时不去主动创建。
     *  在单线程环境下，单例模式根据实例化对象时机的不同，有两种经典的实现：
     *  一种是饿汉式单例(立即加载)，一种是懒汉式单例(延迟加载)。
     *  饿汉式单例在单例类被加载时候，就实例化一个对象并交给自己的引用；
     *  而懒汉式单例只有在真正使用的时候才会实例化一个对象并交给自己的引用。
     */

    // 饿汉式单例
    public static class Singleton1{
        private static Singleton1 singleton1 = new Singleton1();

        private Singleton1() {}

        public static Singleton1 getSingleton1(){
            return singleton1;
        }
    }

    // 懒汉式单例 线程不安全
    public static class Singleton2 {
 
        // 指向自己实例的私有静态引用
        private static Singleton2 singleton2;
     
        // 私有的构造方法
        private Singleton2(){}
     
        // 以自己实例为返回值的静态的公有方法，静态工厂方法
        public static Singleton2 getSingleton2(){
            // 被动创建，在真正需要使用时才去创建
            if (singleton2 == null) {
                singleton2 = new Singleton2();
            }
            return singleton2;
        }
    }


    // 线程安全的懒汉式单例
    public static class Singleton3 {
    
        private static Singleton3 singleton3;
    
        private Singleton3(){}
    
        // 使用 synchronized 修饰，临界资源的同步互斥访问
        public static synchronized Singleton3 getSingleton3(){
            if (singleton3 == null) {
                singleton3 = new Singleton3();
            }
            return singleton3;
        }
    }

    /**
     * 从执行结果上来看，问题已经解决了，
     * 但是这种实现方式的运行效率会很低，
     * 因为同步块的作用域有点大，而且锁的粒度有点粗。
     * 同步方法效率低，那我们考虑使用同步代码块来实现。
     */
    public static class Singleton4 {
        private static Singleton4 singleton4;

        private Singleton4() {}

        public static Singleton4 getSingleton4(){
            synchronized(Singleton4.class){
                if(singleton4==null){
                    singleton4 = new Singleton4();
                }
                return singleton4;
            }
        }
    }

    // 同步延迟加载 使用内部类实现延迟加载 【推荐】
    public static class Singleton5 {
 
        // 私有内部类，按需加载，用时加载，也就是延迟加载
        private static class Holder {
            private static Singleton5 singleton5 = new Singleton5();
        }
     
        private Singleton5() {
     
        }
     
        public static Singleton5 getSingleton5() {
            return Holder.singleton5;
        }
    }

    //双重检查模式【推荐】
    public static class Singleton6 {
    
        //使用volatile关键字防止重排序，因为 new Instance()是一个非原子操作，可能创建一个不完整的实例
        private static volatile Singleton6 singleton6;
    
        private Singleton6() {}
    
        public static Singleton6 getSingleton6() {
            // Double-Check idiom
            if (singleton6 == null) {
                synchronized (Singleton6.class) {       // 1
                    // 只需在第一次创建实例时才同步
                    if (singleton6 == null) {       // 2
                        singleton6 = new Singleton6();      // 3
                    }
                }
            }
            return singleton6;
        }
    }

    /**
     * 静态内部类，使用枚举方式，线程安全【推荐】
     */
    public enum Singleton7 {
        INSTANCE;

        public void whateverMethod() {

        }
    }
}