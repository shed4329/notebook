java集合类

位于java.util包中

1、集合只能存放对象，如果存int，实际上存入的是Integer

2、集合可以存放不同类型，不限数量的数据类型

**Hashset**

Hashset是set的典型实现，Hashset是按照hash算法来储存集合中的元素，具有很好的存取和查找性能

    1.不能保障元素顺序

    2.不可重复

    3.不是线程安全的

    4.集合元素可以为null

如果两元素equals（）为true，但hashcode（）返回值不同，hashSet会将其存放在不同位置，仍然可以添加成功

`import java.utils.Set; `

`import java.util.HashSet; `

`public static Test{`

        `public static void main(String[] args){`

            `Set set = new HashSet();`

              ` //add方法`

           ` set.add(1);`  

             `set.add(1);//重复的元素只会存一个`

            `set.add("114514");`

              `  //remove`

           ` set.remove(1);`

               ` //contains`

           ` System.out.println(set.contains("a"));`

                `//clear`

          `  set.clear();`

               ` //遍历`

               ` //Iterator`

              `  Iterator it = set.iterator();`

             `   while(it.hasNext()){`

                   ` System.out.println(it.next());`

               ` }`

               ` //foreach`

                `for(Object obj : set){`

                    `System.out.println(obj);`

               ` }`

            `//集合元素大小`

          `  System.out.println(set.size());`

   ` }`

`} `

如果想要只能存储一种数据类型

`Set<String> set1 = new HashSet<String>();`

**TreeSet**

treeset是sortedset接口的实现类，treeset可以保证元素处于排序状态，支持自然排序和定制排序

main方法~~

Set<Integer> set=new TreeSet<Integer>();

set.add(5);

set.add(4);

set.add(2);

set.add(3);

//2,3,4,5

set.remove(5);

set.contains(3);

set.clear();

//遍历方法同上

treeset类型必须相同

定制排序

自己定义数据类型，并实现排序，帮助treeset排序

```
class Person implements Comparator<Person>{

int age;

String name;

@Override
public int compare(Person o1,Person o2){//正序排列，也可以自己定义为倒序排列
    if(o1.age>o2.age){
        return 1;
    }else if(o1.age=o2.age){
        return 0;
    }else{
        return -1;
    }
}
public person(){

}

public Person(String name,int age){

    this.name = name;
    this.age=age;

    }

}
```

**List与ArrayList**

元素有序，可重复，以添加方式定义索引

```
import java.util.List;
import java.util.ArrayList;

public class Test{
    public static void main(String[] args){
    List<String> list = new ArrayList<String>();
    list.add("b");//索引下标0
    list.add("a");
    list.add("d");
    list.add("c");//[b,a,d,c]
    list.get(2);
    list.add(1,"f");//在指定索引下标位置插入，[b,f,a,d,c]

    List<String> l = new ArrayList<String>();
    l.add("123");
    l.add("456");
    list.addAll(2,l);//[b,f,123,456,a,d,c]
    
    list.indexOf("a");//第一次出现的索引下标
    list.lastIndexOf("d");//最末一次
    
    list.remove(2);//[b,f,456,a,d,c]

    list.set(1,"fx");//[b,fx,456,a,d,c]

    List<String> sublist = list.subList(2,4);//截取到[456,a]
    //包含开始的索引，不包含结束的索引
    
    list.size();//集合的长度
    }
}
```

vector是个古老的集合，很不推荐，vector线程安全，ArrayList线程不安全

**Map**

Map用于保存具有映射关系的数据，因此Map集合里面保存着两组值，一组为Key，一组为Value,Key和Value都可以是任何引用类型的数据，Key值不允许重复

HashMap经典实现

```
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.Map.Entry;

public class Test{
    public static void main(String[] args){
        Map<String,Integer> map = new HashMAp<String,Integer>();
        map.put("a",1);//添加数据
        map.put("b",2);
        map.put("c",3);

        map.get("a");//用key调取值,返回1
        map.remove("c");
        map.size();

        map.containsKey("b");//包含键b
        map.containsValue(114514);//是否包含值
        
        //遍历
        map.keySet();//获取map的key集合
        map.values();//值集合
        Set<String> keys = map.keySet();
        for(String key:keys){
            System.out.println("key: "+key+", value"+map.get(key));
        }
        //遍历2
        Set<Entry<String,Integer>> entrys = map.entrySet().
        for(Entry<String,Integer> en:entrys){
             System.out.println("key: "+en.getKey()+",value:"+en.getvalue());   
        }
    }
}
```

hashtable是一个古老的Map实现类，不推荐使用

Hashtable线程安全，HashMap线程不安全

Hashtable不允许key和null做key和value，但HashMap可以

都不能保证key-value顺序

Hashtable,HashMap，按照equals为true和hashcode相等判断

TreeMap

treemap可以保证有序状态

可自然排序，可定制排序

```java
import java.util.Map;
import java.util.TreeMap;
import java.util.Set;
import java.util.Map.Entry;

public class Test{
    public static void main(String[] args){
        Map<Integer,String> map = new TreeMap;
        map.put(4,"a");
        map.put(2,"a");
        map.put(3,"a");
        map.put(1,"a");//按key排序，数字排序先于字母
    }
}
```

**Collection**

Collection 是一个操作Set，List和Map等集合的工具类

排序

```java
import java.util.List;
import java.util.ArrayList;
import java.util.Collection


public class Test{
    public static void main(String[] args){
        List<String> list = new ArrayList<String>();
        list.add("b");
        list.add("cd");
        list.add("df");
        list.add("pm");
        list.add("9");//[b,cd,df,pm,9]
        //反转元素顺序
        Collections.reverse(list);//[9,pm,df,cd,b]
        //随机排布
        Collections.shuffle(list);//[pm,b,cd,df,9]
        //升序排列
        Collections.sort(list);//[9,b,cd,df,pm]

        Student s1 = new Student(14,"张三");
        Student s2 = new Student(12,"李四");
        Student s3 = new Student(14,"王五");
        Student s4 = new Student(11,"Lucy");
        List<Student> stus = new ArrayList<Student>();
        stus.add(s1);
        stus.add(s2);
        stus.add(s3);
        stus.add(s4);
        Collections.sort(stus,new Student());//定制化排列顺序

        //集合中的元素交换位置
        Collections.swap(list,0,4);//[pm,b,cd,df,9]
        System.out.println(Collection.max(list));//返回自然排序中的最大值
        System.out.println(Collection.min(list));//返回自然排序中的最小值
        Student s = Coolection.max(stus,new Student());//定制化顺序最大值
        //出现频率
        list.add("b");
        list.add("b");
        System.out.println(Collection.frequency(list,"b"));//返回值为3
        Collections.rreplacrAll(list,"a","aa");//用新值aa替换所有旧值a
    }
}


class Student implements Comparator<Student>{
    int age;
    String name;
    public Student(){

    }
    public Student(int age,String name){
        this.age = age;
        this.name = name;
    }
    @Override
    public int compare(Student o1,Student o2){
        if(o1.age>o2.age){
            return 1;
        }else if(o1.age<o2.age){
            return -1;
        }else{
            return 0;
        }
    }
}
```
