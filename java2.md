**泛型**

泛型只有在编译时有效，编译检验了泛型结果后，会擦出泛型相关信息，并且在对象进入和离开方法的边界处添加类型检测和类型转换的方法

**泛型类**

```java
//此处的泛型T可以任意取名，一般用T，意为type
class A<T>{
    private T key;
    public void setKey(T key){
        this.key = key;
    }
    public T getKey(){
        return this.key;
    }
}
```

用法

```java
public class Test{
    public static void main(String[] args){
        A<String> a1 = new A<String>();//在new A这个对象的时候，
        a1.setKey("xxx");
        String str = a1.getKey();

        A<Integer> a2 = new A<Integer>();
        a2.setKey(1);
        Integer i = a2.getKey();

        A a3 = new A();
        a3.setKey(new Object());//不指定泛型，则泛型为Object
        Object obj = a3.getKey();
        //同样的类，指定了不同的数据类型，不同数据类型对象不可以相互赋值
    }
}
```

**泛型接口**

```java
public class Test{
    public static void main(String[] args){
        B1<Object> b1 = new B1<Object>();//创建对象时建议添加泛型
        B2 b2 = new B2();//已定义了泛型类型，new不能指定泛型
    }
}

interface IB<T>{
    T test(T t);
}

class B1<T> implements IB<T>{//没有指定泛型实参，类声明也要加泛型
    @Override
    public T test(T t){
        return t;
    }
}


class B2 implements IB<String>{
    @Override
    public String test(String t){//如果实现接口时指定了泛型具体类型，那么泛型就要换成具体的数据类型

    }
}
```

**泛型方法**

```java
class Cc<E>{
    private E e;//如果类定义了泛型，可以用泛型定义成员变量
    public <T> void test(T t){//方法中定义泛型，可以在方法中的
        T tt = t;
    }
    public <T>  T test1(T t){//有返回值的泛型
        System.out.println(this.e);
        return s;
    } 
    public void test2(String... strs){//可变参数
        for(String s : strs){
            System.out.println(s);
        }
    }  
    public <T> void test3(T... ts){//泛型改造
        for(T t : ts){
            System.out.println(t);
        }
    }
    public static void test4(){
    //静态方法无法使用类定义的泛型成员变量，如果要使用，只能静态方法自己指定泛型
    }
    public static <T> void test5(){
        System.out.println(this.e);
    }
}
```

**通配符**

```java
import java.util.List
import java.util.ArrayList;

public class Test{
    public static void main(String[] args){
        Dd d = new Dd();
        List<String> li = new ArrayList<String>();
        d.test(li);

        List<String> li2 = new ArrayList<String>();
        d.test(li2);
    }
}
class Dd{
    public void test(List<?> list){//通配符？，数据类型不明确

    }
    public void test1(List<? extends C1> list){//通配符做限制，C1和子类

    }
    public void test2(List<? super C1> list){//通配符做限制，C1和父类

    }
    public void test3(List<? extends IA> list){//IA接口的实现类

    }
}

class A1{}
class B1 extends A1{}
class C1 extends B1{}
class D1 extends C1{}
interface IA{}
class IAImpl implements IA{}
```

**枚举类**

```java
public class Test{
    public static void main(String[] args){
        Season spring = Season.SPRING;
        spring.showInfo();
        spring.test();
    }
}
enum Season implements ITest{//枚举类可以实现接口
    SPRING("春天","春暖花开");//调用season的构造方法创建对象
    SUMMER("夏天","夏日炎炎");
    AUTUMN("秋天","秋高气爽");
    WINTER("冬天","寒风凌冽");
    private final String name;
    private final String desc;
    private Season(String name,String desc){
        this.name = name;
        this.desc = desc;
    }
    public void showInfo(){
        System.out.println(this.name+"      "+this.desc)
    }
    @Override
    public void test(){
        System.out.println("枚举类实现的接口");
    }
}

interface ITest{
    void test();
}
```

**注解/Annotation**

```java
import java.util.List
import java.util.ArrayList;

public class Test{
    
}

class TestA{
    public void test(){}
}

class TestB extends TestA{
    @TestAnn(id=100,desc="姓名");
    String name;//给属性注解

    @Override//注解，表示重写
    public void test(){
        super.test();
    }
    @Deprecated//表示该方法已过时
    public void test1(){
    
    }
    @SuppressWarning("rawtypes");
    @SuppressWarning("unused");//抑制编译器警告，可以用于IDE的黄叹号
    List list = new ArratList();
}

//自定义注解
@Target(ElementType.FIELD);//注解属性
@Retenction(RetentionPolicy.RUNTIME);//定义注解生命周期
@Documented
@interface TestAnn{
    public int id() default 0;
    public String desc() default "";
}
```
