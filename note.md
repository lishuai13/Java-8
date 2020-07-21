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

##收集器总结
1.若传入的数组对象是有序的，那么它就会被有序地处理，反之则会被无需地处理。  
2.使用收集器的方法是需要关注方法的参数是什么,若是Function类型的接口，则可以将之前的map转换操作，放在Function中的apply中去执行，
等待，而一些方法参数类型是固定的，比如说maxBy固定需要比较器类型的参数
分组和分类也不同，分类方法的参数是Predicate函数型接口，因此必须返回一个布尔值，而分类是Function类型，就是通过属性字段来分组.        
3.很多方法都能够使用简写的方式"::"，凡是使用lambda表达式的地方。就能偶使用"::",标准语法为 Classname::methodName。
```java
artist->artist.getName
Artist::getName
```
创建一个新对象
```java
(name, nationality) -> new Artist(name, nationality)
Artist::new
```