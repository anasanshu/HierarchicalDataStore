class Main{
    public static void main(String[] args){
        DataRepository obj = new DataRepository();
        obj.create("/root/child1", "child1");
        obj.create("/root/child1/subchild1", "subchild1");
        System.out.println("get(/root/child1/subchild1) = "+obj.get("/root/child1/subchild1"));
        obj.update("/root/child1", "updated child");
        System.out.println("get(/root/child1) = "+obj.get("/root/child1"));
    }
}