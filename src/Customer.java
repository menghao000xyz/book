import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Customer {

    private String cid; //借书号
    private String name;//姓名
    private Map<Book,Integer> book; //表示借的所有图书

    //定义无参构造函数
    public Customer()
    {

    }

    //定义属性的get和set方法
    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<Book, Integer> getBook() {
        return book;
    }

    public void setBook(Map<Book,Integer> book) {
        this.book = book;
    }




    public Customer(String cid, String name)
    {
        this.cid = cid;
        this.name = name;
        book = new HashMap<Book,Integer>();
    }




    //借书的方法
    public void LendBook(Book b,int num)
    {
        this.getBook().put(b,num);
    }

  /*  //还书方法
    public void ReturnBook(Book b,int num)
    {
        this.getBook().put(b, (this.getBook().get(b)+num));
    }
*/


}
