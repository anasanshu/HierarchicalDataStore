class HierarchicalDataStore{
    // private ArrayList<HierarchicalDataStore> children;
    // private String data;
    // private String nodeName;

    private ArrayList<Set<String>> nodes;
    private Map<String, String> map;

    public HierarchicalDataStore(String nodeName){
        // this.children.add(child);
        // this.data = data;
        this.nodeName = nodeName;
    }

    public void setData(String data){
        this.data = data;
    }

    public String getData(){
        return this.data;
    }

    // public void setNodeName(String nodeName){
    //     this.nodeName = nodeName;
    // }

    public String getNodeName(){
        return this.nodeName;
    }

    public void setChildren(HierarchicalDataStore child){
        this.children.add(child)
    }

    public HierarchicalDataStore getChildren(){
        return this.children;
    }
}