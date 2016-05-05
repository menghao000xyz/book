import com.sun.xml.internal.ws.api.streaming.XMLStreamReaderFactory;

import java.util.Scanner;
/**
 * Created by Q on 2016/5/4.
 */
public class BookSystem {

    private static Scanner input = new Scanner(System.in);
    private static int xx;
    private static int num;
    private static String a;
    private static String b;
    private static Library library =new Library() ;

    String id;

    public static void menu(){
        System.out.println("***************************************************");
        System.out.println("欢迎来到图书管理系统");
        System.out.println("1.查看所有图书");
        System.out.println("2.查询图书");
        System.out.println("3.添加图书");
        System.out.println("4.删除图书");
        System.out.println("5.借阅图书");
        System.out.println("6.归还图书");
        System.out.println("7.离开");
        System.out.println("***************************************************");
        System.out.println("请输入1—7");
        System.out.println("***************************************************");
        Scanner input = new Scanner(System.in);

    }

    public static void main(String[] args) {

        BookSystem.menu();
        String id;
        Customer c;
        String cid;

       /* Scanner input = new Scanner(System.in);*/

        while(input.hasNext() == true) {
            int xx = input.nextInt();

            switch (xx) {
                //查询全部图书
                case 1:
                    System.out.println("显示已有图书如下：");
                    System.out.println("***************************************************");
                    library.allBook();
                    System.out.println("***************************************************");
                    break;

                //查询图书
                case 2:
                    System.out.println("请输入图书编号：");
                    id = input.next();
                    Book b = library.selectBook(id);
                    /* Customer b = library.selectCustomer(id);*/
                    if (b != null) {
                        System.out.println("您查询的图书资料如下：");
                        System.out.println(b);
                    } else {
                        System.out.println("很抱歉，您查询的图书不存在！");
                    }
                    break;

                //添加图书
                case 3:
                    System.out.println("a：添加已有图书");
                    System.out.println("b：添加新书");
                    //添加图书
                    if (input.hasNext() == true) {
                        String num = input.next();
                        if (num.equals("a")) {
                        //添加已有图书
                            library.allBook();
                            System.out.println("输入图书编号");
                            id = input.next();
                            b = library.selectBook(id);
                            System.out.println(b);
                            System.out.println("添加图书数量");
                            int number = input.nextInt();
                            library.addBook(id,number);
                            library.allBook();

                        }
                        //添加新书
                        if (num.equals("b")) {
                            library.allBook();
                            System.out.println("输入新书编号");
                            id = input.next();
                            System.out.println("输入新书名称");
                            String name = input.next();
                            System.out.println("输入新书作者");
                            String author = input.next();
                            System.out.println("输入新书出版时间");
                            String date = input.next();
                            System.out.println("输入新书数量");
                            int number = input.nextInt();
                            library.addNewBook(id,name,author,date,number);
                            library.allBook();
                        }
                    }
                    break;


                //删除图书
                case 4:
                    System.out.println("删除图书：");
                    library.allBook();
                    System.out.println("请输入图书编号：");
                    id = input.next();
                    b = library.selectBook(id);
                    if (id != null) {
                        System.out.println("删除图书成功！");
                        library.deleteBook(id);
                    }
                    break;


                //借用图书
                case 5:
                    System.out.println("请输入借书号：");
                    cid = input.next();
                    c = library.selectCustomer(cid);
                    library.allBook();
                    System.out.println("请输入图书编号：");
                    id = input.next();
                    library.lendBooks(c, id);
                    library.allBook();
                    break;

                //归还图书
                case 6:System.out.println("请输入借书号：");
                    cid = input.next();
                    c = library.selectCustomer(cid);
                    library.allBook();
                    System.out.println("输入归还的图书编号：");
                    id = input.next();
                    library.ReturnBook(c,id);
                    library.allBook();
                    break;

                //退出
                case 7:
                    System.out.println("谢谢使用！");
                    System.exit(7);
            }
            System.out.println("                                                   ");
            System.out.println("                                                   ");
            System.out.println("                                                   ");
            BookSystem.menu();
        }
    }
}
