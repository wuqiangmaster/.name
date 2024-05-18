package com.wuqing.main;

import com.wuqing.service.StudentService;

import java.util.Scanner;

public class RunApplication {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        init();
    }

    public static void init() {
        System.out.println("-----学生管理系统-----");
        System.out.println("\n1、输出全部学生信息");
        System.out.println("2、查找学生部分信息");
        System.out.println("3、更新学生全部信息");
        System.out.println("4、更新学生部分信息");
        System.out.println("5、删除学生");
        System.out.println("6、添加学生");
        System.out.println("7、退出");
        functionService();
    }

    public static void functionService() {
        while (true) {
            System.out.println("\n请输入要执行的操作编号：");
            switch (scanner.nextLine()) {
                case "1":
                    StudentService.selectAll().forEach(System.out::println);
                    break;

                case "2":
                    System.out.println("请输入字段名与字段值:");
                    System.out.println(
                            StudentService.selectByField(scanner.next(), scanner.next()));
                    break;
                case "3":
                    System.out.println("请输入学生学号，姓名，年龄，性别，电话，邮箱，地址");
                    System.out.println(StudentService.updateAll(scanner.next(), scanner.next(),
                                                                scanner.next(), scanner.next(),
                                                                scanner.next(), scanner.next(),
                                                                scanner.next()));
                    break;
                case "4":
                    System.out.println("请输入学号，字段名，字段值:");
                    System.out.println(StudentService.updateByNumber(scanner.next(), scanner.next(),
                                                                     scanner.next()));
                    break;
                case "5":
                    System.out.println("请输入学号");
                    System.out.println(StudentService.deleteByNumber(scanner.next()));
                    break;
                case "6":
                    System.out.println("请输入学生学号，姓名，年龄，性别，电话，邮箱，地址");
                    System.out.println(StudentService.insert(scanner.next(), scanner.next(),
                                                                scanner.next(), scanner.next(),
                                                                scanner.next(), scanner.next(),
                                                                scanner.next()));
                    break;
                case "7":
                    System.out.println("感谢使用学生管理系统，再见！");
                    System.exit(0); // 退出程序
                    break;
                default:
                    System.out.println("输入的操作编号无效，请重新输入。");
                    init();

            }
            System.out.println("请输入回车以继续操作");
            scanner.nextLine();
        }
    }
}
