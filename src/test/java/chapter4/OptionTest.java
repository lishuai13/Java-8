package chapter4;

import entity.Menu;
import org.junit.Test;

import java.util.Optional;


/**
 * Option对象的使用
 */
public class OptionTest {

    //创建option对象然后取出
    @Test
    public void whenCreateEmptyOptional_thenNull() {
        Menu menu = new Menu("John",100.00);
        //创建对象
        Optional<Menu> op = Optional.of(menu);
        //若不空,执行操作
        op.ifPresent(u-> System.out.println(u.getName()));
        //若不空，输出
    }

    //orElse,若前者为空则返回后者，否则返回前者
    @Test
    public void whenEmptyValue_thenReturnDefault() {
        Menu menu1 = null;
        Menu menu2 = new Menu("John",100.00);
        Menu result = Optional.ofNullable(menu1).orElse(menu2);

        System.out.println(menu2==result);
    }

    //orElseThrow,当传入的值为空时，抛出异常
    @Test
    public void whenThrowException_thenOk() {
        Menu menu = new Menu("John",100.00);
        Menu menu1 = Optional.ofNullable(menu).orElseThrow(() -> new IllegalArgumentException());
        System.out.println(menu1);

    }

    //Optional的链式调用，类似于stream,多了项若结果为空，还能经行操作
    @Test
    public void whenMap_thenOk() {
        Menu menu = new Menu("John",100.00);
        String name = Optional.ofNullable(menu)
                .filter(menu1 -> menu1.getWeight()>970)
                .map(u -> u.getName()).orElse("tom");
        System.out.println(name);
    }

}
