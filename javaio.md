流

System.out.println();用了PrintStream/PrintWriter

随机存取文件流

可定义文件读写位置



**File**

```java
import java.io.File;
public class Test{
    public static void main(String[] args){
        File f = new File("D:\\test\\abc\\tt.txt");
        File f1 = new File("D:\\test","abc\\tt.txt");//两种构造方法
        
        //注意，\代表转义，\\代表'\',也可以用\代表分隔符
        File.separator;//用于操作平台不同，分隔符不一样，File.separator在不同平台下代表不同分隔符
        
    }
}
```

file只能操作文件本身，不能操作内容

方法

文件名

getName();//获取文件名或目录名

getPath();//获取路径，如果用的相对路径new的对象，返回相对路径

getAbsolutePath();

getAbsoluteFile();//返回用绝对路径构建的File对象

getParent();//返回父目录，可能是相对路径

renameTo(new File());//重命名

文件检测

exists();//文件是否存在

canRead();//不存在就不可读

canWrite();

isFile();//是否是文件

isDirectory();//是否为文件夹

文件信息

lastModified();//最后修改时间，返回毫秒数

length();//返回文件长度，单位字节

文件操作

createNewFile();//创建新文件

delete();//删除文件

目录操作

mkdir();//创建单层目录，多级目录一个一个的创建

mkdirs();//遇见没有的目录就创建，可以创建多级目录

list();//返回String[]

listFiles();//返回File[]



**遍历文件夹**

```java
public class Test{
    public void test(File f){
        if(file.isFile()){
            System.out.println(file.getAbsolutePath()+"是文件");
        }else{
            System.out.println(file.getAbsolutePath()+"是文件夹");
            File[] fs = file.listFiles();
            if(fs!=null&&fs.length>0)
            for(File ff:fs){
                test(ff);
            }
        }
    }
}
```

字节流(8 bit)和字符流（16bit）（Reader和Writer）
