import java.rmi.Remote;
import java.util.*;

/**
 * Created by Q on 2016/5/4.
 */
public class Library {

    Set<Book> set = new HashSet<Book>();
    Set<Customer> com = new HashSet<Customer>();

    Library() {
        Book b1 = new Book("001", "程序员的职业素养", "Robert C.Maartin", "2012年9月", 50);
        Book b2 = new Book("002", "卓有成效的程序员", "Neal Ford       ", "2009年3月", 50);
        Book b3 = new Book("003", "测试驱动开发    ", "Kent Beck       ", "2004年3月", 50);
        Book b4 = new Book("004", "java开发        ", "AAAA            ", "2015年3月", 50);
        Book b5 = new Book("005", "数据结构        ", "BBBB            ", "2013年5月", 50);
        Book b6 = new Book("006", "软件工程        ", "CCCC            ", "2016年1月", 50);

        set.add(b1);
        set.add(b2);
        set.add(b3);
        set.add(b4);
        set.add(b5);
        set.add(b6);

        Customer c1 = new Customer("c001","张三");
        Customer c2 = new Customer("c002","李四");
        Customer c3 = new Customer("c003","王五");
        Customer c4 = new Customer("c004","赵六");

        com.add(c1);
        com.add(c2);
        com.add(c3);
        com.add(c4);

    }

    //查询用户
    public Customer selectCustomer(String cid) {
        for (Customer c : com) {
            if (c.getCid().equals(cid)) {
                return c;
            }
        }
        return  null;
        }

    //查询图书
    public Book selectBook(String id) {
        for (Book b : set) {
            if (b.getId().equals(id)) {
                return b;
            }
        }
        return null;
    }


    //显示所有图书
    public void allBook() {
        //使用set方法中的for循环遍历
        for (Book b : set) {
            System.out.println(b);
        }
    }

    //添加已有图书
    public void addBook(String id,int number) {
        for (Book b : set) {
            if (b.getId().equals(id)) {
                int a = b.getNumber();
                b.setNumber(number+a);
            }
        }
    }

    //添加新书
    public void addNewBook(String id, String name, String author, String date,int number) {
       /* Scanner in = new Scanner(System.in);*/
        Book nb = new Book();
        nb.setId(id);
       /* for (Book b : set) {
            if (b.getId().equals(id)) {
                System.out.println("您输入的书编号已经存在！");
            }
        }*/
        nb.setName(name);
        nb.setAuthor(author);
        nb.setDate(date);
        nb.setNumber(number);
        set.add(nb);

    }

    //删除图书
    public void deleteBook(String id) {
        //迭代
        Iterator<Book> it = set.iterator();
            while (it.hasNext()) {
                Book b = it.next();
            if (b.getId().equals(id)) {
                it.remove();
            }
        }
        //遍历输出
        for (Book b : set) {
            System.out.println(b);
        }
    }

    //借阅图书
    public boolean lendBooks(Customer c, String id) {
        Scanner in = new Scanner(System.in);
       /* Book b = null;*/
        Book b = selectBook(id);
        //表示：如果有这本书
        if (!(b == null)) {
            System.out.println(b);
            System.out.println("请输入借书的数量：");
            int num = in.nextInt();
            if (num > b.getNumber()) //您的借书数量大于馆藏数量
            {
                System.out.println("您的借书数量大于馆藏数量，借书失败！");
                return false;
            } else {
                set.remove(b); //先删除原来的数
                b.setNumber(b.getNumber() - num); //修改书的数量
                set.add(b); //再把修改后的图书资料，保存到图书馆图书数组里
                c.LendBook(b, num);//借书
                System.out.println("借书成功！");
                return true;
            }
        }
        System.out.println("图书不存在，借书失败！");
        return false;
    }

    //归还图书
    public void ReturnBook(Customer c,String id){
        Scanner in = new Scanner(System.in);
        Map<Book,Integer> book = c.getBook();
        Book b = selectBook(id);
        System.out.println("请输入归还书的数量：");
        int num = in.nextInt();
        set.remove(b);
        b.setNumber(b.getNumber()+num);
        set.add(b);
        System.out.println("还书成功");

    }
}




