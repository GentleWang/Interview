package chapter1.q1_1;

/**
 * @description:
 * 用java代码实现LinkedList的add()和remove()方法。要求自行设计LinkedList数据结构，不要外部类库和辅助函数来处理。
 *
 */
public class MyLinkedList {



        private Node first;
        private Node last;

        private int size;

        //[]
        //['a','b','c']
        public void add(Object obj){
            Node node = new Node(obj);

            if(first == null){

                node.previous = null;
                node.next = null;

                first = node;
                last = node;
            }else{
                node.previous = last;
                node.next = null;

                last.next = node;
                last = node;
            }
            size++;
        }

        //根据下标删除数据
        public void remove(int index){
            Node temp = getNode(index);

            if(temp != null){
                Node up = temp.previous;
                Node down = temp.next;

                //被删除的元素是第一个时
                if(index == 0){
                    first = down;
                }

                //被删除的元素是最后一个时候
                if(index == size-1){
                    last = up;
                }

                if(up!=null){
                    up.next = down;
                }
                if(down!=null){
                    down.previous = up;
                }
                size--;
            }
        }

        //根据下标获取节点（代码重用）
        public Node getNode(int index){
            Node temp = null;
            if(index < (size>>1)){ //size >>1 相当于除以2
                temp = first;
                for(int i=0; i<index; i++){
                    temp = temp.next;
                }
            }else{
                temp = last;
                for(int i=size-1; i>index; i--){
                    temp = temp.previous;
                }
            }
            return temp;
        }


        //[]
        //[a,b,c,d,e,f]  c-2
        public Object get(int index){

            if(index <0 || index >size - 1){
                throw new RuntimeException("索引數字不合法："+index);
            }
            Node temp = getNode(index);
            return temp !=null ? temp.element : null;
        }


        @Override
        public String toString() {
            //[a,b,c] first=a, last=c
            StringBuilder sb = new StringBuilder("[");
            Node temp = first;
            while(temp != null){
                sb.append(temp.element+",");
                temp = temp.next;
            }
            sb.setCharAt(sb.length()-1, ']');
            return sb.toString();
        }



        public static void main(String[] args) {
            MyLinkedList list = new MyLinkedList();

            list.add("a");
            list.add("b");
            list.add("c");
            list.add("d");
            list.add("e");
            list.add("f");

            list.remove(5);
            System.out.println(list);
        }



}

class Node {

    Node previous; //上一个节点
    Node next;  //下一个节点
    Object element;  //元素数据

    public Node(Node previous, Node next, Object element) {
        super();
        this.previous = previous;
        this.next = next;
        this.element = element;
    }

    public Node(Object element) {
        super();
        this.element = element;
    }

}