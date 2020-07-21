package chapter2.demo1;

/**
 * lambda表达式形成过程
 */
public class LambdaMake {

    /*
    静态内部类
     */
    static class LikeImpl2 implements Like{
        @Override
        public void likeLambda() {
            System.out.println("I like Lambda 2");
        }
    }

    public static void main(String[] args) {
        //1.正常调用
        Like l1 = new LikeImpl();
        l1.likeLambda();
        //2.静态内部类调用
        Like l2 = new LikeImpl2();
        l2.likeLambda();

        /*
        局部内部类
         */
        class LikeImpl3 implements Like{
            @Override
            public void likeLambda() {
                System.out.println("I like Lambda 3");
            }
        }

        //3.局部内部类调用
        Like l3 = new LikeImpl3();
        l2.likeLambda();

        //4.匿名内部类，没有类的名称，必须借助接口或者父类
        Like l4 = new Like(){
            @Override
            public void likeLambda() {
                System.out.println("I like Lambda 4");
            }
        };
        l4.likeLambda();

        //5.lambda表达式
        Like l5 = ()-> System.out.println("I like Lambda 5");
        l5.likeLambda();
    }
}

