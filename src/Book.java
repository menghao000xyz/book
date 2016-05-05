/**
 * Created by Q on 2016/5/4.
 */
public class Book {

    private String id;
    private String name;
    private String author;
    private String date;
    private int number;


    //定义属性的get和set方法
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    //定义无参构造函数
    public Book() {

    }


      public Book(String id, String name, String author, String date,int number) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.date = date;
        this.number = number ;
    }


    @Override
    public String toString() {
        return
                "图书编号=" + id +
                "                     图书名称=" + name +
                "                     图书作者=" + author +
                "                     出版日期=" + date +
                "                     图书数量=" + number  ;
    }


}
