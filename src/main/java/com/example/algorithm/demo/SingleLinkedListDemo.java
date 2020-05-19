package com.example.algorithm.demo;

/**
 * 单链表
 *  * @projectName algorithm
 *  * @title     LinkedList   
 *  * @package    com.example.algorithm.demo  
 *  * @author Administrator     
 *  * @date   2020/5/18 0018 星期一
 *  * @version V1.0.0
 *  
 */
public class SingleLinkedListDemo {
    public static void main(String[] args) {

        SingleLinkedList singleLinkedList = new SingleLinkedList();
        HeroNode heroNode1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode heroNode2 = new HeroNode(2, "吴用", "智多星");
        HeroNode heroNode3 = new HeroNode(3, "林冲", "豹子头");
        singleLinkedList.add(heroNode1);
        singleLinkedList.add(heroNode2);
        singleLinkedList.add(heroNode3);

        singleLinkedList.list();

        System.out.println("有序....");
        SingleLinkedList addByOrderList = new SingleLinkedList();
        HeroNode addByOrder1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode addByOrder2 = new HeroNode(2, "吴用", "智多星");
        HeroNode addByOrder3 = new HeroNode(3, "林冲", "豹子头");
        HeroNode addByOrder4 = new HeroNode(4, "林冲4", "豹子头4");

        addByOrderList.addByOrder(addByOrder1);
        addByOrderList.addByOrder(addByOrder2);
        addByOrderList.addByOrder(addByOrder4);

        addByOrderList.addByOrder(addByOrder3);

        addByOrderList.list();

        System.out.println("修改后......");
        HeroNode update = new HeroNode(4, "林冲12", "豹子头12");

        addByOrderList.update(update);
        addByOrderList.list();

        System.out.println("删除后...");
        addByOrderList.del(1);
        addByOrderList.list();

    }
}

class SingleLinkedList {
    /**
     * 初始化头节点
     */
    private HeroNode head = new HeroNode(0, "", "");

    /**
     * 新增   无序
     */
    public void add(HeroNode heroNode) {
        // 头节点不能动 ，使用一个临时节点指向头节点
        HeroNode temp = head;
        // 遍历找到最后一个节点
        while (true) {
            // 当下一个节点是null ，当前节点为最后节点
            if (temp.next == null) {
                break;
            }
            // 如果没有找到就往后移一个
            temp = temp.next;

        }
        temp.next = heroNode;
    }

    /**
     * 新增 有序
     */
    public void addByOrder(HeroNode heroNode) {
        HeroNode temp = head;

        // 判断新增编号是否存在，默认为false
        boolean flag = false;
        while (true) {
            // 已经到了链表最后
            if (temp.next == null) {
                break;
            }
            // 位置找到了 就在temp后面插入
            if (temp.next.no > heroNode.no) {
                break;
                // 新增的编号已经存在
            } else if (temp.next.no == heroNode.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }

        // 不能新增，编号已存在
        if (flag) {
            System.out.println("新增的hero编号已经存在，不能新增：" + heroNode.no);
        } else {
            heroNode.next = temp.next;
            temp.next = heroNode;

        }
    }

    public void update(HeroNode heroNode){
        // 判断链表不为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }

        // 找到需要修改的节点
        HeroNode temp = head.next;
        // 表示是否找到需要修改的节点
        boolean flag = false;
        while (true) {
            if (head == null) {
                break;
            }
            if (temp.no == heroNode.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }

        // 判断是否找到需要修改的节点
        if (flag) {
            temp.name = heroNode.name;
            temp.nickName = heroNode.nickName;
        } else {
            System.out.println("没有找到编号为：" + heroNode.no);
        }
    }

    public void del(int no){
        HeroNode temp = head;

        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no == no) {
                // 找到删除节点
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.next= temp.next.next;
        }else {
            System.out.println("没有找到删除节点："+ no);
        }

    }

    /**
     * 显示所有元素
     */
    public void list() {
        // 判断链表不为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        // 头节点不能动 ，使用一个临时节点指向头节点
        HeroNode temp = head.next;
        while (true) {
            // 判断链表到了最后一个元素
            if (temp == null) {
                break;
            }
            // 输出节点信息
            System.out.println(temp.toString());
            temp = temp.next;
        }

    }
}


/**
 * 定义一个 heroNode  每个 heroNode对象就是一个节点
 */
class HeroNode {
    int no;
    String name;
    String nickName;
    /**
     * 指向下一个节点
     */
    HeroNode next;

    public HeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
