class Main{
    public static void main(String[] args){
        // To give input, uncomment the below two lines
        /*UserPresentation obj = new UserPresentation();
        obj.run();*/

        DataRepository dataRepository = new DataRepository();

        dataRepository.create("/root", "nothing");
        dataRepository.create("/root/child1", "childdata 1");
        dataRepository.create("/root/child2", "childdata 2");
        dataRepository.create("/root/child1/subchild1", "subchild1");

        dataRepository.printStore();

        dataRepository.list("/root");

        dataRepository.delete("/root/child2");
    }
}