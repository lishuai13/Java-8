##Stream笔记
```java
list.stream().filter((User u)->{return u.getAge()>21;})
                .map((User u)->{return u.getName().toUpperCase();})
                .sorted((String name1,String name2)->{return name2.compareTo(name1);})
                .forEach((String s)->{
                });
```
list.stream()会生成一个stream对象，而stream是一个泛型类，现在这个泛型类的参数是User了，他就会使得类中的方法的参数类型也变成User
```java
public interface Stream<T> extends BaseStream<T, Stream<T>>
```
然后stream.filter
```java
Stream<T> filter(Predicate<? super T> predicate);
```
由此可以看出stream中的方法会生成一个新的stream对象，而filter方法生成的新stream对象的类型还是T，也就是User，此外这是个Predicate函数式接口，返回值是布尔值，所以用于过滤
然后stream.map
```java
<R> Stream<R> map(Function<? super T, ? extends R> mapper);
```
易知map方法生成新stream对象参数类型是R，是Function接口返回值的类型，这里是String
然后stram.sorted
```java
Stream<T> sorted(Comparator<? super T> comparator);
```
同样新对象参数类型不变，还是String
然后stream.forEach
```java
void forEach(Consumer<? super T> action);
```
此方法参数是一个消费型函数式接口，也没再生成新的stream对象，只执行打印工作
结束